package demo.refrection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import demo.service.Service1;

public class MethodInvoke {

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Service1 s = new Service1();

		// ���\�b�h���ƈ����̌^���w�肵��Method���擾�B
		Method m = s.getClass().getDeclaredMethod("doIt", String.class);

		// ���\�b�h�Ăяo��
		@SuppressWarnings("unused")
		Object result = m.invoke(s, "hoge");

	}
}
