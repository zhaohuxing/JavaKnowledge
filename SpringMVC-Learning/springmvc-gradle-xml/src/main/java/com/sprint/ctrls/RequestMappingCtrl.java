package com.sprint.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class RequestMappingCtrl {


	/*URI普通映射模式,一个方法可以对应多个uri*/
	@ResponseBody //为了清晰看到结果，这里直接返回string了.
	@RequestMapping(value={"/uri1", "/uri2", "/uri3/uri4"})
	public String simpleURI() { // 这里中文是乱码，后续处理
		return "@RequestMapping in simpleURI" + "理想还是要有的，万一实现了呢！";
	}

	@ResponseBody
	/*URI模板映射模式*
	 *
	 *{}中的数据可以是任意，但是不能包含二级uri.
	 * 通过@PathVariable可以获取{}中的参数
	 */
	@RequestMapping(value={"/uri5/{args}"})
	public String templateURI() {
		return "@RequestMapping in templateURI" + "理想还是要有的，万一就实现了呢！";
	}

	@ResponseBody
	@RequestMapping(value={"/uri6/{args}/uri7"})
	public String templateURI1() {
		return "@RequestMapping in templateURI1" + "理想还是要有的，万一就实现了呢！";
	}

	@ResponseBody
	@RequestMapping(value={"uri8/{args}/uri9/{arg}"})
	public String templateURI2() {
		return "@RequestMapping in templateURI2" + "理想还是要有的，万一就实现了呢！";
	}

	/*Ant风格映射模式
	 *	？ 匹配任意单个字符
	 *	*  匹配0或任意数量的字符
	 *	** 匹配目录或多目录
	 * */
	@ResponseBody
	@RequestMapping(value={"/uri10?"})
	public String antURI() {
		return "@RequestMapping in antURI1" + "理想还是要有的，万一实现了呢！";
	}

	@ResponseBody
	@RequestMapping(value={"/uri11/?"})
	public String antURI2() {
		return "@RequestMapping in antURI2" + "理想还是要有的，万一实现了呢！";
	}

	@ResponseBody
	@RequestMapping(value={"/uri12/?/*"})
	public String antURI3() {
		return "@RequestMapping in antURI3" + "理想还是要有的，万一实现了呢！";
	}

	@ResponseBody
	@RequestMapping(value={"/uri13/?/*/**"})
	public String antURI4() {
		return "@RequestMapping in antURI4" + "理想还是要有的，万一实现了呢！";
	}

	/**
	 *	正则映射模式
	 *	格式{变量名:正则表达式}，通过@PathVariable提取变量名的值
	 *
	 */
	@ResponseBody
	@RequestMapping(value={"/uri14/{age:\\d+}"}) // 匹配/uri14/任意数量数字
	public String regexURI1() {
		return "@RequestMapping in regexURI1" + "理想还是要有的，万一实现了呢！"; 
	}

	@ResponseBody
	@RequestMapping(value={"/uri15/{name:[a-zA-Z]+}&{age:\\d+}"})
	public String regexURI2(@PathVariable("name")String name, @PathVariable("age")int age) {
		return "name:" + name + ", age:" + age;
	}

	/**
	 *	请求方法的限定
	 *	一般常见的CRUD:get, post, update, delete
	 *	get:获取数据限定
	 *	post:提交数据限定
	 *	update:更新数据限定
	 *	delete:删除数据限定
	 *  也可以@RequestMapping(value={"/method"}, method={RequestMethod.GET, RequestMethod.POST, ..,RequestMethod.PUT})
	 */
	@ResponseBody
	@RequestMapping(value={"/method"}, method=RequestMethod.GET)
	public String getMethod() {
		return "请求方法必须是GET,才能到达功能方法进行用于获取数据操作";
	}

	@ResponseBody
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public String postMethod() {
		return "请求方法必须是POST,才能到达功能方法进行提交数据操作";
	}

	@ResponseBody
	@RequestMapping(value="/method", method=RequestMethod.PUT)
	public String updateMethod() {
		return "请求方法必须是UPDATE,才能到达功能方法进行修改数据操作";
	}
	
	@ResponseBody
	@RequestMapping(value="/method", method=RequestMethod.DELETE)
	public String deleteMethod() {
		return "请求方法必须时DELETE, 才能到达功能方法进行删除数据";
	}
	
	/**
	 *	请求参数限定---指定参数名
	 *	params="参数名", 访问路径必须args?test=
	 *	也可以使用非, params="!参数名", 访问路径中的参数不能存在“参数名”
	 *	也可以给参数指定value , params="name=zhangsan"
	 *	也可以这么搞: params="name!=zhangsan", Name不允许等于zhangsan
	 *	params={"test", "test1"}, 然而这不是或了，而是且！
	 */
	@ResponseBody
	@RequestMapping(value="args", params="test", method=RequestMethod.GET)
	public String argsMethod() {
		return "测试指定参数名";	
	}

	@ResponseBody
	@RequestMapping(value="args", params="name=zhangsan", method=RequestMethod.GET)
	public String argsMethod1() {
		return "测试指定参数与value";
	}
	
	@ResponseBody
	@RequestMapping(value="args", params="name!=zhangsan", method=RequestMethod.GET)
	public String argsMethod2() {
		return "测试指定参数与value,不等的情况";
	}
	
	@ResponseBody
	@RequestMapping(value="args", params={"test", "submit=true"}, method=RequestMethod.GET)
	public String argsMethod3() {
		return "测试指定test&submit=true";
	}

	/**
	 *	请求头限定
	 *	headers="headersArgs", 请求头中必须有这些参数才可以
	 *	headers="Accept=application/json", request header中Accept:application/json 此功能方法才会响应
	 *	headers="Accept!=application/json", request header中Accept: !application/json 才可以
	 *	headers={"headersAgs", "Accpet=application/json"}，
	 *request header中 需要存在headersArgs参数，Accept:application/json才ok
	 *
	 */
	@ResponseBody
	@RequestMapping(value="headers", headers="Accept=application/json", method=RequestMethod.GET)
	public String headersMethod() {
		return "headerArgs is exist";
	}

	/**
	 *	@RequestMapping中参数总结:
	 *	1.values	限制映射uri
	 *	2.method 	限制请求方法
	 *	3.params 	限制请求参数
	 *	4.headers	限制请求头
	 */
}
