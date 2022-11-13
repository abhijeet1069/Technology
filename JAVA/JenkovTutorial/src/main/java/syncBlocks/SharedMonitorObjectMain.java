package syncBlocks;

/*
 Don't use Strings for monitor object. Because we don't know how JAVA compiler will optimize String
 whether it will create different or same instance
 	SharedMonitorObject smo1 = new SharedMonitorObject("mon1"); 
 * */

public class SharedMonitorObjectMain {

	public static void main(String[] args) {
		Object monitor1 = new Object();
		SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
		SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);
		
		smo1.incCounter(); //monitor object is same for the synchronized blocks
		smo2.incCounter();
		
		Object monitor2 = new Object();
		
		SharedMonitorObject smo3 = new SharedMonitorObject(monitor2); //smo3 will not block smo1,smo2 as they have different monitor
		smo3.incCounter();
	}

}
