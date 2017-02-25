/**
 * 判断开始字符是否是XX
 * 
 * @author 孙宇
 */
$.startWith = function(source, str) {
	var reg = new RegExp("^" + str);
	return reg.test(source);
};
