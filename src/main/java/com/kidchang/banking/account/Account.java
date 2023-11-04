package com.kidchang.banking.account;


import com.kidchang.banking._base.entity.BaseTimeEntity;
import com.kidchang.banking.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Account extends BaseTimeEntity {

    @Id
    private String accountNumber;
    private Integer balance;
    private String type;
    private String accountAlias;
    private String password;
    private String status;

    @ManyToOne
    private User owner;

}
