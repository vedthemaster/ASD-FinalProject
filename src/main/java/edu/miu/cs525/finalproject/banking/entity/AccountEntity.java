package edu.miu.cs525.finalproject.banking.entity;

import edu.miu.cs525.finalproject.banking.model.AccountInterestType;
import edu.miu.cs525.finalproject.banking.model.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Enumerated(EnumType.STRING)
    private AccountInterestType accountInterestType;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
