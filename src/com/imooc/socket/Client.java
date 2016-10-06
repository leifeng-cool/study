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
 * �ͻ���
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
//			1.����Socket����ָ����Ҫ���ӵķ������ĵ�ַ�ͱ��
			Socket socket = new Socket("127.0.0.1", 8888);
//			2.�������Ӻ�ͨ������������������������Ϣ
			OutputStream oStream = socket.getOutputStream();//�ֽ������
			//���ֽ������ת���ɴ�ӡ��
			PrintWriter writer = new PrintWriter(oStream);
			writer.write("�û��� : admin ; ����  : admin");
			writer.flush();
			//�ر������
			socket.shutdownOutput();
//			3.��ȡ��������Ӧ��Ϣ
			InputStream iStream = socket.getInputStream();//�ֽ�������
			BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
			String info = bReader.readLine();
			while(info!=null){
				System.out.println(info);
				info = bReader.readLine();
			}
			
//			4.�ر������Դ
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
