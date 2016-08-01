package com.hand.zyb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * (8 分 ) 使用程序从网上下载 pdf, 网址为
 * http://files.saas.hand-china.com/java/target.pdf,保存在本地,
 * 编程时使用带缓冲的读写,将需要保证保存后的 pdf 文件能正常
 * 打开.
 */
public class App 
{
    public static void main( String[] args )
    {
        try
		{
        	URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
        	URLConnection uc = url.openConnection();
			InputStream is = uc.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			FileOutputStream fos = new FileOutputStream("copy_target.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] bs = new byte[1024];
			int length = 0;
			while((length = bis.read(bs)) != -1)
			{
				bos.write(bs, 0, length);
			}
			
			bos.flush();
			bos.close();
			fos.close();
			bis.close();
			is.close();
			
			System.out.println("下载成功！");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
}
