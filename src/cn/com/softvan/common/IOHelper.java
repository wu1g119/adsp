/*
 * IO工具 Class
 *
 * VERSION  DATE        BY              REASON
 * -------- ----------- --------------- ------------------------------------------
 * 1.00     2011.11.16  Huyunlin           程序・发布
 * -------- ----------- --------------- ------------------------------------------
 * Copyright 2011 softvan System. - All Rights Reserved.
 *
 */
package cn.com.softvan.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * <p>IO工具类</p>
 *
 * @author Huyunlin
 */
public class IOHelper extends IOUtils {
	
	private static final transient Logger log = Logger.getLogger(IOHelper.class);
	
	/**
	 * <p>读取文件</p>
	 * @param key
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
    public static synchronized String readFileData(String fileName) throws Exception {
    	
        // 检查文件名是否存在
        if (Validator.isNullEmpty(fileName)) {
        	log.error("没有文件名，读取失败");
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader((new FileInputStream(fileName)), "UTF-8"));

		try {
			
			StringBuilder data = new StringBuilder();
			String line = null;
			while(( line = reader.readLine())!=null){
				data.append(line);
			}
			reader.close();
			return data.toString();
		} catch (Exception e){
			if (reader != null) {
				reader.close();
			}
			log.error("读取文件失败",e);
			return null;
		}
    }
    
    /**
     * <p>将文件内容写入文件</p>
     * 
     * @param savePath 文件全路径
     * @param data 写入的内容
     * @param fileName 文件名
     * @throws Exception
     */
    private synchronized void writeFile(String savePath, String data, String fileName) throws Exception {
    	//创建文件夹
    	File saveDirFile = new File(savePath);
    	if (!saveDirFile.exists()) {
    		saveDirFile.mkdirs();
    	}
    	//检查目录写权限
    	if(!saveDirFile.canWrite()){
    		log.error("目录没有写权限，写入文件失败");
    		throw new Exception();
    	}
    	File file=new File(savePath+fileName);
		PrintWriter pfp= new PrintWriter(file,"utf-8");
		pfp.print(data);
		pfp.flush();
		pfp.close();
    }
}
