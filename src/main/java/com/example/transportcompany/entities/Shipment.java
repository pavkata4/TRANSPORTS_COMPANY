package com.example.transportcompany.entities;


import jakarta.persistence.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "shipments")
public class Shipment{

    private long Id;

    private BigDecimal price;

    private boolean isPaid;

    private String startingPoint;

    private String endPoint;

    private LocalDateTime departure;

    private LocalDateTime arrive;

    private Set<Good> goods;

    private BigDecimal weight;

    public Shipment() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Column(name = "is_paid", nullable = false)
    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
    @Column(name = "starting_point", nullable = false)
    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }
    @Column(name = "ending_point", nullable = false)
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
    @Column(name = "departure")
    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }
    @Column(name = "arrive")
    public LocalDateTime getArrive() {
        return arrive;
    }

    public void setArrive(LocalDateTime arrive) {
        this.arrive = arrive;
    }
    @OneToMany
    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }
    @Column(name = "weight", nullable = false)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
