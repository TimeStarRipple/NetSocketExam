package com.hand.zyb;

/**
 * Sina 股票数据接口,以大秦铁路（股票代码：601006）为
 * 例，如果要获取它的最新行情，只需访问新浪的股票数据
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Get().start();
    }
}
