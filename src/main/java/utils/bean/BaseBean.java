/**
 * 
 */
package utils.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author masato
 * 
 */
public abstract class BaseBean {
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
