package myTest1;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    public Account(int id,double balance,double annualInterestRate){
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public double getMonthlyInterest(){
        return balance*annualInterestRate/12;
    }
    public void withdraw(double amount){
        if(0<amount&&amount<=balance){
            balance-=amount;
        }else {
            throw new RuntimeException("取钱超过余额或者不符合规定");
        }
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
        }else {
            throw new RuntimeException("存款数额不符合规定");
        }
    }
}
