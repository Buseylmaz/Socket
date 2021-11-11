package socket;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket=null;
        ServerSocket serverSocket=null;
        InputStreamReader inputStreamReader=null;
        OutputStreamWriter outputStreamWriter=null;
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        
        serverSocket=new ServerSocket(1234);
        while (true)
        {   
            try
            {
                socket=serverSocket.accept();
                
                inputStreamReader=new InputStreamReader(socket.getInputStream());
                outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
                
                bufferedReader=new BufferedReader(inputStreamReader);
                bufferedWriter=new BufferedWriter(outputStreamWriter);
                
                while (true) 
                {                    
                    String msgFromClient=bufferedReader.readLine();
                    
                    System.out.println("Client:" + msgFromClient);
                    bufferedWriter.write("Alınan mesaj");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    
                    if (msgFromClient.equalsIgnoreCase("BYE"))
                        break;
                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
                
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
