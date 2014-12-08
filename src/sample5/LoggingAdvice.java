package sample5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 메서드 이름가져오기
		String methodName = invocation.getMethod().getName();
		// 시간객체생성
		StopWatch sw = new StopWatch();
		// 시간 시작
		sw.start(methodName);
		// 로그 출력
		System.out.println("[LOG]METHOD:"+methodName+"is calling");
		// 메서드 동작
		Object rtnobj = invocation.proceed(); //sayHello();메소드 호출되는 시점
		// 시간 멈춤
		sw.stop();
		// 로그 출력
		System.out.println("[LOG]METHOD:"+methodName+"was called");
		// 시간 출력
		System.out.println("[LOG]처리시간:"+sw.getTotalTimeMillis()/1000+"초");
		return rtnobj;
	}
}
