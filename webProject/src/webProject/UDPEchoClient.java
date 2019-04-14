package webProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient{
	
	// SERVERPORT 는 server단에 있는 port를 따라가고
	// 생성자 안에 들어가는 port는 client의 개인 port 지정.
	// client 끼리 port가 같으면 접속 불가
    private String str;
    private BufferedReader file;
    private static int SERVERPORT=4444;
    public UDPEchoClient(String ip,int port){
        try{     
            InetAddress ia = InetAddress.getByName(ip);
            DatagramSocket ds = new DatagramSocket(port);
            System.out.print("message : ");
            file = new BufferedReader(new InputStreamReader(System.in)); 
            str = file.readLine();   
            byte buffer[] = str.getBytes();            
            DatagramPacket dp = new DatagramPacket(
                    buffer,buffer.length,ia,SERVERPORT);
            ds.send(dp);
            buffer = new byte[512];
            dp = new DatagramPacket(buffer,buffer.length);
            ds.receive(dp);
            System.out.println("server ip : "+dp.getAddress() + " , server port : "+dp.getPort());
            System.out.println("수신된 데이터 : "+ new String(dp.getData()).trim());
        }catch(IOException ioe){
            ioe.printStackTrace();          
        }
    }
    public static void main(String[] args){
        new UDPEchoClient("localhost",5555);        
    }
};