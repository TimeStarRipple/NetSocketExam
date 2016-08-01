package com.hand.zyb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* 客户端
* @author zyb
* @version 1.0
* @date 2016年8月1日 下午6:52:53
*/
public class SocketClient extends Thread
{
	public static void main(String[] args)
	{
		new SocketClient().start();
	}
	
	@Override
	public void run()
	{
		try
		{
			Socket socket = new Socket("127.0.0.1", 9999);
			
			System.out.println("你已经连接到了服务器了");
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			
			FileOutputStream fos = new FileOutputStream("copy_target.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] bs = new byte[1000];
			while ((bis.read(bs)) != -1)
			{
				 bos.write(bs);
				 bos.flush();
			}
			
			bos.close();
			fos.close();
			bis.close();
			
			System.out.println("下载成功！");
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
