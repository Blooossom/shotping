package blooossom.shortping.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@EqualsAndHashCode
@Table(name = "user", schema = "shortping")
public class User {

    @Id
    @Column(name = "user_seq")
    private String useSeq;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "user_nm")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "address")
    private String address;

    @Column(name = "address_detail")
    private String addressDetail;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth")
    private String birth;
}
