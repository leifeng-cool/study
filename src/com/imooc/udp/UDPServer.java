package com.imooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * �����
 * @author Administrator
 *
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		/**
		 * ����˽��տͻ�����Ϣ
		 */
		// TODO Auto-generated method stub
//		1.����DatagramSocket,ָ���˿ں�
		DatagramSocket socket = new DatagramSocket(8800);
//		2.����DatagramPacket
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
//		3.ָ���ͻ��˷��͵�������Ϣ
		socket.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ��һֱ��������
//		4.��ȡ����
		String info = new String(data, 0, packet.getLength());
		System.out.println("�ͻ��ˣ�"+info);
		
		/**
		 * �������Ӧ�ͻ�������
		 */
//		1.����ͻ��˵�ַ���˿ںţ�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ ".getBytes();
//		2.�������ݱ���������Ӧ��������Ϣ
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
//		3.��Ӧ�ͻ���
		socket.send(packet2);
//		4.�ر���Դ
		socket.close();
	}

}
