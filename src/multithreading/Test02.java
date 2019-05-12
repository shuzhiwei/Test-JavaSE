package multithreading;

public class Test02 {
	public static void main(String[] args) {
		A a = new A();
		new Thread(new B(a),"������a").start();
		new Thread(new B(a),"������b").start();
		new Thread(new B(a),"������c").start();
		new Thread(new B(a),"������d").start();
		new Thread(new B(a),"������e").start();
		new Thread(new B(a),"������f").start();
		new Thread(new B(a),"������g").start();
		new Thread(new B(a),"������h").start();
		new Thread(new B(a),"������i").start();
		new Thread(new B(a),"������j").start();
		new Thread(new C(a),"������a").start();
		new Thread(new C(a),"������b").start();
		new Thread(new C(a),"������c").start();
		new Thread(new C(a),"������d").start();
		new Thread(new C(a),"������e").start();
		new Thread(new C(a),"������f").start();
		new Thread(new C(a),"������g").start();
		new Thread(new C(a),"������h").start();
		new Thread(new C(a),"������i").start();
		new Thread(new C(a),"������j").start();
	}
}

class A{
	private int num;
	
	public synchronized void add() throws Exception{
		if(num >= 100){
			this.wait();
		}else{
			num++;
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + "������һ̨, ��ǰ�����: " + num);
			this.notifyAll();
		}
		
		
	}
	public synchronized void sale() throws Exception{
		if(num <= 0){
			this.wait();
		}else{
			num--;
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + "����һ̨, ��ǰ�����: " + num);
			this.notifyAll();
		}
		
	}
	
}

class B implements Runnable{
	A a;
	

	public B() {
		super();
		// TODO Auto-generated constructor stub
	}


	public B(A a) {
		super();
		this.a = a;
	}


	@Override
	public void run() {
		while(true){
			try {
				a.add();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class C implements Runnable{
	A a;

	public C(A a) {
		super();
		this.a = a;
	}


	public C() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {
		while(true){
			try {
				a.sale();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
