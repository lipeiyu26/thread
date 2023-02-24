package com.lpy.thread.dieLock;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 死锁:
 * 破坏死锁：占有且等待，线程t1已经取得共享资源X，在等待共享资源Y的时候，不释放共享资源Y
 */
public class TransferAccount implements Runnable{
    private Account formAccount;
    private Account toAccount;
    private int amount;
    private Allocator allocator;

    public TransferAccount(Account formAccount, Account toAccount, int amount, Allocator allocator) {
        this.formAccount = formAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allocator = allocator;
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
            if (allocator.apply(formAccount, toAccount)) {
                try {
                    synchronized (formAccount) {
                        synchronized (toAccount) {
                            if (formAccount.getBalance() >= amount) {
                                formAccount.debit(amount);
                                toAccount.credit(amount);
                            }
                        }
                    }
                    System.out.println(formAccount.getAccountName() + "->" + formAccount.getBalance());
                    System.out.println(toAccount.getAccountName() + "->" + toAccount.getBalance());

                }finally {
                    allocator.free(formAccount,toAccount);
                }
            }
        }
    }

    public static void main(String[] args) {
        Account formAccount = new Account("MIC", 30000);
        Account toAccount = new Account("HH", 10000);
//        Thread t1 = new Thread(new TransferAccount(formAccount,toAccount,10));
//        Thread t2 = new Thread(new TransferAccount(toAccount,formAccount,30));

        Allocator allocator1 = new Allocator();
        Thread t1 = new Thread(new TransferAccount(formAccount,toAccount,10,allocator1));
        Thread t2 = new Thread(new TransferAccount(toAccount,formAccount,30,allocator1));
        t1.start();
        t2.start();
    }
}
