package thread.sync.account;

import java.math.BigDecimal;

/**
 * 
* <p>Title: AccountOperator.java</p>  
* <p>Description:synchronized 锁定一个对象 account</p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: cssweb.sh.cn</p>  
* @author nieyc  
* @date 2019年4月8日  
* @version 1.0
 */
public class AccountOperator implements Runnable{
	
	private Account account;
	
	public AccountOperator(Account account) {
		this.account=account;
	}

	@Override
	public void run() {
		/*如果不加同步锁，2个线程执行下来，初始化100块钱，先存10块，在取10块，但是每次结果都不同*/
		synchronized (account) {
			for(int i=0;i<10;i++) {
				account.deposit(BigDecimal.TEN);
				account.withdraw(BigDecimal.TEN);
				System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Account account=new Account("nieyc", BigDecimal.valueOf(100));
		AccountOperator accountOperator = new AccountOperator(account);
		Thread tA=new Thread(accountOperator,"A");
		tA.start();
		Thread tB=new Thread(accountOperator,"B");
		tB.start();
	}

}
