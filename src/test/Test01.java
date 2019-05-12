package test;

public class Test01 {
	private static Test01 instance = null;
	private Test01(){
		System.out.println("执行构造器");
	}
	public static Test01 getInstance(){
		if(instance == null){
			synchronized (Test01.class) {
				if(instance == null){
					instance = new Test01();
				}
			}
		}
		return instance;
	}
	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Test01.getInstance();
					
				}
			}).start();
		}
		
	}

}
