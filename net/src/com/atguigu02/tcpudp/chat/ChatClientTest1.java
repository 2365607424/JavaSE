package com.atguigu02.tcpudp.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 案例：聊天室的实现 （客户端）
 *
 * @author 尚硅谷-宋红康
 * @create 16:42
 */
public class ChatClientTest1 {
	public static void main(String[] args)throws Exception {
		//1、连接服务器
		Socket socket = new Socket("127.0.0.1",8989);
		
		//2、开启两个线程
		//(1)一个线程负责看别人聊，即接收服务器转发的消息
		Receive1 receive = new Receive1(socket);
		receive.start();
		
		//(2)一个线程负责发送自己的话
		Send1 send = new Send1(socket);
		send.start();
		
		send.join();//等我发送线程结束了，才结束整个程序
		
		socket.close();
	}
}

class Send1 extends Thread{
	private Socket socket;
	
	public Send1(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			Scanner input = new Scanner(System.in);

			OutputStream outputStream = socket.getOutputStream();
			//按行打印
			PrintStream ps = new PrintStream(outputStream);
			
			//从键盘不断的输入自己的话，给服务器发送，由服务器给其他人转发
			while(true){
				System.out.print("自己的话：");
				String str = input.nextLine(); //阻塞式的方法
				if("bye".equals(str)){
					break;
				}
				ps.println(str);
			}
			
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

class Receive1 extends Thread{
	private Socket socket;
	
	public Receive1(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run(){
		try {
			InputStream inputStream = socket.getInputStream();
			Scanner input = new Scanner(inputStream);
			
			while(input.hasNextLine()){
				String line = input.nextLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}