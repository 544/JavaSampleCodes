package demo.refrection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import demo.service.Service1;

public class MethodInvoke {

	public static void main(String[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Service1 s = new Service1();

		// メソッド名と引数の型を指定してMethodを取得。
		Method m = s.getClass().getDeclaredMethod("doIt", String.class);

		// メソッド呼び出し
		@SuppressWarnings("unused")
		Object result = m.invoke(s, "hoge");

	}
}
