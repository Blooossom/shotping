package blooossom.shortping.entity;

import blooossom.shortping.enums.HistoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "history")
public class History {

    @Id
    @Column(name = "history_id")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "history_type")
    private HistoryType type;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
