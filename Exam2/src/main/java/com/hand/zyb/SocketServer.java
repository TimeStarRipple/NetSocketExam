package com.hand.zyb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 
 * @author zyb
 * @version 1.0
 * @date 2016年8月1日 下午6:52:30
 */
public class SocketServer extends Thread
{
	@Override
	public void run()
	{
		System.out.println("服务器开启成功");
		try
		{
			ServerSocket serverSocket = new ServerSocket(9999);
			
			Socket socket = serverSocket.accept();

			//当有客户端连接上来的时候，执行下面代码，传输文件
			FileInputStream fis = new FileInputStream("target.pdf");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
			
			byte[] bs = new byte[1000];
			while ((bis.read(bs)) != -1)
			{
				bos.write(bs);
				bos.flush();
			}
			bos.close();
			bis.close();
			fis.close();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
