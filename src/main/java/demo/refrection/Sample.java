/**
 * 
 */
package demo.refrection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import demo.bean.Person;

/**
 * @author masato
 * 
 */
public class Sample {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		// クラス名からClassを取得
		@SuppressWarnings("unchecked")
		Class<Person> pClazz = (Class<Person>) Class
				.forName("demo.bean.Person");

		System.out.println(pClazz);

		// クラスからパラメータ取得
		Field[] fields = pClazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.toString());
		}

		// クラスからメソッド取得
		Method[] methods = pClazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		// Classからインスタンス生成
		Person person = pClazz.newInstance();
		person.setName("hoge");
		person.setAge(11);
		System.out.println(person.toString());

	}

}
