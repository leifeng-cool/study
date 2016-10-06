package com.imooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * �ͻ���
 * @author Administrator
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * �ͻ��������˷�����Ϣ
		 */
//		1.���巢����Ϣ��ָ����������ַ���˿ںţ�������Ϣ
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "�û�����admin;���룺admin".getBytes();
//		2.����DatagramPacket��������Ҫ���͵���Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
//		3.����DatagramSocket
		DatagramSocket socket = new DatagramSocket();
//		4.��������
		socket.send(packet);
		
		/**
		 * �ͻ��˽��շ������Ӧ��Ϣ
		 */
//		1.�������ݱ������ڽ��շ���������Ӧ����
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
//		2.���շ������Ӧ����
		socket.receive(packet2);
//		3.��ȡ����
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("����ˣ�"+reply);
//		4.�ر���Դ
		socket.close();
	}

}
