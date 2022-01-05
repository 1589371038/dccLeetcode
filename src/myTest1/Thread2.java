package myTest1;

public class Thread2 extends Thread{
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true){
            synchronized (account){
                int id=account.getId();
                if(id>0){
                    System.out.println(currentThread().getName()+"展示账户的第"+id+"个id");
                    account.setId(id-1);
                }else break;
            }
        }
    }
}
