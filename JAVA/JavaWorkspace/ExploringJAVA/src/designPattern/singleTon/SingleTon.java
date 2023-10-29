package designPattern.singleTon;

public class SingleTon {
	
	private static volatile SingleTon obj = null;
	
	private SingleTon() {};
	
	public static SingleTon getInstance() {
		if(obj == null) {
			synchronized(SingleTon.class) {
				if(obj == null)
					obj = new SingleTon();
			}
		}
		return obj;
	}
}
