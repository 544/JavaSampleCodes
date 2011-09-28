package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

/**
 * Collection関連のUtility
 * @author matsumoto-m
 *
 */
public final class CollectionUtils {

	private CollectionUtils() {}

	/**
	 * 文字列Key/ValueなMapを作成するUtilityメソッド
	 * <pre>
	 * 引数の書式は、"key -> value" とする。
	 * KVにあたる文字列の前後空白は無視される。
	 * また、空白をValueにセットしたい場合は、''で囲むこと
	 * クラス名が長いので、StaticImportがおすすめ
	 *
	 * 使用例：
	 * import static jp.co.future.ars.common.utils.CollectionUtils.map;
	 * Map&lt;String, Object&gt; kv = CollectionUtils.map(
	 *   " 1 -> 2",
	 *   " led zeppelin -> ' blcak dog '",
	 *   " judas priest -> painkiller "
	 * );
	 *
	 * => 結果のMapのToString {1=2, led zeppelin= blcak dog , judas priest=painkiller}
	 *
	 * </pre>
	 * @param srcs Mapに格納したいデータを"key -> value"の書式で指定
	 * @return 生成したHashMap
	 */
	public static Map<String, String> map(String... params) {
		Map<String, String> result = new HashMap<String, String>();
		for(String param: params) {
			String[] kvs = param.split("->");
			String key = rmvPrePostSc(StringUtils.trim(kvs[0]));
			String val = rmvPrePostSc(StringUtils.trim(kvs[1]));
			result.put(key, val);
		}
		return result;
	}

	/**
	 * Listを作成するUtilityメソッド。
	 * <pre>
	 * 任意のオブジェクトの適用可能
	 * クラス名が長いので、StaticImportがおすすめ
	 *
	 * 使用例：
	 * import static jp.co.future.ars.common.utils.CollectionUtils.list;
	 * List&lt;String&gt; li = list("123", "45", "foo");
	 *
	 * </pre>
	 * @param <T> Listに格納する型
	 * @param params listに格納するオブジェクトを可変長引数で指定する。
	 * @return 生成したArrayList
	 */
	public static <T> List<T> list(T... params) {
		List<T> result = new ArrayList<T>();
		for (T t : params) {
			result.add(t);
		}
		return result;
	}

	/**
	 * HashSetを作成するUtilityメソッド。
	 * <pre>
	 * HashSetを返すので順序は不定なので注意
	 * 任意のオブジェクトの適用可能
	 * クラス名が長いので、StaticImportがおすすめ
	 *
	 * 使用例：
	 * import static jp.co.future.ars.common.utils.CollectionUtils.hashSet;
	 * Set&lt;String&gt; li = hashSet("123", "45", "foo");
	 *
	 * </pre>
	 * @param <T> Setに格納する型
	 * @param params Setに格納するオブジェクトを可変長引数で指定する。
	 * @return 生成したHashSet
	 */
	public static <T> Set<T> hashSet(T... params) {
		Set<T> result = new HashSet<T>();
		for (T t : params) {
			result.add(t);
		}
		return result;
	}

	/**
	 * 要素の昇順でソートされるTreeSetを作成するUtilityメソッド。
	 * <pre>
	 * 任意のオブジェクトの適用可能
	 * クラス名が長いので、StaticImportがおすすめ
	 *
	 * 使用例：
	 * import static jp.co.future.ars.common.utils.CollectionUtils.treeSet;
	 * Set&lt;String&gt; li = treeSet("123", "45", "foo");
	 *
	 * </pre>
	 * @param <T> Setに格納する型
	 * @param params Setに格納するオブジェクトを可変長引数で指定する。
	 * @return 生成したTreeSet
	 */
	public static <T> Set<T> treeSet(T... params) {
		Set<T> result = new TreeSet<T>();
		for (T t : params) {
			result.add(t);
		}
		return result;
	}


	/**
	 * MapからListへ変換する。
	 * <pre>
	 * Listへ格納する順番は、Key項目の昇順で格納。
	 * Key値は捨てられる。
	 * </pre>
	 *
	 * @param source 変換元Map
	 * @return 変換して新規作成したList
	 */
	public static <K,V> List<V> map2ListKeyAsc(Map<K, V> source) {
		List<V> result = new ArrayList<V>();
		Set<K> sortedKeys = new TreeSet<K>(source.keySet());
		for(K key:sortedKeys) {
			result.add(source.get(key));
		}
		return result;
	}


	// ===================== private ===================================================
	/**
	 * Trim済みの文字列の前後の指定された文字を削除して返す。
	 */
	private static String rmvPrePostSc(String target) {
		final char SC = '\'';
		// ' で囲まれていた場合のみ、削除する。
		if(target.charAt(0) != SC || target.charAt(target.length() -1) != SC)
			return target;
		//前後1文字づつ削除
		return StringUtils.substring(target, 1 , target.length() -1 );
	}

	public static void main(String[] args) {


		Set<String> s = hashSet("A", "あ", "0");


		for(String d : s) {
			System.out.println(d);
		}

		s = new TreeSet<String>(s);
		for(String d : s) {
			System.out.println(d);
		}
	}



}
