package com.sdm.demo;
/**
 * jdbc练习1
 * @author shun_
 * 准备jdk1.8+eclipse环境  java se技术平台
 * 创建Java项目 src文件
 */
public class Demo1 {
//alt+?
	//jar包拖进src,右键bulid path
	//注册驱动
	//建立连接
	//执行sql语句
	//关闭资源
	public static void main(String[] args) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

}
