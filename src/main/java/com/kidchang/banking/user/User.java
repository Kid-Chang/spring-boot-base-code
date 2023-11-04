package com.kidchang.banking.user;

import com.kidchang.banking._base.entity.BaseTimeEntity;
import com.kidchang.banking.account.Account;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
//@Builder
// 여기서 builder를 이용하면 안됨. List<Account> 에 대한 처리가 안될,,걸?
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String name;
    private String grade;
    private Integer age;
    private String email;
    private String phone;
    @Column(nullable = false)
//    @ColumnDefault("'ACTIVE'")
    private String status;

    @OneToMany
    private List<Account> accounts;

    @Builder
    public User(Integer id, String password, String name, String grade, Integer age, String email,
        String phone, String status) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

}
