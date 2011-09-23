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
 * Collection�֘A��Utility
 * @author matsumoto-m
 *
 */
public final class CollectionUtils {

	private CollectionUtils() {}

	/**
	 * ������Key/Value��Map���쐬����Utility���\�b�h
	 * <pre>
	 * �����̏����́A"key -> value" �Ƃ���B
	 * KV�ɂ����镶����̑O��󔒂͖��������B
	 * �܂��A�󔒂�Value�ɃZ�b�g�������ꍇ�́A''�ň͂ނ���
	 * �N���X���������̂ŁAStaticImport����������
	 *
	 * �g�p��F
	 * import static jp.co.future.ars.common.utils.CollectionUtils.map;
	 * Map&lt;String, Object&gt; kv = CollectionUtils.map(
	 *   " 1 -> 2",
	 *   " led zeppelin -> ' blcak dog '",
	 *   " judas priest -> painkiller "
	 * );
	 *
	 * => ���ʂ�Map��ToString {1=2, led zeppelin= blcak dog , judas priest=painkiller}
	 *
	 * </pre>
	 * @param srcs Map�Ɋi�[�������f�[�^��"key -> value"�̏����Ŏw��
	 * @return ��������HashMap
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
	 * List���쐬����Utility���\�b�h�B
	 * <pre>
	 * �C�ӂ̃I�u�W�F�N�g�̓K�p�\
	 * �N���X���������̂ŁAStaticImport����������
	 *
	 * �g�p��F
	 * import static jp.co.future.ars.common.utils.CollectionUtils.list;
	 * List&lt;String&gt; li = list("123", "45", "foo");
	 *
	 * </pre>
	 * @param <T> List�Ɋi�[����^
	 * @param params list�Ɋi�[����I�u�W�F�N�g���ϒ������Ŏw�肷��B
	 * @return ��������ArrayList
	 */
	public static <T> List<T> list(T... params) {
		List<T> result = new ArrayList<T>();
		for (T t : params) {
			result.add(t);
		}
		return result;
	}

	/**
	 * HashSet���쐬����Utility���\�b�h�B
	 * <pre>
	 * HashSet��Ԃ��̂ŏ����͕s��Ȃ̂Œ���
	 * �C�ӂ̃I�u�W�F�N�g�̓K�p�\
	 * �N���X���������̂ŁAStaticImport����������
	 *
	 * �g�p��F
	 * import static jp.co.future.ars.common.utils.CollectionUtils.hashSet;
	 * Set&lt;String&gt; li = hashSet("123", "45", "foo");
	 *
	 * </pre>
	 * @param <T> Set�Ɋi�[����^
	 * @param params Set�Ɋi�[����I�u�W�F�N�g���ϒ������Ŏw�肷��B
	 * @return ��������HashSet
	 */
	public static <T> Set<T> hashSet(T... params) {
		Set<T> result = new HashSet<T>();
		for (T t : params) {
			result.add(t);
		}
		return result;
	}

	/**
	 * �v�f�̏����Ń\�[�g�����TreeSet���쐬����Utility���\�b�h�B
	 * <pre>
	 * �C�ӂ̃I�u�W�F�N�g�̓K�p�\
	 * �N���X���������̂ŁAStaticImport����������
	 *
	 * �g�p��F
	 * import static jp.co.future.ars.common.utils.CollectionUtils.treeSet;
	 * Set&lt;String&gt; li = treeSet("123", "45", "foo");
	 *
	 * </pre>
	 * @param <T> Set�Ɋi�[����^
	 * @param params Set�Ɋi�[����I�u�W�F�N�g���ϒ������Ŏw�肷��B
	 * @return ��������TreeSet
	 */
	public static <T> Set<T> treeSet(T... params) {
		Set<T> result = new TreeSet<T>();
		for (T t : params) {
			result.add(t);
		}
		return result;
	}


	/**
	 * Map����List�֕ϊ�����B
	 * <pre>
	 * List�֊i�[���鏇�Ԃ́AKey���ڂ̏����Ŋi�[�B
	 * Key�l�͎̂Ă���B
	 * </pre>
	 *
	 * @param source �ϊ���Map
	 * @return �ϊ����ĐV�K�쐬����List
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
	 * Trim�ς݂̕�����̑O��̎w�肳�ꂽ�������폜���ĕԂ��B
	 */
	private static String rmvPrePostSc(String target) {
		final char SC = '\'';
		// ' �ň͂܂�Ă����ꍇ�̂݁A�폜����B
		if(target.charAt(0) != SC || target.charAt(target.length() -1) != SC)
			return target;
		//�O��1�����Â폜
		return StringUtils.substring(target, 1 , target.length() -1 );
	}

	public static void main(String[] args) {


		Set<String> s = hashSet("A", "��", "0");


		for(String d : s) {
			System.out.println(d);
		}

		s = new TreeSet<String>(s);
		for(String d : s) {
			System.out.println(d);
		}
	}



}
