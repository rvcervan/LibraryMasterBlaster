package com.project.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Membership {

    @Id
    int membership_id;
    String customer_name;
    String membership_class;

    public int getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(int membership_id) {
        this.membership_id = membership_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMembership_class() {
        return membership_class;
    }

    public void setMembership_class(String membership_class) {
        this.membership_class = membership_class;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "membership_id=" + membership_id +
                ", customer_name='" + customer_name + '\'' +
                ", membership_class='" + membership_class + '\'' +
                '}';
    }
}
