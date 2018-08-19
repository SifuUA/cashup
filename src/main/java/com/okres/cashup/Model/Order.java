package com.okres.cashup.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.Date;

/**
 * Representing Order entity for writing to DB
 * */

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date dateOfOrder;

    @Column(name = "status")
    private boolean status;

    @Column(name = "order_sum")
    private double sumOfOrder;

    @Column(name = "currency")
    private String currency;

    @ManyToOne
    @JsonBackReference
    private Client client;

    public Order() {
    }

    public Order(long clientId, Date dateOfOrder, boolean status, double sumOfOrder, String currency, Client client) {
        this.clientId = clientId;
        this.dateOfOrder = dateOfOrder;
        this.status = status;
        this.sumOfOrder = sumOfOrder;
        this.currency = currency;
        this.client = client;
    }

    //Constructor for cloning object
    public Order(Order other) {
        this(other.getClientId(), other.dateOfOrder, other.status,
                other.getSumOfOrder(), other.getCurrency(), other.getClient());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
