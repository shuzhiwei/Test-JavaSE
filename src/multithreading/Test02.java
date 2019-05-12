package multithreading;

public class Test02 {
	public static void main(String[] args) {
		A a = new A();
		new Thread(new B(a),"生产者a").start();
		new Thread(new B(a),"生产者b").start();
		new Thread(new B(a),"生产者c").start();
		new Thread(new B(a),"生产者d").start();
		new Thread(new B(a),"生产者e").start();
		new Thread(new B(a),"生产者f").start();
		new Thread(new B(a),"生产者g").start();
		new Thread(new B(a),"生产者h").start();
		new Thread(new B(a),"生产者i").start();
		new Thread(new B(a),"生产者j").start();
		new Thread(new C(a),"消费者a").start();
		new Thread(new C(a),"消费者b").start();
		new Thread(new C(a),"消费者c").start();
		new Thread(new C(a),"消费者d").start();
		new Thread(new C(a),"消费者e").start();
		new Thread(new C(a),"消费者f").start();
		new Thread(new C(a),"消费者g").start();
		new Thread(new C(a),"消费者h").start();
		new Thread(new C(a),"消费者i").start();
		new Thread(new C(a),"消费者j").start();
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
			System.out.println(Thread.currentThread().getName() + "生产了一台, 当前库存是: " + num);
			this.notifyAll();
		}
		
		
	}
	public synchronized void sale() throws Exception{
		if(num <= 0){
			this.wait();
		}else{
			num--;
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + "卖了一台, 当前库存是: " + num);
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
