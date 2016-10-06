package com.imooc.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			Socket socket = null;
			//1.����ServerSocket���󣬰󶨼����˿�
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.ͨ��accept()���������ͻ�������
			System.out.println("***�����������������ȴ��ͻ�������***");
			
			//3.�������Ӻ�ͨ����������ȡ�ͻ��˷��͵�������Ϣ
			while(true){
				socket = serverSocket.accept();
				//����һ���µ��߳�
				ServerThread sThread = new ServerThread(socket);
				//�����߳�
				sThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
