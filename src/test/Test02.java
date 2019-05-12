package test;

public class Test02 {
	private static Test02 instance = new Test02();
	private Test02(){
		System.out.println("执行构造器");
	}
	public static Test02 getInstance(){
		return instance;
	}
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Test02.getInstance();
					
				}
			}).start();
		}
	}

}
