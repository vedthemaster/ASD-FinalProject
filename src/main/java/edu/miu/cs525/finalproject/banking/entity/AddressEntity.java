package edu.miu.cs525.finalproject.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
