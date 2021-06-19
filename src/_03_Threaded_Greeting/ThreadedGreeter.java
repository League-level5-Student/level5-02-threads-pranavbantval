package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	
Integer i;

ThreadedGreeter(Integer i){
	this.i=i;
}


	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		
		
		if(i<=50) {
			i++;
			System.out.println("Hello from thread "+ i);
		}
	}

}
