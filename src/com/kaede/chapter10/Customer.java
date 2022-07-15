package com.kaede.chapter10;

/**
 * 测试对象实例化的过程
 * 
 * 给对象的属性赋值的操作：
 * （1）属性的默认初始化 （2）显示初始化 （3）代码块中初始化 （4）构造器中初始化
 */

 @SuppressWarnings("all")
public class Customer {
    private int id = 1001;
    private String name;
    Account acct;
    {
        name = "匿名客户";
    }

    public Customer() {
        acct = new Account();
    }
}

class Account {

}
