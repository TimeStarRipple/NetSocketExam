package com.hand.zyb;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.google.gson.JsonObject;

/**
* json工具类
* @author zyb
* @version 1.0
* @date 2016年8月1日 下午7:50:58
*/
public class JsonUtil
{
	public static void createJsonFile(String[] strArr)
	{
		/*
		 * 创建Json对象，并添加属性
		 */
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty("name", strArr[0]);
		jsonObject.addProperty("open", strArr[1]);
		jsonObject.addProperty("close", strArr[2]);
		jsonObject.addProperty("current", strArr[3]);
		jsonObject.addProperty("high", strArr[4]);
		jsonObject.addProperty("low", strArr[5]);
		
		try
		{
			FileOutputStream fos = new FileOutputStream("Json.json");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(jsonObject.toString());
			bw.flush();
			
			bw.close();
			osw.close();
			fos.close();
			
			System.out.println("Json文件创建成功");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
