import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IExemplo extends Remote
{
	void modifica(int n) throws RemoteException;
	int valor() throws RemoteException;
} 
