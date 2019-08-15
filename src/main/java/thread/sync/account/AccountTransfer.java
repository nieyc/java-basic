package thread.sync.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 16:12 2019/8/14
 * @Description:模拟一个银行转账死锁的场景，两个线程转账，A转账给B，同时B也给A转账
 * 消除死锁，使用lock机制
 * eg:
 *  final Lock lock=new ReentrantLock();
 *  lock.tryLock();
        try{
        if(fromAccount.getBalance() .compareTo(BigDecimal.ZERO)==0){
        System.out.println(fromAccount.getAccountName() + "账户余额不足，无法进行转账");
        return;
        }else {
        //更新转出账户的余额：
        fromAccount.withdraw(amount);
        ///更新转入账户的余额：-
        toAccount.deposit(amount);
        }
        System.out.println("转出账户："+fromAccount.getAccountName() + "余额：" + fromAccount.getBalance());
        System.out.println("转入账户："+toAccount.getAccountName() + "余额：" + toAccount.getBalance());
        }finally {
        lock.unlock();
        }
 *
 **/
public class AccountTransfer implements Runnable {

    //转出账户
    public Account fromAccount;
    //转入账户
    public Account toAccount;
    //转出金额
    public BigDecimal amount;

    public AccountTransfer(Account fromAccount,Account toAccount,BigDecimal tranAmount){
        this.fromAccount=fromAccount;
        this.toAccount=toAccount;
        this.amount=tranAmount;
    }

    @Override
    public void run() {
        while (true) {
            //获取fromAccount对象的锁
            synchronized (fromAccount) {
                //获取toAccount对象的锁
                synchronized (toAccount) {
                    //转账进行的条件：判断转出账户的余额是否大于0
                    if (fromAccount.getBalance().compareTo(BigDecimal.ZERO) == 0) {
                        System.out.println(fromAccount.getAccountName() + "账户余额不足，无法进行转账");
                        return;
                    } else {
                        //更新转出账户的余额：
                        fromAccount.withdraw(amount);
                        ///更新转入账户的余额：-
                        toAccount.deposit(amount);
                    }
                    System.out.println("转出账户：" + fromAccount.getAccountName() + "余额：" + fromAccount.getBalance());
                    System.out.println("转入账户：" + toAccount.getAccountName() + "余额：" + toAccount.getBalance());
                }
            }
        }
    }

    public static void main(String[] args) {
        Account fromAccount = new Account("张三",BigDecimal.valueOf(100000));
        Account toAccount = new Account("李四",BigDecimal.valueOf(200000));
        Thread a = new Thread(new AccountTransfer(fromAccount,toAccount,BigDecimal.ONE));
        Thread b = new Thread(new AccountTransfer(toAccount,fromAccount,BigDecimal.valueOf(2)));
        a.start();
        b.start();
    }
}
