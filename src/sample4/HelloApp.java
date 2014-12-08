package sample4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {	
	public static void main(String[] args) {
		// xml파일 가져오기
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		// 객체 생성 xml 가져오기
		MessageBean mb;
		mb = factory.getBean("messageBean", MessageBean.class);
		// 메서드 호출
		mb.sayHello();
		
	}
}
