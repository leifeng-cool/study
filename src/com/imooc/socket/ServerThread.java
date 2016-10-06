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
	//�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	public void run(){
		InputStream iStream = null;
		InputStreamReader iStreamReader = null;
		BufferedReader bReader = null;
		OutputStream oStream = null;
		PrintWriter pWriter = null;
		try {
			
			iStream = socket.getInputStream();
			//���ֽ�������ת��Ϊ�ַ�������
			iStreamReader = new InputStreamReader(iStream);
			//Ϊ��������ӻ���
			bReader = new BufferedReader(iStreamReader);

			String info = null;
			info = bReader.readLine();
			//ѭ����ȡ�ͻ�����Ϣ
			while(info!=null){
				System.out.println(info);
				info = bReader.readLine();
			}
			socket.shutdownInput();//�ر�������
//			��ȡ���������Ӧ�ͻ��˵�����
			//���ֽ���ת���ɴ�ӡ��
			oStream = socket.getOutputStream();
			pWriter = new PrintWriter(oStream);
			pWriter.write("welcome��");
			pWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
//			�ر���Դ
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
