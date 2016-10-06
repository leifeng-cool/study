package com.imooc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket =null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	//线程执行的操作，响应客户端的请求
	public void run(){
		InputStream iStream = null;
		InputStreamReader iStreamReader = null;
		BufferedReader bReader = null;
		OutputStream oStream = null;
		PrintWriter pWriter = null;
		try {
			
			iStream = socket.getInputStream();
			//将字节输入流转换为字符输入流
			iStreamReader = new InputStreamReader(iStream);
			//为输入流添加缓冲
			bReader = new BufferedReader(iStreamReader);

			String info = null;
			info = bReader.readLine();
			//循环读取客户端信息
			while(info!=null){
				System.out.println(info);
				info = bReader.readLine();
			}
			socket.shutdownInput();//关闭输入流
//			获取输出流，响应客户端的请求
			//将字节流转换成打印流
			oStream = socket.getOutputStream();
			pWriter = new PrintWriter(oStream);
			pWriter.write("welcome！");
			pWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
//			关闭资源
			try {
				pWriter.close();
				oStream.close();
				bReader.close();
				iStreamReader.close();
				iStream.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
