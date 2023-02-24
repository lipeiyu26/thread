package com.lpy.thread.dieLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁:
 * 破坏死锁：不可抢占
 */
public class TransferAccount02 implements Runnable{
    private Account formAccount;
    private Account toAccount;
    private int amount;

    Lock fromLock = new ReentrantLock();
    Lock toLock = new ReentrantLock();

    public TransferAccount02(Account formAccount, Account toAccount, int amount) {
        this.formAccount = formAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public Account getFormAccount() {
        return formAccount;
    }

    public void setFormAccount(Account formAccount) {
        this.formAccount = formAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        while (true) {
                    if (fromLock.tryLock()) {
                        if (toLock.tryLock()) {
                            if (formAccount.getBalance() >= amount) {
                                formAccount.debit(amount);
                                toAccount.credit(amount);
                            }
                        }
                    }
                    System.out.println(formAccount.getAccountName() + "->" + formAccount.getBalance());
                    System.out.println(toAccount.getAccountName() + "->" + toAccount.getBalance());



        }
    }

    public static void main(String[] args) {
        Account formAccount = new Account("MIC", 30000);
        Account toAccount = new Account("HH", 10000);


        Thread t1 = new Thread(new TransferAccount02(formAccount,toAccount,10));
        Thread t2 = new Thread(new TransferAccount02(toAccount,formAccount,30));
        t1.start();
        t2.start();
    }
}
