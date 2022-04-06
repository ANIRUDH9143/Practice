package model;

public class Transaction {
    private int id;
    private int from_acc_no;
    private int to_acc_no;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrom_acc_no() {
        return from_acc_no;
    }

    public void setFrom_acc_no(int from_acc_no) {
        this.from_acc_no = from_acc_no;
    }

    public int getTo_acc_no() {
        return to_acc_no;
    }

    public void setTo_acc_no(int to_acc_no) {
        this.to_acc_no = to_acc_no;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
