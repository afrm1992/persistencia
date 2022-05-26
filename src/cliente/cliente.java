package cliente;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class cliente {
	public static void main(String[] args) {
		try {
			Socket cliente = new Socket("localhost", 4500);
			ObjectOutputStream mensaje = new ObjectOutputStream(cliente.getOutputStream());
			mensaje.writeObject("Hola servidor");
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			String mensaje2 = null;
			try {
				mensaje2 = (String)entrada.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Mensaje desde el servidor"+mensaje2);
			cliente.close();
			System.out.println("Conexion cerrada");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
