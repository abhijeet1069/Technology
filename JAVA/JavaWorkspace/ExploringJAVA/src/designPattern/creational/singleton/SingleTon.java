package designPattern.creational.singleton;

public class SingleTon {
	
	private static SingleTon obj = null;
	
	protected SingleTon() {}
	
	public static SingleTon getInstance() {
		if(obj == null) {
			obj = new SingleTon();
		}
		return obj;
	}
}
