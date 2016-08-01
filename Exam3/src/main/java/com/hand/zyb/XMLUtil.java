package com.hand.zyb;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * XML工具类
 * 
 * @author zyb
 * @version 1.0
 * @date 2016年8月1日 下午7:51:29
 */
public class XMLUtil
{

	public static void createXMLFile(String[] strArr)
	{
		try
		{
			/*
			 * 固定代码，用于获取操作xml文件对象，并创建文件对象
			 */
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			/*
			 * 创建根结点，并设置属性
			 */
			Element root = document.createElement("xml");

			Element stock = document.createElement("stock");
			root.appendChild(stock);

			Element name = document.createElement("name");
			name.setTextContent(strArr[0]);
			stock.appendChild(name);

			Element open = document.createElement("open");
			open.setTextContent(strArr[1]);
			stock.appendChild(open);

			Element close = document.createElement("close");
			close.setTextContent(strArr[2]);
			stock.appendChild(close);

			Element current = document.createElement("current");
			current.setTextContent(strArr[3]);
			stock.appendChild(current);

			Element high = document.createElement("high");
			high.setTextContent(strArr[4]);
			stock.appendChild(high);

			Element low = document.createElement("low");
			low.setTextContent(strArr[5]);
			stock.appendChild(low);

			document.appendChild(root);

			/*
			 * 文档已经编写完毕，开始输出
			 */
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// 文件输出
			transformer.transform(new DOMSource(document),
					new StreamResult(new File("createxml.xml")));
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (TransformerConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (TransformerException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("xml文件创建成功");
		}
	}
}
