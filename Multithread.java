package thread;

public class Multithread {

 public static void main(String[] args) {
	String message ="This is a paragraph";
	StringBuffer firstSB = new StringBuffer();
	StringBuffer secondSB = new StringBuffer();

	Thread producer = new Thread(new Producer(message,firstSB,secondSB));
	producer.start();
	Thread firstThread = new Thread(new FirstConsumer(firstSB));
	Thread secondThread = new Thread(new SecondConsumer(secondSB));
	Thread finalThread = new Thread(new FinalConsumer(firstSB,secondSB));
	secondThread.start();
	firstThread.start();
	finalThread.start();
	
	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX firstSB= "+firstSB);

	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX secondSB= "+secondSB);


}

}
class Producer implements Runnable{
	String sentence;
	StringBuffer sb1;
	StringBuffer sb2;
	public Producer(String sentence,StringBuffer sb1, StringBuffer sb2) {
		this.sentence = sentence;
		this.sb1=sb1;
		this.sb2=sb2;
	}
	@Override
	public void run() {
		String[] newMess = sentence.split("\\s");
		for (int i=0; i<newMess.length;i++) {
			if(newMess[i].length()<4) {
				//consumer 1
				System.out.println("Consumer 1====="+newMess[i]);
				synchronized(sb1) {
				sb1.append(newMess[i]);
				try {
					sb1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			//wait();
			}else {
				//consumer2
				System.out.println("Consumer 2====="+newMess[i]);
				synchronized(sb2) {
					sb2.append(newMess[i]);
					try {
						sb2.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
			}
			
			
		}
		
	}
	
}
class FirstConsumer implements Runnable{
	StringBuffer message;
	public FirstConsumer(StringBuffer message) {
		this.message=message;
	}
	@Override
	public void run() {
		synchronized(message) {
		message =message.append("1");
		message.notifyAll();
		}
	}
	
}
class SecondConsumer implements Runnable{
	StringBuffer message;
	public SecondConsumer(StringBuffer message) {
		this.message=message;
	}
	@Override
	public void run() {
		synchronized(message){
		message =message.append("2");
		message.notifyAll();
		}
		
	}
	
}
class FinalConsumer implements Runnable{
	StringBuffer sb1;
	StringBuffer sb2;
	public FinalConsumer(StringBuffer sb1,StringBuffer sb2) {
		this.sb1=sb1;
		this.sb2=sb2;
	}
	@Override
	public void run() {
		System.out.print(sb1);
		System.out.print(" ");
		System.out.print(sb2);
		System.out.print(" ");
		
	}
	
}

