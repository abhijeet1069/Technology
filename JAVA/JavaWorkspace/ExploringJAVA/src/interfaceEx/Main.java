package interfaceEx;

class SavingsAccount implements IAccount{

	int balance;
	
	public SavingsAccount(int amount) {
		this.balance = amount;
	}
	
	@Override
	public void deposit(int amount) {
		balance -= amount;
		
	}

	@Override
	public void withdraw(int amount) {
		balance += amount;
		
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
		balance -= amount;
		
	}

	@Override
	public void withdraw(int amount) {
		balance += amount;
		
	}

	@Override
	public int showBalance() {
		return this.balance;
	}
	
	
}

public class Main {

	public static void main(String[] args) {
		IAccount savingsAccount = new SavingsAccount(100);
		
		savingsAccount = new CheckAccount(20);
		
		System.out.println(savingsAccount.showBalance());

	}

}
