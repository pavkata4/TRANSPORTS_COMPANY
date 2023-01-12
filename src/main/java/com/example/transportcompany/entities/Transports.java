package com.example.transportcompany.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transports")
public class Transports{
    private long id;

    private String startingPoint;

    private String endPoint;

    private LocalDateTime departure;

    private LocalDateTime arrive;

    private BigDecimal price;

    private BigDecimal distance;

    private BigDecimal expenses;

    public Transports() {
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
    @Column(name = "distance",nullable = false)
    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
    @Column(name = "expenses", nullable = false)
    public BigDecimal getExpenses() {
        return expenses;
    }

    public void setExpenses(BigDecimal expenses) {
        this.expenses = expenses;
    }

    @Column(name = "starting_point", nullable = false)
    public String getStartingPoint() {
        return startingPoint;
    }
    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    @Column(name = "end_point", nullable = false)
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Column(name = "departure",nullable = false)
    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }
    @Column(name = "arrive", nullable = false)
    public LocalDateTime getArrive() {
        return arrive;
    }

    public void setArrive(LocalDateTime arrive) {
        this.arrive = arrive;
    }
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
