package thread.sync.account;

import java.math.BigDecimal;

/**
 * 
* <p>Title: Account.java</p>  
* <p>Description: 模拟一个银行账户类</p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: cssweb.sh.cn</p>  
* @author nieyc  
* @date 2019年4月8日  
* @version 1.0
 */
public class Account {

	String accountName;
	
	BigDecimal amount;
	
	public Account(String accountName, BigDecimal amount) {
	      this.accountName = accountName;
	      this.amount = amount;
	}

	public Account(String accountName){
		this.accountName=accountName;
	}

    public Account(){

    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


	
	/**
	 * 
	 * <p>存钱 </p>  
	 * @param amt
	 * @author nieyc 
	 * @date 2019年4月8日
	 */
	public void deposit(BigDecimal amt) {
		amount=amount.add(amt);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * <p> 取钱</p>  
	 * @param amt
	 * @author nieyc 
	 * @date 2019年4月8日
	 */
	public void withdraw(BigDecimal amt) {
		amount=amount.subtract(amt);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  获取剩余金额
	 * <p> </p>  
	 * @return
	 * @author nieyc 
	 * @date 2019年4月8日
	 */
	 public BigDecimal getBalance() {
	      return amount;
	   }


}
