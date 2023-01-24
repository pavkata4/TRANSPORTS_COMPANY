package com.example.transportcompany.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@MappedSuperclass
public  class Person {

    private long id;

    private String firstName;

    private String lastName;


    private int age;

    private String phoneNumber;







    public Person() {
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

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    @Column(name = "phone_number",length = 10)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
