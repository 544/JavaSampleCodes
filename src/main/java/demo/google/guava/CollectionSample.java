package demo.google.guava;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import utils.SimpleLogger;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import demo.bean.Person;

public class CollectionSample {

	public static void main(String[] args) {

		// Listは宣言時に値を設定できる。
		List<String> list1 = Lists.newArrayList("hoge", "huga", "piyo", "tao",
				"tarou");
		SimpleLogger.debug(list1.toString());

		// newHashMapは宣言時に値を設定できない、ImmutableMapはできるけど。
		Map<String, Person> map1 = Maps.newHashMap(ImmutableMap.of( //
				"hoge", new Person(), "fuga", new Person("bbb", 11)));
		SimpleLogger.debug(map1.toString());

		// Collectionにフィルターをかけられる。けどなんかくどい。
		List<Integer> list2 = Lists.newArrayList(1, 2, 3, 4, 5, 6);
		Collection<Integer> list3 = Collections2.filter(list2,
				new Predicate<Integer>() {
					@Override
					public boolean apply(Integer input) {
						return (input % 2 == 0);
					}
				});
		SimpleLogger.debug("filterd..." + list3.toString());

		// Collectionに変換をかけられる。Mapはむりぽ。
		Collection<String> list4 = Collections2.transform(list2,
				new Function<Integer, String>() {
					@Override
					public String apply(Integer input) {
						return "[" + input + "]";
					}
				});
		SimpleLogger.debug("transformed..." + list4.toString());

		// Immutableなコレクション
		List<String> il = ImmutableList.of("hoge", "hufa", "piyo");
		try {
			il.add("hoge");
		} catch (UnsupportedOperationException e) {
			SimpleLogger.debug("immutable List is not Operation"); // 操作できない
		}
		Map<String, Person> im = ImmutableMap.of("hoge", new Person("taro", 1),
				"huga", new Person("jiro", 3));
		try {
			im.remove("hoge");
		} catch (UnsupportedOperationException e) {
			SimpleLogger.debug("immutable Map is not Operation"); // 操作できない。
		}

	}
}
