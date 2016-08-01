package com.hand.zyb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
* 用于获取URL上的数据
* @author zyb
* @version 1.0
* @date 2016年8月1日 下午7:40:18
*/
public class Get extends Thread
{
	private String str;
	
	@Override
	public void run()
	{
		try
		{
			/*
			 * 打开连接
			 */
			URL url = new URL("http://hq.sinajs.cn/list=sz300170");
			URLConnection uc = url.openConnection();
			
			/*
			 * 创建输入流
			 */
			InputStreamReader isr = new InputStreamReader(uc.getInputStream(), "GBK");
			BufferedReader br = new BufferedReader(isr);
			
			/*
			 * 读取输入的字符串
			 */
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			
			/*
			 * 对字符串进行提取，分割
			 */
			str = sb.toString();
			String s = str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
			String[] strArr = s.split(",");
			
			/*
			 * 创建文件
			 */
			JsonUtil.createJsonFile(strArr);
			
			XMLUtil.createXMLFile(strArr);
			
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
