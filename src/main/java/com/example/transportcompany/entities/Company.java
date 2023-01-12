package com.example.transportcompany.entities;




import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    private Long id;

    private String name;

    private Manager manager;

    private Set<Driver> drivers;

    private Set<Transports> transports;

    private Set<Vehicle> vehicles;

    private Set<Shipment> shipments;

    private Set<Client> clients;


    public Company(String name) {
        this.name = name;
        this.drivers = new HashSet<>();
        this.transports = new HashSet<>();
        this.vehicles = new HashSet<>();
    }

    public Company() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }
    @OneToOne
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "drivers")
    @OneToMany
    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
     @OneToMany
    public Set<Transports> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transports> transports) {
        this.transports = transports;
    }
    @OneToMany
    @Column(name = "vehicle")
    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    @OneToMany
    public Set<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(Set<Shipment> shipments) {
        this.shipments = shipments;
    }
    @ManyToMany
    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
