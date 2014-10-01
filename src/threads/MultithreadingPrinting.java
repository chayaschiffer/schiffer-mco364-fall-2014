package threads;

public class MultithreadingPrinting {
	public static void main(String[] args){
		for(int i=0;i<5;i++){
			final int current = i;
			Thread thread = new Thread(){
				public void run(){
					System.out.println(current);
				}
			};
			thread.start();
		}
		System.out.println("finished");
	}
}
