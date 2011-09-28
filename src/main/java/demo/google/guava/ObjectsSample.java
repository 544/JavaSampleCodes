package demo.google.guava;

import utils.SimpleLogger;

import com.google.common.base.Objects;
import demo.bean.Person;

/**
 * guavaのObjectsクラスのサンプル
 * 
 * @author masato
 * 
 */
public class ObjectsSample {
	public void doIt() {

		// オブジェクトの比較。StringUtils.equalsチック。Nullが怖くない
		Person a = new Person("taro", 10);
		Person b = new Person("jiro", 10);

		boolean diff = Objects.equal(a, b);
		SimpleLogger.debug("a equal b is " + diff);

		// HashCode //hashcodeBuilderだとよけいなメンバ変数が入っちゃうときとかにつかう？
		SimpleLogger.debug("a and b 's hashcode is " + Objects.hashCode(a, b));

		// toStringHelper
		SimpleLogger.debug(new ObjectsSample("hoge", "huga").toString());

		// first Non Null
		// 第一引数がNullでなければ第一引数を返す。
		Object r1 = Objects.firstNonNull(a, b);
		SimpleLogger.debug("taro , jiro ... :" + r1.toString());
		// 第一引数がNullなら第二引数をかえす。
		Object r2 = Objects.firstNonNull(null, b);
		SimpleLogger.debug("null , jiro ... :" + r2.toString());
		// 第二引数もNullだったらぬるぽ
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
		// toStringHelper //toStringBuilderでいいんじゃね？
		return Objects.toStringHelper(this).add("m1", m1).toString();
	}

	public static void main(String[] args) {
		new ObjectsSample().doIt();
	}
}
