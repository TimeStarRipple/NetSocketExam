package com.hand.zyb;

/**
 * (8 分)实现一个 Socket 服务器端和一个 Socket 客户端,先启动服
 * 务器端,当客户端连接上来后,将第一题中得到的 target.pdf 通过
 * Stream 发送给客户端,客户端接收并保存为 pdf 文件,并保证 pdf
 * 文件能被正常打开.
 */
public class App 
{
    public static void main( String[] args )
    {
        new SocketServer().start();
    }
}
