package com.sprint.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author x_zhaohu		17/03/28
 */
public class DBReflectionUtil {

	/**
	 * 通过key更新记录
	 * @param tableName 表名
	 * @param updataMap 需要更新的字段和字段值组成的key-value
	 * @param optionMap 条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 */
	public static int updateByKey(String tableName, Map<String, Object> updateMap,
									Map<String, Object> optionMap, String operator1) {
		isEnabled(tableName, updateMap, optionMap, operator1);	
		checkMap(updateMap);
		return update(tableName, updateMap, optionMap, operator1, null);
	} 

	/**
	 * 通过Keys更新一条或多条记录
	 * @param tableName 表名
	 * @param updataMap 需要更新的字段和字段值组成的key-value
	 * @param optionMap 条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 * @param operator2 逻辑操作，目前只支持”and” 或 “or” 
	 */
	public static int updateByKeys(String tableName, Map<String, Object> updateMap,
							Map<String, Object> optionMap, String operator1, String operator2) {
		isEnabled(tableName, updateMap, optionMap, operator1, operator2);
		checkMap(updateMap);
		return update(tableName, updateMap, optionMap, operator1, operator2);
	}

	/**
	 * 无条件修改全部记录
	 * @param tableName 表名
	 * @param updataMap 需要更新的字段和字段值组成的key-value
	 */
	public static int updateAll(String tableName, Map<String, Object> updateMap) {
		checkTableName(tableName);
		checkMap(updateMap);
		return update(tableName, updateMap, null, null, null);
	}

	/**
	 * 通过条件修改全部记录
	 * @param tableName 表名
	 * @param updataMap 需要更新的字段和字段值组成的key-value
	 * @param optionMap 条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 * @param operator2 逻辑操作，目前只支持”and” 或 “or” 
	 */
	private static int update(String tableName, Map<String, Object> updateMap,
						Map<String, Object> optionMap, String operator1, String operator2) {
		
		StringBuffer sb = new StringBuffer("update ")
											.append(tableName)
											.append(" set ");
		sb.append(getPartSql(updateMap, "=", ","));
		if (optionMap != null) {
			sb.append(" where ")
			  .append(getPartSql(optionMap, operator1, operator2));
		}
		String sql = sb.toString();
		System.out.println(sql);
		Connection conn = ConnectionUtil.getConnection();	
		PreparedStatement pstmt = null;
		int updateRow = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			updateRow = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRow;	
	} 

	/**
	 * 通过key删除记录
	 * @param tableName	表名
	 * @param map 		条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 * @return 			0或>0
	 */
	public static int deleteByKey(String tableName,
							Map<String, Object> map, String operator1) {
		isEnabled(tableName, map, operator1);
		StringBuffer sb = new StringBuffer(tableName).append(" where ")
							.append(getPartSql(map, operator1, null));
		return deleteAll(sb.toString());
	}

	/**
	 * 通过keys删除记录。
	 * @param tableName	表名
	 * @param map 		条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 * @param operator2 逻辑操作，目前只支持”and” 或 “or”
	 * @return 			0或>0
	 */ 
	public static int deleteByKeys(String tableName, Map<String, Object> map,
										String operator1, String operator2) {
		isEnabled(tableName, map, operator1, operator2);
		StringBuffer sb = new StringBuffer(tableName).append(" where ")
							.append(getPartSql(map, operator1, operator2));
		return deleteAll(sb.toString());
	}


	/**
	 * 清空表中数据
	 * @param tableName 表名
	 * @return 			0或>0
	 */
	public static int deleteAll(String tableName) {
		checkTableName(tableName);
		StringBuffer sb = new StringBuffer("delete from ")
										.append(tableName);
		Connection conn = ConnectionUtil.getConnection();
		String sql = sb.toString();
		System.out.println(sql);
		PreparedStatement pstmt = null;
		int rowNum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rowNum = pstmt.executeUpdate();
			System.out.println(rowNum);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	/**
	 * 通过key获取单条记录
	 * @param tableName 表名
	 * @param object 	获取的对象，不用设置数据，仅 new Object()
	 * @param map 		条件字段和字段值组成的key-value
	 * @return          list 
	 */
	public static <T> T findOnlyByKey(String tableName, T object,
							Map<String, Object> map) {
		isEnabled(tableName, object, map);
		List<T> list = findMoreByKey(tableName, object, map, "=");
		if ( list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 通过key获取多条记录
	 * @param tableName 表名
	 * @param object 	获取的对象，不用设置数据，仅 new Object()
	 * @param map 		条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 * @return          list 
	 */
	public static <T> List<T> findMoreByKey(String tableName, T object, 
								  Map<String, Object> map, String operator1) {
		isEnabled(tableName, object, map, operator1);
		StringBuffer sb = new StringBuffer(tableName).append(" where ");
			sb.append(getPartSql(map, operator1, null));
		return findAll(sb.toString(), object); 
	}


	/**
	 * 通过keys获取单条记录
	 * @param tableName 表名
	 * @param object 	获取的对象，不用设置数据，仅 new Object()
	 * @param map 		条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 * @param operator2 逻辑操作，目前只支持”and” 或 “or”
	 * @return			list 
	 */
	public static <T> T findOnlyByKeys(String tableName, T object,
						Map<String, Object> map, String operator1, String operator2) {
		isEnabled(tableName, object, map, operator1, operator2);
		List<T> list = findMoreByKeys(tableName, object, map, operator1, operator2);
		if (list != null && list.size() != 0) {
			return list.get(0);
		}
		return null;
		
	}

	/**
	 * 通过keys获取多条记录
	 * @param tableName 表名
	 * @param object 	获取的对象，不用设置数据，仅 new Object()
	 * @param map 		条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like”
	 * @param operator2 逻辑操作，目前只支持”and” 或 “or”
	 * @return			list 
	 */
	public static <T> List<T> findMoreByKeys(String tableName, T object,
						Map<String, Object> map, String operator1, String operator2) {
		isEnabled(tableName, object, map, operator1, operator2);
		StringBuffer sb = new StringBuffer(tableName).append(" where ");
			sb.append(getPartSql(map, operator1, operator2));
		return findAll(sb.toString(), object);
	}

	/**
	 * 获取所有的数据
	 * @param tableName 表名
	 * @param object    实体类的对象 
	 * @return			表中所以的记录 
	 */
	public static <T> List<T> findAll(String tableName, T object) {
		isEnabled(tableName, object);
		List<T> list = new ArrayList<T>();
		Map<String, Class> paramsType = getParamsType(object);
		Set<String> keys = paramsType.keySet();
		StringBuilder sb = new StringBuilder("select * from ").append(tableName);
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement pstmt;
		String sql = sb.toString();
		System.out.println(sql);
		int capacity = paramsType.size();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				Object obj = object.getClass().newInstance();
				for (String key : keys) {
					if (paramsType.get(key) == int.class) {
						Method m = getMethod(object.getClass(), "set", key);
						m.invoke(obj, rs.getInt(key));
					} else if (paramsType.get(key) == java.lang.String.class) {
						Method m = getMethod(object.getClass(), "set", key);
						m.invoke(obj, rs.getString(key));
					} else if (paramsType.get(key) == double.class) {
						Method m = getMethod(object.getClass(), "set", key);
						m.invoke(obj, rs.getDouble(key));
					} else if (paramsType.get(key) == float.class) {
						Method m = getMethod(object.getClass(), "set", key);
						m.invoke(obj, rs.getFloat(key));
					} else if (paramsType.get(key) == long.class) {
						Method m = getMethod(object.getClass(), "set", key);
						m.invoke(obj, rs.getLong(key));
					}
				}	
				list.add(((T)obj));
			}
			pstmt.close();
			conn.close();
			return list;
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 数据存储操作
	 * @param tableName 表名 
	 * @param object 	存储对象
	 * @return
	 */
	public static <T> int insert(String tableName, T object) {
		isEnabled(tableName, object);
		Map<String, Class> paramsType = getParamsType(object);
		Set<String> keys = paramsType.keySet();
		List<String> params = new ArrayList<String>();
		
		StringBuffer sb = new StringBuffer("insert into " + tableName);
		sb.append("(");
	
		int count = 0;
		int capacity = keys.size();
		
		boolean isExistAutoId = false;
		for (String key : keys) {
			if (key.equals("id")) {
				count++;
				capacity--;
				isExistAutoId = true;
				continue;
			}
			sb.append(key);
			params.add(key);
			if (!isExistAutoId) {
				if (count != (capacity - 1))
					sb.append(",");
			} else {
				if (count != capacity)
					sb.append(",");
			}
			count++;
		}

		sb.append(")values(");
		for (int i = 0; i < capacity; i++) {
			sb.append("?");
			if (i == (capacity -1)) {
				sb.append(")");
			} else {
				sb.append(",");
			}
		}
		
		Connection conn = ConnectionUtil.getConnection();
		String sql = sb.toString();
		System.out.println(sql);
		PreparedStatement pstmt;
		int insertRow = 0;	
		try {
			pstmt = conn.prepareStatement(sql);
			// int , String , double ,float ,Long
			for (int i = 1; i <= capacity; i++) {
				String key = params.get(i-1);
				if (paramsType.get(key) == int.class) {
					Method m = getMethod(object.getClass(), "get", key);
					pstmt.setInt(i, (Integer) m.invoke(object));
				} else if (paramsType.get(key) == java.lang.String.class) {
					Method m = getMethod(object.getClass(), "get", key);
					pstmt.setString(i, (String) m.invoke(object));
				} else if (paramsType.get(key) == double.class) {
					Method m = getMethod(object.getClass(), "get", key);
					pstmt.setDouble(i, (Double) m.invoke(object));
				} else if (paramsType.get(key) == float.class) {
					Method m = getMethod(object.getClass(), "get", key);
					pstmt.setFloat(i, (Float)m.invoke(object));
				} else if (paramsType.get(key) == long.class) {
					Method m = getMethod(object.getClass(), "get", key);
					pstmt.setLong(i, (Long)m.invoke(object));
				}
			}
			insertRow = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertRow;
	}
	
	/**
	 * 利用操作符将map中的key-value组合成sql语句
	 * @param map 		字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like” 
	 * @param operator2 逻辑操作，目前只支持”and”或”or” 
	 * @return 			部分sql语句
	 */
	private static String getPartSql(Map<String, Object> map, String operator1, String operator2) {
		StringBuffer sb = new StringBuffer();
		Set<String> keys = map.keySet();
		int index = 0;
		for (String key : keys) {
				sb.append(key).append(" " + operator1 + " ");
				System.out.println(key + " :" + map.get(key).getClass());
				if (map.get(key).getClass() == String.class) {
					sb.append("\'")
					  .append(map.get(key))
					  .append("\'");
				} else {
					sb.append(map.get(key));
				}
				if (index != (keys.size() - 1)) {
					sb.append(" " + operator2 + " ");
				}
				index++;
		}
		return sb.toString();
	}

	/** 
	 * 通过对象获取该类中的字段名和类型
	 * @param object 实体类的对象
	 * @return		 将字段名和类型存放进Map返回
	 */
	private static <T> Map<String, Class> getParamsType(T object) {
		checkObject(object);
		Class<?> clz = object.getClass();
		Field[] fields = clz.getDeclaredFields();
		Map<String, Class> paramsType = new HashMap<String,  Class>(); 
		for (Field field : fields) {
			paramsType.put(field.getName(), field.getType());
		}
		return paramsType;
	} 
	
	/**
	 * 获取取类中的字段的getter或setter方法
	 * @param clz			类类型
	 * @param startWithName 方法前缀
	 * @param param			字段
	 * @return				
	 */
	private static Method getMethod(Class clz, String startWithName, String param) {
		isEnabled(clz, startWithName);
		if (param.trim().equals("") || param == null)
			throw new IllegalArgumentException("字段为空");
		List<Method> methods = getMethods(clz, startWithName);
		String name = new StringBuilder()
						.append(Character.toUpperCase(param.charAt(0)))
						.append(param.substring(1))
						.toString();
		for (Method m : methods) {
			if (m.getName().equals(startWithName + name)) {
				return m;
			}
		}
		return null;
	}
	
	/**
	 * 获取方法列表
	 * @param clz			类类型
	 * @param startWithName 方法前缀
	 * @return
	 */
	private static List<Method> getMethods(Class clz, String startWithName) {
		isEnabled(clz, startWithName);
		List<Method> methods = new ArrayList<Method>();
		for (Method m : clz.getDeclaredMethods()) {
			if (m.getName().startsWith(startWithName)) {
				methods.add(m);
			}
		}
		return methods;
	}

	private static boolean isEnabled(Class clz, String startWithName) {
		if (clz == null) 
			throw new IllegalArgumentException("类类型为空");
		if (startWithName.trim().equals("") || startWithName == null
				|| (!(startWithName.equals("set") || startWithName.equals("get")))) 
			throw new IllegalArgumentException("方法前缀不合法");
		return true;	
	}
	
	private static boolean checkTableName(String tableName) {
		if (tableName.trim().equals("") || tableName == null)
			throw new IllegalArgumentException("表名为空");
		return true;
	}

	private static <T> boolean checkObject(T object) {
		if (object == null)
			throw new IllegalArgumentException("对象为空");
		return true;
	}

	private static boolean checkMap(Map<String, Object> map) {
		if (map == null || map.size() == 0) 
			throw new IllegalArgumentException("字段和字段值组成的key-value为空");
		return true;
	}

	private static boolean checkOperator1(String operator1) {
		if (operator1.trim().equals("") || operator1 == null
				|| (!(operator1.equals("=") || operator1.equals("like"))))
			throw new IllegalArgumentException("操作类型不支持,操作类型仅支持'='or'like'");
		return true;
	}

	private static boolean checkOperator2(String operator2) {
		if (operator2.trim().equals("") || operator2 == null
				|| (!(operator2.equals("and") || operator2.equals("or"))))
			throw new IllegalArgumentException("逻辑操作不支持，逻辑操作仅支持'and' or 'or'");
		return true;
	}
	
	/**
	 * 检查数据是否合法
	 * @param tableName 表名
	 * @param object 	实体类的对象
	 * @param map 		条件字段和字段值组成的key-value
	 * @param operator1 操作类型，目前只支持”=”或”like” 
	 * @param operator2 逻辑操作，目前只支持”and”或”or” 
	 * @return          true
	 */
	private static <T> boolean isEnabled(String tableName, T object) {
		checkTableName(tableName);
		checkObject(object);
		return true;
	}

	private static <T> boolean isEnabled(String tableName, T object, Map<String, Object> map) {
		isEnabled(tableName, object);
		checkMap(map);
		return true;
	}
	private static <T> boolean isEnabled(String tableName, T object,
							Map<String, Object> map, String operator1) {
		isEnabled(tableName, object, map);
		checkOperator1(operator1);
		return true;
	}
	private static <T> boolean isEnabled(String tableName, T object,
							Map<String, Object> map, String operator1, String operator2) {
		isEnabled(tableName, object, map, operator1);
		checkOperator2(operator2);
		return true;
	}

	private static boolean isEnabled(String tableName, Map<String, Object> map, String operator1) {
		checkTableName(tableName);
		checkMap(map);
		checkOperator1(operator1);
		return true;
	}

	private static boolean isEnabled(String tableName, Map<String, Object> map,
											String operator1, String operator2) {
		isEnabled(tableName, map, operator1);
		checkOperator2(operator2);
		return true;
	}

	//------------------------------------------------------------------------------------
}
