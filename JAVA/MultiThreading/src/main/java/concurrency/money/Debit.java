package concurrency.money;

import concurrency.money.Account;

public class Debit extends Thread{
    public void run(){

    }

    public int debit(Account account, int amount){
        account.amount -= amount;
        return account.amount;
    }
}
