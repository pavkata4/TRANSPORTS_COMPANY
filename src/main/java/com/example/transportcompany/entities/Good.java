package com.example.transportcompany.entities;

import jakarta.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "goods")
@Entity
public class Good {

    private long id;

    private String name;

    private boolean isFragile;


    private BigDecimal insurancePrice;

    public Good() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "is_fragile")
    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }
    @Column(name = "insurance_price")
    public BigDecimal getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(BigDecimal insurancePrice) {
        this.insurancePrice = insurancePrice;
    }
}
