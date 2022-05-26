package Servidor;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


 public class Servidor {
	
	  public static void main(String[] args) {
        try {
			ServerSocket Servidor = new ServerSocket(4500);
			Socket clienteNuevo = Servidor.accept();
			ObjectInputStream entrada = new ObjectInputStream(clienteNuevo.getInputStream());
			System.out.println("Objeto llego");
			System.out.println("mandando otro mensaje al cliente");
			try {
				String mensaje = (String) entrada.readObject();
				System.out.println("Mensaje: "+mensaje);
				ObjectOutputStream resp = new ObjectOutputStream(clienteNuevo.getOutputStream());
				resp.writeObject("Hola cliente");
				System.out.println("Mensaje Enviado");
				clienteNuevo.close();
				Servidor.close();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
         

	    	
	    	
	    }
	}