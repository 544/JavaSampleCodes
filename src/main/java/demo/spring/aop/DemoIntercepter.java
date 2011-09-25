package demo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
class DemoIntercepter {


	/// Pointcut��`�B
	@SuppressWarnings("unused")
	@Pointcut("execution(public String demo.spring.aop..*(..))")	//public �߂�String demo�T�u�K�w do���܂܂�郁�\�b�h�� 
    private void anyPublicOperation() {}
	

	// ���ۂ�Advice�̎���
	//   Before�A�h�o�C�X			�{���̏����̑O
	//   AfterReturning�A�h�o�C�X	�{���̏����̐���I����
	//   After�A�h�o�C�X			�{���̏�����C�I���������킸���s
	//   AfterThrowing�A�h�o�C�X	�{���̏����̒��ŗ�O���X���[���ꂽ�Ƃ�
	//   Around�A�h�o�C�X			�{���̏����̑O��	
	
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
