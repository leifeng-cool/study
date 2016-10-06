package com.imooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务端
 * @author Administrator
 *
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		/**
		 * 服务端接收客户端信息
		 */
		// TODO Auto-generated method stub
//		1.创建DatagramSocket,指定端口号
		DatagramSocket socket = new DatagramSocket(8800);
//		2.创建DatagramPacket
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
//		3.指定客户端发送的数据信息
		socket.receive(packet);//此方法在接收到数据报之前会一直处于阻塞
//		4.读取数据
		String info = new String(data, 0, packet.getLength());
		System.out.println("客户端："+info);
		
		/**
		 * 服务端响应客户端请求
		 */
//		1.定义客户端地址，端口号，数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎 ".getBytes();
//		2.创建数据报，包含响应的数据信息
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
//		3.响应客户端
		socket.send(packet2);
//		4.关闭资源
		socket.close();
	}

}
