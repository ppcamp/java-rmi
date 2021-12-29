import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.Random;

public class Cliente
{
	public static void main(String[] args) {
		int val, n;
		IExemplo server = null;
		Random rand = new Random();

		try {
			String endereco = "//localhost/Contador";
			System.out.println("Localizando o objeto " + endereco);
			server = (IExemplo) Naming.lookup(endereco);			
			System.out.println("Objeto encontrado!");

			n = rand.nextInt() % 100;
			val = server.valor();
			server.modifica(n);			
			System.out.println(val + " + " + n + " = " + server.valor());
			
			n = rand.nextInt() % 100;
			val = server.valor();
			server.modifica(n);
			System.out.println(val + " + " + n + " = " + server.valor());

		} catch (NotBoundException e) {
			System.err.println("Problema ao locarlizar o objeto remoto " + e);
			e.printStackTrace();
			System.exit(1);
		} catch (RemoteException e) {
			System.err.println("Falha durante a chamada do procedimento remoto! " + e);
			e.printStackTrace();
			System.exit(2);
		} catch (MalformedURLException e) {
			System.err.println("URL invalida!\n" + e);
			e.printStackTrace();
			System.exit(3);
		} 
 
	} 
} 
