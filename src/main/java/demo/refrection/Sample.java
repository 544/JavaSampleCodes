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

		// �N���X������Class���擾
		@SuppressWarnings("unchecked")
		Class<Person> pClazz = (Class<Person>) Class
				.forName("demo.bean.Person");

		System.out.println(pClazz);

		// �N���X����p�����[�^�擾
		Field[] fields = pClazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.toString());
		}

		// �N���X���烁�\�b�h�擾
		Method[] methods = pClazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}

		// Class����C���X�^���X����
		Person person = pClazz.newInstance();
		person.setName("hoge");
		person.setAge(11);
		System.out.println(person.toString());

	}

}
