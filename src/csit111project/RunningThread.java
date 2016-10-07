package csit111project;

public class RunningThread implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println("New Thread: "+i);
		}
	}
	
	public static void main(String[] args){
		RunningThread runner=new RunningThread();
		Thread myThread = new Thread(runner);
		myThread.start();
		for (int i=0;i<50;i++){
			System.out.println("Main Thread: "+i);
		}
	}
	
}
