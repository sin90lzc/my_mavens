package com.sin90lzc.java.util;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.JexlThreadedArithmetic;
import org.apache.commons.jexl2.MapContext;

public class ReplacementUtil {

	private final static String VAR_PATTERN_STR="\\$\\{(.*?)\\}";
	private final static Pattern VAR_PATTERN=Pattern.compile(VAR_PATTERN_STR);
	
	private static final JexlEngine ENGINE = new JexlEngine(null, new JexlThreadedArithmetic(false), null, null);
	
	static{
		ENGINE.setCache(512);
		ENGINE.setLenient(false);
		ENGINE.setSilent(false);
	}
	
	/**`
	 * 大文本变量替换
	 * @param src
	 * @param vars
	 * @return
	 */
	public static final String replace(String src,Map vars){
		MapContext context = new MapContext();
		Iterator iter = vars.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			context.set(entry.getKey().toString(), entry.getValue());
		}
		Matcher matcher=VAR_PATTERN.matcher(src);
		StringBuffer ret=new StringBuffer();
		while(matcher.find()){
			String key=matcher.group(1).trim();
			Expression ex=ENGINE.createExpression(key);
			String value=null;
			if(vars.containsKey(key)){
				//value=ex.evaluate(context).toString();
				value=vars.get(key).toString();
			}else{
				value="("+key+":未定义变量"+")";
			}
			
			matcher.appendReplacement(ret, value);
		}
		matcher.appendTail(ret);
		return ret.toString();
	}
}
