/**
 * 
 */
package demo.refrection;

import java.lang.reflect.Field;

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
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		// クラス名からClassを取得
		Class<Person> pClazz = (Class<Person>) Class.forName("demo.bean.Person");
		
		System.out.println(pClazz);
		

		
		
		Field[] fields = pClazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		String x = pClazz.getClass().getName();
		
		System.out.println(x);


		// Classからインスタンス生成
		Person person = pClazz.newInstance();

	}

}
