package com.imooc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
//			1.创建Socket对象，指明需要连接的服务器的地址和编号
			Socket socket = new Socket("127.0.0.1", 8888);
//			2.建立连接后，通过输出流向服务器发送请求信息
			OutputStream oStream = socket.getOutputStream();//字节输出流
			//将字节输出流转换成打印流
			PrintWriter writer = new PrintWriter(oStream);
			writer.write("用户名 : admin ; 密码  : admin");
			writer.flush();
			//关闭输出流
			socket.shutdownOutput();
//			3.获取服务器响应信息
			InputStream iStream = socket.getInputStream();//字节输入流
			BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
			String info = bReader.readLine();
			while(info!=null){
				System.out.println(info);
				info = bReader.readLine();
			}
			
//			4.关闭相关资源
			bReader.close();
			iStream.close();
			writer.close();
			oStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
