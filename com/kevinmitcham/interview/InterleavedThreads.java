package com.kevinmitcham.interview;

public class InterleavedThreads {
	static int FLAG = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavedThreads it = new InterleavedThreads();
		it.go();
	}
	void p(String m){
		System.out.println(m);
	}
	public void go(){
		
		p("start even");
		Thread teven = new Thread(new Counter(0));
        teven.start();
		p("start odd");
		Thread todd = new Thread(new Counter(1));
        todd.start();
        try {
			teven.join();
	        todd.join();;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p("Done");
	}
	class Counter implements Runnable{
		int MAX = 100;
		int offset = 0;
		Counter(int offset){
			this.offset = offset;
		}
		Counter(){
			this(0);
		}
		public void run(){
			count();
		}
		void count(){
			for (int i= offset; i <= MAX; i+=2){
				try {
					while ((InterleavedThreads.FLAG == offset)){
						Thread.sleep(100);
					}
				} catch (InterruptedException e){
					p("--");
				}
				p(""+i);
				InterleavedThreads.FLAG = (InterleavedThreads.FLAG + 1 ) % 2;
			}
		}
	}
}
