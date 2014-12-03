package sample2;

public class HelloApp {	
	public static void main(String[] args) {
		// sample1
		MessageBeanKr mbk = new MessageBeanKr();
		mbk.sayHello("홍길동");
		MessageBeanEn mbe = new MessageBeanEn();
		mbe.sayHello("kimgil");
		// sample2 인터페이스 객체생성
		MessageBean mb;
		mb = new MessageBeanKr();
		mb.sayHello("성춘향");
		mb = new MessageBeanEn();
		mb.sayHello("leemong");
	}
}
