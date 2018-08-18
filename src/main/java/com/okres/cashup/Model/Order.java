package com.okres.cashup.Model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_date")
    private String dateOfOrder;

    @Column(name = "status")
    private boolean status;

    @Column(name = "order_sum")
    private double sumOfOrder;

    @Column(name = "currency")
    private String currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSumOfOrder() {
        return sumOfOrder;
    }

    public void setSumOfOrder(double sumOfOrder) {
        this.sumOfOrder = sumOfOrder;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}