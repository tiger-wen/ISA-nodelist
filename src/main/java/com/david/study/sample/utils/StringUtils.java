package com.david.study.sample.utils;

import java.util.regex.Pattern;

/**
 * @author A148830
 * @Version 2018-01-03
 */
public class StringUtils {

	private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");
	 
    public static boolean isInteger(String str) {
        if (str == null || str.length() == 0)
            return false;
        return INT_PATTERN.matcher(str).matches();
    }
    
	/*
	 * compare to string
	 */
	public int compareStr(String str1,String str2) {
		
		int bl;
		bl = str1.compareTo(str2);
		
		if (bl > 0) {
			return 1;
		}
		return 0;
	}
	
    public static int parseInteger(String str) {
        if (!isInteger(str))
            return 0;
        return Integer.parseInt(str);
    }

}
