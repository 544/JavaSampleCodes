package demo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
class DemoIntercepter {


	/// Pointcut定義。
	@SuppressWarnings("unused")
	@Pointcut("execution(public String demo.spring.aop..*(..))")	//public 戻りString demoサブ階層 doが含まれるメソッド名 
    private void anyPublicOperation() {}
	

	// 実際のAdviceの実装
	//   Beforeアドバイス			本来の処理の前
	//   AfterReturningアドバイス	本来の処理の正常終了後
	//   Afterアドバイス			本来の処理後，終了条件を問わず実行
	//   AfterThrowingアドバイス	本来の処理の中で例外がスローされたとき
	//   Aroundアドバイス			本来の処理の前後	
	
//	@Before("demo.springfw.aop.components.DemoInterceptor.anyPublicOperation()")
//	public void logBefore(JoinPoint jp) {
//		System.out.println("START");
//	}
//
//	@AfterReturning("demo.springfw.aop.components.DemoInterceptor.anyPublicOperation()")
//	public void logAfter(JoinPoint jp) {
//		System.out.println("END");
//	}
	
	
	@Around("demo.spring.aop.DemoIntercepter.anyPublicOperation()")
	public Object aroundTest(ProceedingJoinPoint target ) {
		
		try {
			Object[] args = target.getArgs();

			System.out.println("mae[" + array2Str(args) + "]");
			
			Object result = target.proceed(args);
			
			System.out.println("ato[" + result + "]");
			return result;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private static String array2Str(Object[] source) {
		StringBuffer buffer = new StringBuffer();
		for (Object object : source) {
			buffer.append(" ").append(object + "");
		}
		return buffer.toString();
	}
	
}
