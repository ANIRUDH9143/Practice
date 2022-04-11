package com.models;

import javax.persistence.*;

@Entity
@Table(name="`Transaction`")
public class Transaction {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="from_acc_no")
    private String from_acc_no;

    @Column(name="to_acc_no")
    private String to_acc_no;

    @Column(name="amount")
    private String amount;

    Transaction(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom_acc_no() {
        return from_acc_no;
    }

    public void setFrom_acc_no(String from_acc_no) {
        this.from_acc_no = from_acc_no;
    }

    public String getTo_acc_no() {
        return to_acc_no;
    }

    public void setTo_acc_no(String to_acc_no) {
        this.to_acc_no = to_acc_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
