package com.alibaba.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密工具类
 */
public class MD5Util {

	public static void main(String[] args) {
		String s = "123456";
		System.out.println(md5(s));
	}

	/**
	 * md5加密
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return DigestUtils.md5Hex(str);
	}

}
