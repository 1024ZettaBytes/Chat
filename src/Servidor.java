
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo Ramírez
 */
public class Servidor {
    public static void main(String[] args){
     MainChat chat = new MainChat();
     chat.setVisible(true);
     
     Persona persona = null;
        try {
            ServerSocket serv = new ServerSocket(1234);
            while(true){
                persona = new Persona(serv.accept());
              
                Thread hiloSocket = new Thread(new Runnable() {
            @Override
public void run(){
         DataInputStream bufferDeEntrada = null;
    DataOutputStream bufferDeSalida = null;
        String mensajeCliente = null;
        
        //Flush
         try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
             System.out.println("Error en la apertura de flujos");
        }
         
         
          try {
            do {
                mensajeCliente = (String) bufferDeEntrada.readUTF();
                System.out.println(this.persona.getUsername() + mensajeCliente);
                System.out.print("\n[Usted] => ");
            } while (!mensajeCliente.equals("SALIR"));
        } catch (IOException e) {
             try {
                 bufferDeEntrada.close();
                 bufferDeSalida.close();
            socket.close();
             } catch (IOException ex) {
                 Logger.getLogger(HiloSocket.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
    }
        });
        hiloSocket.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
