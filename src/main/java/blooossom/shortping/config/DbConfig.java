package blooossom.shortping.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
@EnableJpaRepositories(
        basePackages = "blooossom.shortping.repository",
        entityManagerFactoryRef = "em",
        transactionManagerRef = "tm"
)
@ConfigurationProperties(prefix = "db.datasource")
public class DbConfig {

    @Value("${db.datasource.dialect}")
    private String DB_DIALECT;

    @Value("${db.datasource.jdbc-url}")
    private String jdbcUrl;

    @Value("${db.datasource.username}")
    private String username;

    @Value("${db.datasource.password}")
    private String password;

    @Value("${db.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${db.datasource.schema}")
    private String schema;

    @Primary
    @Bean("ds")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setSchema(Const.SCHEMA);
        return dataSource;
    }

    @Primary
    @Bean("em")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("ds") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("blooossom.shortping.entity");
        em.setJpaProperties(getProperties());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean("tm")
    public JpaTransactionManager transactionManager(@Qualifier("em") LocalContainerEntityManagerFactoryBean emf) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(emf.getObject());
        return tm;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.DIALECT, DB_DIALECT);
        properties.put(Environment.SHOW_SQL, "false");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        return properties;
    }
}
