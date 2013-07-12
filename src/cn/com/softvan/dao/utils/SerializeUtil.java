package cn.com.softvan.dao.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.softvan.common.JsonUtils;

public class SerializeUtil {
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
				// 序列化
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.writeObject(object);
				byte[] bytes = baos.toByteArray();
				oos.close();
				return bytes;
		} catch (IOException e) {
			System.out.println("序列化失败!");
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return new byte[0];
	}

	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}
	/***
	 * test 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception{
//		ConfigObject2Bean obj=new ConfigObject2Bean();
//		obj.setNode_name("1");
//		ConfigObject2Bean obj1=(ConfigObject2Bean) unserialize(serialize(obj));
//		System.out.println(obj1.getNode_name());
		List<String> l=new ArrayList<String>();
		l.add("1");
		l.add("2");
		List<String> m=(List<String>) unserialize(serialize(l));
		System.out.println(m.get(1));
	}
}