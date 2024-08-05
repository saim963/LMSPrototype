package com.SStech.LMSPrototype.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class StudentDto {
    @NotEmpty(message = "Name is required.")
    private String name;
    @NotEmpty(message = "Contact number is required")
    private String contactNo;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "Seat number is required.")
    private String seatNo;
    @NotEmpty(message = "Shift is required.")
    private String shift;
    @NotEmpty(message = "Payment status is required.")
    private String paymentStatus;
    private LocalDate startDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
