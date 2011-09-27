package demo.google.guava;

import utils.SimpleLogger;

import com.google.common.base.Objects;
import demo.bean.Person;

/**
 * guava��Objects�N���X�̃T���v��
 * 
 * @author masato
 * 
 */
public class ObjectsSample {
	public void doIt() {

		// �I�u�W�F�N�g�̔�r�BStringUtils.equals�`�b�N�BNull���|���Ȃ�
		Person a = new Person("taro", 10);
		Person b = new Person("jiro", 10);

		boolean diff = Objects.equal(a, b);
		SimpleLogger.debug("a equal b is " + diff);

		// HashCode //hashcodeBuilder���Ƃ悯���ȃ����o�ϐ����������Ⴄ�Ƃ��Ƃ��ɂ����H
		SimpleLogger.debug("a and b 's hashcode is " + Objects.hashCode(a, b));

		// toStringHelper
		SimpleLogger.debug(new ObjectsSample("hoge", "huga").toString());

		// first Non Null
		// ��������Null�łȂ���Α�������Ԃ��B
		Object r1 = Objects.firstNonNull(a, b);
		SimpleLogger.debug("taro , jiro ... :" + r1.toString());
		// ��������Null�Ȃ���������������B
		Object r2 = Objects.firstNonNull(null, b);
		SimpleLogger.debug("null , jiro ... :" + r2.toString());
		// ��������Null��������ʂ��
		try {
			Objects.firstNonNull(null, null);
		} catch (NullPointerException e) {
			SimpleLogger.debug("null , null ... :NullPointerException!!");
		}
	}

	public ObjectsSample() {
	}

	public ObjectsSample(String m1, String m2) {
		this.m1 = m1;
		this.m2 = m2;
	}

	String m1;
	String m2;

	@Override
	public String toString() {
		// toStringHelper //toStringBuilder�ł����񂶂�ˁH
		return Objects.toStringHelper(this).add("m1", m1).toString();
	}

	public static void main(String[] args) {
		new ObjectsSample().doIt();
	}
}
