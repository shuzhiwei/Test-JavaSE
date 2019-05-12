package multithreading;

public class TestWorkerSaler {
	public static void main(String[] args) {
		//1�������ֿ�
		Houseware house = new Houseware();
		
		//2�����������߳�
		new Worker(house).start();
		//3�����������߳�
		new Saler(house).start();
	}
}
class Houseware{
	private int total;//��ʾ��ǰ�ֿ��еĵ��ӻ�����
	private static final int MAX_VALUE = 10;
	
	/*
	 * �����ߵ���������������ֿ�ŵ���
	 * ������this
	 */
	public synchronized void add(){
		if(total >= MAX_VALUE){//���ֿ���ʱ��������ͣ�����������߳̽�������״̬
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		total++;
		try {
			//Ϊ�˷Ŵ�����
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������������һ̨���ӻ�����ǰ����ǣ�"+total);
		//�������ڵȴ����߳�
		this.notify();
		System.out.println("������......");
	}
	
	/*
	 * ������Ա��������������Ӳֿ��õ���
	 * ������this
	 */
	public synchronized void take(){
		if(total<=0){//���ֿ��ʱ������Ա��Ϣ�������̣߳���������״̬
			try {
				//��Ϣ
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		total--;
		try {
			//Ϊ�˷Ŵ�����
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("����������һ̨���ӻ�����ǰ����ǣ�"+total);
		//�������ڵȴ����߳�
		this.notify();
		System.out.println("������......");
	}
}

class Worker extends Thread{
	private Houseware h;
	
	public Worker(Houseware h){
		this.h = h;
	}
	
	public void run(){
		while(true){
			h.add();
		}
	}
}
class Saler extends Thread{
	private Houseware h;
	
	public Saler(Houseware h){
		this.h = h;
	}
	
	public void run(){
		while(true){
			h.take();
		}
	}
}
