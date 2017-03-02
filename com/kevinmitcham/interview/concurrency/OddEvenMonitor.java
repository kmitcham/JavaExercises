package com.kevinmitcham.interview.concurrency;

public class OddEvenMonitor {
	public static final int ODD_TURN = 0;
	public static final int EVEN_TURN = 1;
	public static final int ALPHA_TURN = 2;
	public static final int COUNT = 3;
	private int turn = ODD_TURN;
	
	public synchronized void waitTurn(int myTurn){
		while (turn != myTurn){
			try {
				wait();
			} catch (InterruptedException e){
				System.out.println("Interruption in wait();"+e);
			}
		}
	}
	public synchronized void toggleTurn(String msg){
		turn = (turn +1) % COUNT;
		System.out.println(msg+" turn is "+turn);
		notify();
	}

	public static void main(String[] args) throws InterruptedException{
		OddEvenMonitor monitor = new OddEvenMonitor();
		Thread t1 = new OddThread(monitor);
		Thread t2 = new EvenThread(monitor);
		Thread t3 = new AlphaThread(monitor);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}
	public static class EvenThread extends Thread {
		private final OddEvenMonitor monitor;
		
		public EvenThread(OddEvenMonitor monitor){ this.monitor = monitor;}
		
		@Override
		public void run(){
			for (int i=2; i <= 100; i+=2){
				monitor.waitTurn(OddEvenMonitor.EVEN_TURN);
				monitor.toggleTurn("e="+i);
			}
		}

	}
	public static class OddThread extends Thread {
		private final OddEvenMonitor monitor;
		
		public OddThread(OddEvenMonitor monitor){ this.monitor = monitor;}
		
		@Override
		public void run(){
			for (int i=1; i < 100; i+=2){
				monitor.waitTurn(OddEvenMonitor.ODD_TURN);
				monitor.toggleTurn("o="+i);
			}
		}
	}
	public static class AlphaThread extends Thread {
		private final OddEvenMonitor monitor;
		public AlphaThread(OddEvenMonitor monitor){ this.monitor = monitor;}
		
		@Override
		public void run(){
			for (int i=0; i < 50; i++){
				monitor.waitTurn(OddEvenMonitor.ALPHA_TURN);
				char foo = (char) ( 'a' + ( i%26 ) );
				monitor.toggleTurn("a="+foo);
			}
		}
	}

}