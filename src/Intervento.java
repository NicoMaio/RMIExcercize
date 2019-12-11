import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Intervento extends Remote{


    public String getIntervento()throws RemoteException;
}
