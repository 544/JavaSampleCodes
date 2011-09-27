/* Copyright (C) 2011-2012 by Future Architect, Inc. Japan. All Rights reserved.  */
package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * Singleton
 * åƒèoíPà Ç≈LoggerÇ¬Ç≠ÇÈÇÃÇ≈íxÇ¢ÉàÅB
 * @author matsumoto-m
 *
 */
public final class SimpleLogger  {
	
	private final static SimpleLogger MYSELF = new SimpleLogger();
	private SimpleLogger() {}
	
	public static void debug(String msg) {
		MYSELF._debug(msg);
	}

	public static void debug(String format, Object... args) {
		MYSELF._debug(String.format(format, args));
	}

	private void _debug(String msg) {
		Log log = LogFactory.getLog(getClass());
		if(log.isDebugEnabled()) log.debug(msg);
		
	}}
