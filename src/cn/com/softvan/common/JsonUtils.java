package cn.com.softvan.common;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import net.sf.json.JSONObject;
import cn.com.softvan.bean.config.ConfigJsonBean;
import cn.com.softvan.bean.config.ToInfoBean;

public class JsonUtils {
	
	/**
	 * 将string数据转化为json数据
	 */
    public static String stringToJson(String s) {
        if (s == null) {
            return nullToJson();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            case '/':
                sb.append("\\/");
                break;
            default:
                if (ch >= '\u0000' && ch <= '\u001F') {
                    String ss = Integer.toHexString(ch);
                    sb.append("\\u"); 
                    for(int k = 0; k < 4 - ss.length(); k++) {
                        sb.append('0');
                    }
                    sb.append(ss.toUpperCase());
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    /*
     * 将null值转化为json
     */
    public static String nullToJson() {
        return "";
    }

    /**
     * 将object转化为json数据
     */
    public static String objectToJson(Object obj) {
        StringBuilder json = new StringBuilder();
        if (obj == null) {
            json.append("\"\"");
        } else if (obj instanceof Number) {
            json.append(numberToJson((Number) obj));
        } else if (obj instanceof Boolean) {
            json.append(booleanToJson((Boolean) obj));
        } else if (obj instanceof String) {
            json.append("\"").append(stringToJson(obj.toString())).append("\"");
        } else if (obj instanceof Object[]) {
            json.append(arrayToJson((Object[]) obj));
        } else if (obj instanceof List) {
            json.append(listToJson((List<?>) obj));
        } else if (obj instanceof Map) {
            json.append(mapToJson((Map<?, ?>) obj));
        } else if (obj instanceof Set) {
            json.append(setToJson((Set<?>) obj));
        } else {
            json.append(beanToJson(obj));
        }
        return json.toString();
    }

    /**
     * @param bean
     *            bean对象
     * @return String
     */
    public static String beanToJson(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo(bean.getClass(), 
            		Object.class).getPropertyDescriptors();
        } catch (IntrospectionException e) {	}
        if (props != null) {
            for(int i = 0; i < props.length; i++) {
                try {
                    String name = objectToJson(props[i].getName());
                    String value = objectToJson(props[i].getReadMethod().invoke(bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                } catch (Exception e) {		}
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    public static String appendJSON(String jsons, String subJson, boolean isEnd) {
    	StringBuilder json = new StringBuilder(jsons);
    	String comma = isEnd ? "," : "";
    	json.insert(json.length()-1, comma + subJson);
    	
    	return json.toString();
    }
    
    public static String objectToJsonByPairKey(String name, Object value) {
    	return objectToJsonByPairKey(name, value, "k", "v");
    }
    		
    public static String objectToJsonByPairKey(String name, Object value, 
    								String nameKey, String valueKey) {
    	StringBuilder json = new StringBuilder();
		json.append("{");
		json.append(nameKey);
		json.append(":");
		json.append("\"" + name + "\"");
		json.append(",");
		json.append(valueKey);
		json.append(":");
		json.append(objectToJson(value));
		json.append("}");
		
		return json.toString();
    }
    
    public static String mapToJsonByPairKey(Map map) throws Exception {
    	return mapToJsonByPairKey(map, "k", "v");
    }
    
    public static String mapToJsonByPairKey(Map map, String nameKey, 
    										String valueKey) throws Exception {
		StringBuilder json = new StringBuilder();
		json.append("[");
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if (Validator.isEmpty(entry.getValue())) {
				continue;
			}
			json.append(objectToJsonByPairKey((String)entry.getKey()
					,entry.getValue()
					,nameKey
		    		,valueKey
			));
			json.append(",");
		}
		if (json.length() > 1) {
			json.deleteCharAt(json.length()-1);
		}
		json.append("]");
		
		return json.toString();
	}
    
    public static String beanToJsonByPairKey(Object bean) throws Exception {
    	return beanToJsonByPairKey(bean, "k", "v");
    }
    
    public static String beanToJsonByPairKey(Object bean, String nameKey, 
    										String valueKey) throws Exception {
		StringBuilder json = new StringBuilder();
		json.append("[");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), 
										Object.class).getPropertyDescriptors();
		} catch (IntrospectionException e) {	}
		if (props != null) {
			for(int i = 0; i < props.length; i++) {
				Object value = props[i].getReadMethod().invoke(bean);
				if (Validator.isEmpty(value)) {
					continue;
				}
				json.append(objectToJsonByPairKey(stringToJson(props[i].getName())
						,value
						,nameKey
			    		,valueKey
				));
				json.append(",");
			}
			if (json.length() > 1) {
				json.deleteCharAt(json.length()-1);
			}
		} 
		json.append("]");
		
		return json.toString();
	}
    
	public static void printList4AC(List list, Map map,	PrintWriter writer) throws Exception {
    	Object bean;
    	PropertyDescriptor[] props = null;
    	//writer.println("[");
    	for (int i=0;i<list.size();i++) {
    		bean = list.get(i);
    		try {
    			props = Introspector.getBeanInfo(bean.getClass(), 
    									Object.class).getPropertyDescriptors();
    		} catch (IntrospectionException e) {	}
    		if (props != null) {
    			StringBuilder json = new StringBuilder();
    			json.append("{");
    			
    			for(int j = 0; j < props.length; j++) {
    				if (map.containsKey(props[j].getName())){
        				json.append(map.get(props[j].getName()));
        				json.append(":");
        				json.append(objectToJson(props[j].getReadMethod().invoke(bean)));
        				json.append(",");
    				}
    			}
    			json.deleteCharAt(json.length()-1);
    			json.append("},");
    			writer.println(json.toString());
    		} 
    	}
    	//writer.println("]");
	}

    public static String listToJson4AC(List<?> list, Map<String, String> map) throws Exception {
    	StringBuilder json = new StringBuilder();
    	Object bean;
    	PropertyDescriptor[] props = null;
    	json.append("[");
    	for(int i=0; i<list.size(); i++) {
    		bean = list.get(i);
    		try {
    			props = Introspector.getBeanInfo(bean.getClass(), 
    									Object.class).getPropertyDescriptors();
    		} catch (IntrospectionException e) {	}
    		if (props != null) {
    			json.append("{");
    			for(int j = 0; j < props.length; j++) {
    				if (map.containsKey(props[j].getName())) {
        				json.append(map.get(props[j].getName()));
        				json.append(":");
        				json.append(objectToJson(props[j].getReadMethod().invoke(bean)));
        				json.append(",");
    				}
    			}
    			json.deleteCharAt(json.length()-1);
    			json.append("},");
    		} 
    	}
    	json.deleteCharAt(json.length()-1);
    	json.append("]");
    	
    	return json.toString();
    }
    
    public static String listToJsonByPairKey(List list) throws Exception {
    	StringBuilder json = new StringBuilder();
		json.append("[");
		for(int i=0; i< list.size(); i++) {
			json.append(JsonUtils.beanToJsonByPairKey(list.get(i)));
			json.append(",");
		}
		json.deleteCharAt(json.length()-1);
		json.append("]");
		
		return json.toString();
    }
    
    public static String listToJsonByPairKey2(List list) throws Exception {
    	StringBuilder json = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			json.append(JsonUtils.beanToJsonByPairKey(list.get(i)));
			json.append(",");
		}
		json.deleteCharAt(json.length() - 1);
		
		return json.toString();
    }
    
    /**
	 * @param list
	 *            list对象
	 * @return String
	 */
    public static String listToJson(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0) {
            for(Object obj : list) {
                json.append(objectToJson(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * @param array
     *            对象数组
     * @return String
     */
    public static String arrayToJson(Object[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0) {
            for(Object obj : array) {
                json.append(objectToJson(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * @param map
     *            map对象
     * @return String
     */
    public static String mapToJson(Map map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for(Object key : map.keySet()) {
                json.append(objectToJson(key));
                json.append(":");
                json.append(objectToJson(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * @param map
     *            map对象
     * @return String
     */
    public static String mapToJson(Map data,Map jsonKeys) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (data != null && data.size() > 0) {
            for(Object key : jsonKeys.keySet()) {
                json.append(objectToJson(key));
                json.append(":");
                json.append(objectToJson(data.get(jsonKeys.get(key))));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }
    
    /**
     * @param set
     *            集合对象
     * @return String
     */
    public static String setToJson(Set<?> set) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0) {
            for(Object obj : set) {
                json.append(objectToJson(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }
    
    /*
     * 将number转化为json数据
     */
    public static String numberToJson(Number number) {
        return number.toString();
    }

    /*
     * 将布尔值转化为json数据
     */
    public static String booleanToJson(Boolean bool) {
        return bool.toString();
    }

	/**
	 * 配置文件转为bean
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ConfigJsonBean jsonToBean2(String json) throws Exception {
		JSONObject obj = JSONObject.fromObject(json);
		Map<String, Class> classMap = new HashMap<String, Class>();
		// 数据库名
		classMap.put("dbs", ToInfoBean.class);
		// 数据库表名
		classMap.put("tables", ToInfoBean.class);
		// 返回参数
		classMap.put("outputs", ToInfoBean.class);
		// 图文分离字段汇总
		classMap.put("itsts", ToInfoBean.class);
		// 出参字段汇总(子服务使用)
		classMap.put("osubs", ToInfoBean.class);
		// 从表连接信息
		classMap.put("joins_other", ToInfoBean.class);
		// 活动参数
		classMap.put("inputs", ToInfoBean.class);
		// sql去除select
		classMap.put("outputs_sql", ToInfoBean.class);
		// 从表关联关系
		classMap.put("joins_other_sql", ToInfoBean.class);
		// 活动参数 有默认值的
		classMap.put("inputs_sql", ToInfoBean.class);
		// 入参字段汇总(来自主服务osub)
		classMap.put("isubs", ToInfoBean.class);
		// 入参必填字段汇总
		classMap.put("mbs", ToInfoBean.class);
		
		// ----------转换
		return (ConfigJsonBean) JSONObject.toBean(obj, ConfigJsonBean.class,classMap);
	}
    /**
     * 配置文件转为Map
     * @param json
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static Map jsonToMap2(String json) throws Exception{
    	 JSONObject obj = JSONObject.fromObject(json);
    	 Map<String, Class> classMap = new HashMap<String, Class>();
    	 //排序字段
    	 classMap.put("obcs",  Map.class);
    	//----------转换
    	return (Map) JSONObject.toBean(obj, Map.class,classMap);
    }
    //test
    public static void main(String[] args){
//    	ConfigJsonBean stu = jsonToBean2("{\"joins_main\":\"主表名\",\"dbs\":[{\"name\":\"数据库名1\"},{\"name\":\"数据库名2\"}]}");
//         	System.out.println(stu.getJoins_main());
//          for(ToInfoBean bean:stu.getDbs()){
//        	  System.out.println(bean.getName());
//          }
    	try {
//			Map map=jsonToMap2("{\"xx\":\"22\",\"obcs\":{\"a\":\"1#5\",\"b\":\"0#2\"}}");
//			System.out.println(map.get("xx"));
//			Map obcs=(Map) map.get("obcs");
//			if(obcs!=null){
//				String a=(String) obcs.get("a");
//				System.out.println(a);
//				String[] aa=a.split("#");
//				System.out.println(aa[1]);
//			}
//    		TreeMap m=new TreeMap<Integer,String>();
//			m.put(300,"10w");
//			m.put(5,"10f");
//			m.put(4,"10hh");
//			m.put(10,"10hh");
//			Iterable<Entry<Integer, String>> mm=m.entrySet();
//			for(Entry<Integer,String> e:mm){
//				System.out.println(e.getKey());
//			}
    		System.out.println(" time_format(2,2) "+"=> time_format(2,2)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
