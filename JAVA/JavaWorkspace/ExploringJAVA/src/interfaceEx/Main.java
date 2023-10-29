package interfaceEx;

class SavingsAccount implements IAccount{

	int balance;
	
	public SavingsAccount(int amount) {
		this.balance = amount;
	}
	
	@Override
	public void deposit(int amount) {
		balance += amount;
		
	}

	@Override
	public void withdraw(int amount) {
		balance -= amount;
		
	}

	@Override
	public int showBalance() {
		return this.balance;
	}
	
	
}

class CheckAccount implements IAccount{

	int balance;
	
	public CheckAccount(int amount) {
		this.balance = amount;
	}
	
	@Override
	public void deposit(int amount) {
		balance += amount;
		
	}

	@Override
	public void withdraw(int amount) {
		balance -= amount;
		
	}

	@Override
	public int showBalance() {
		return this.balance;
	}
	
	
}

class CurrentAccount{ //we have mirrored other implementing classes. However still it wont work. Runtime exception

	int balance;
	
	public CurrentAccount(int amount) {
		this.balance = amount;
	}
	
	
	public void deposit(int amount) {
		balance += amount;
		
	}

	public void withdraw(int amount) {
		balance -= amount;
		
	}
	
	public int showBalance() {
		return this.balance;
	}
}

public class Main {

	public static void main(String[] args) {
		IAccount savingsAccount = new SavingsAccount(100);
		
		savingsAccount = new CheckAccount(20);
		savingsAccount = new SavingsAccount(30); //both are valid. And this is used in many design principle
		
		/**
		//error : we can't create object of interface
		savingsAccount = new IAccount(); 
		
		//Even if we somehow cast this and compile. This will give a runtime exception.
		savingsAccount = (IAccount) new CurrentAccount(30); 
		
		**/
		
		savingsAccount.withdraw(10);
		System.out.println(savingsAccount.showBalance()); // 20
		System.out.println(savingsAccount.getClass()); // class interfaceEx.SavingsAccount
		
		

	}

}
