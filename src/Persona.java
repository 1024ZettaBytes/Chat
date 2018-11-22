
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo Ramírez
 */
public class Persona{
    String username;
    Socket socket;
    public Persona(Socket socket){
        
        this.socket = socket;
    }
    public void setUsername(String userName){
        this.username = userName;
    }
    public String getUsername(){
        return username;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
