public class Account {
    private int id=1000;
    private String name;
    private int balance=0;
    Account()
    {}
    Account(String name){
        this.id=id+1;
        this.name=name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    int dcount=0;
    public void depositMoney(double depositAmount){
        if(getBalance()+depositAmount<=100000) {
            if (depositAmount >= 500) {

                if (depositAmount <= 50000) {

                    dcount++;
                    if (dcount <= 3) {
                        this.balance += depositAmount;
                        System.out.println(getBalance() + "\n");
                    } else
                        System.out.println("Only 3 deposits are allowed in a day.");
                } else
                    System.out.println("Maximum deposit amount is 50000.");
            } else
                System.out.println("Minimum deposit amount is 500.");
        }
        else
            System.out.println("Bank balance will exceed 100000, deposit less amount.");
        }

    int wcount=0;
    public void withdrawal(double withdrawalAmount){
        if(withdrawalAmount>=1000) {
            if (wcount <= 3) {
                wcount++;
                if (this.balance < withdrawalAmount) {
                    System.out.println("Insufficient balance.");
                } else {
                    this.balance -= withdrawalAmount;
                    System.out.println(getBalance()+ "\n");
                }
            } else
                System.out.println("Only 3 withdrawals are allowed in a day.");
        }
        else
            System.out.println("Minimum withdrawal amount is 1000.");
    }
    public static void moneyTransfer(Account thisAccount, Account toAccount, double amountToTransfer){
        if(thisAccount.getBalance() > 0) {
            if (amountToTransfer + toAccount.getBalance() <= 100000) {
                if (amountToTransfer > 1000) {
                    if (amountToTransfer < 25000) {
                        toAccount.setBalance(toAccount.balance += amountToTransfer);
                        thisAccount.setBalance(thisAccount.balance -= amountToTransfer);
                        System.out.println("Successful");
                    } else
                        System.out.println("Maximum withdrawal amount is 25000 for account " + thisAccount.getId());
                } else {
                    System.out.println("Minimum withdrawal amount is 1000 for account " + thisAccount.getId());
                }
            } else
                System.out.println("Bank balance will exceed 100000, transfer less amount.");
        }
            else {
                System.out.println("Insufficient balance");
            }
        }

        }

