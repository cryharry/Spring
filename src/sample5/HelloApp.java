package sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {	
	public static void main(String[] args) {
		// xml파일 가져오기
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		// 객체 생성 xml 가져오기
		MessageBean mb;
		//mb = factory.getBean("messageBean", MessageBean.class);
		mb = (MessageBean)factory.getBean("proxy");
		// 메서드 호출
		mb.sayHello();
		/* AOP : 관점지향프로그래밍
		 관점지향 프로그램 분리
		 sayHello()-포인트컷	로그출력-어드바이스
		 AOP프레임워크 관리 <- 어드바이저(포인트컷+어드바이스)
		 sayHello()동작하면 AOP감지 로그출력을 가져와서 
		 sayHello()앞뒤로 동작시킴(삽입=위빙) */
	}
}
