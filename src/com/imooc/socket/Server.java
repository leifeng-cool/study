package com.imooc.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			Socket socket = null;
			//1.创建ServerSocket对象，绑定监听端口
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.通过accept()方法监听客户端请求
			System.out.println("***服务器即将启动，等待客户端连接***");
			
			//3.建立连接后，通过输入流读取客户端发送的请求信息
			while(true){
				socket = serverSocket.accept();
				//创建一个新的线程
				ServerThread sThread = new ServerThread(socket);
				//启动线程
				sThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
