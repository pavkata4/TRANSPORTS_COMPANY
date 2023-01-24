package com.example.transportcompany.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "offices")
public class Office {

    private long Id;

    private String town;

    private String street;

    private String number;
    private Company company;

    private Set<Cashier> cashiers;

    private BigDecimal income;
    public Office() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    @Column(name = "Town", nullable = false)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "Street", nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @Column(name = "number", nullable = false)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "income")
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @OneToMany
    public Set<Cashier> getCashiers() {
        return cashiers;
    }

    public void setCashiers(Set<Cashier> cashiers) {
        this.cashiers = cashiers;
    }
}
