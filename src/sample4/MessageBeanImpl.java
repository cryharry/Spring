package sample4;

public class MessageBeanImpl implements MessageBean{
	// 의존관계주입(DI) - 스프링 객체 생성 방법
	
	// 멤버변수
	private String name; //이름
	private String greeting; //인사말
	// 파일을 쓸 객체 선언
	//Outputter outputter = new FileOutputter();
	private Outputter outputter;
	// xml에서 주입해준 값받기
	// 이름받는 생성자
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	// 인사말 받는 set메서드
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	// 파일관련 객체 생성 주입받기 set메서드
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	@Override
	public void sayHello() {
		System.out.println(greeting + name + "!");
		// 인사말 => 파일에 출력 메서드 호출()
		String message = greeting + name + "!";
		try {
			outputter.output(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
