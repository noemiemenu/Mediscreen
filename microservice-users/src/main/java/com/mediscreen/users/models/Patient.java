package com.mediscreen.users.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Table(name = "patient")
public class Patient {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank
    private String family;

    @Column
    @NotBlank
    private String given;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NotBlank
    private String address;

    @Column
    @Email
    private String email;

    @Column
    @NotBlank
    private String phone;

    @Column
    @NotBlank
    @Size(max = 1)
    private String sex;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", gender='" + sex + '\'' +
                ", birthdate=" + dob +
                '}';
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
