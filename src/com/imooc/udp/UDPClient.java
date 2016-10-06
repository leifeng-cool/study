package com.imooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端
 * @author Administrator
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * 客户端向服务端发送信息
		 */
//		1.定义发送信息，指定服务器地址，端口号，发送信息
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "用户名：admin;密码：admin".getBytes();
//		2.创建DatagramPacket，包含将要发送的信息
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
//		3.创建DatagramSocket
		DatagramSocket socket = new DatagramSocket();
//		4.发送数据
		socket.send(packet);
		
		/**
		 * 客户端接收服务端响应信息
		 */
//		1.创建数据报，用于接收服务器的响应数据
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
//		2.接收服务端响应数据
		socket.receive(packet2);
//		3.读取数据
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("服务端："+reply);
//		4.关闭资源
		socket.close();
	}

}
