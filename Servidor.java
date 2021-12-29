import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;

public class Servidor extends UnicastRemoteObject implements IExemplo {
	private int contador;

	public Servidor() throws RemoteException { 
		super();
		contador = 0;
	} 

	public void modifica(int n) {
		contador += n;
		System.out.println("Valor da alteração: " + n );
		
	} 

	public int valor() {
		return contador;
	} 

	public static void main(String[] args) {
		try {
			Servidor server = new Servidor();
			String endereco = "//localhost/Contador";
			System.out.println("Registering " + endereco + "...");
			Naming.rebind(endereco, server);
			System.out.println("Registrado!");
		} catch (RemoteException e) {
			System.err.println("Erro durante o registro do objeto! " + e);
			e.printStackTrace();
			System.exit(1); 
		} catch (MalformedURLException e) {
			System.err.println("URL invalida! " + e);
			e.printStackTrace();
			System.exit(2);
		} 

	} 
}
