package utils;

public final class LoggerUtils {

	public static String getSig() {
		
		StackTraceElement st = (new Throwable()).getStackTrace()[1];
		
		return st.getClassName() + "#" + st.getMethodName();

	}
}
