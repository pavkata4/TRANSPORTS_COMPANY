package com.example.transportcompany.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "vehicles")
public class Vehicle{
    private long id;
    private Type type;

    private BigDecimal mileage;

    private Engine engine;

    private BigDecimal averageFuelConsumption;

    public Vehicle() {
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

    @Enumerated
    @Column(name = "type")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    @Column(name = "mileage")
    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }
    @Enumerated
    @Column(name = "engine")
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Column(name = "average_fuel_consumption")
    public BigDecimal getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(BigDecimal averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }
}
