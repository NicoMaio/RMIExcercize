/**
 * @author Nicolò Maio
 *
 * */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sessione extends Remote{

    public Intervento getIntervento(int nIntervento)throws RemoteException;

    public boolean setIntervento(int nIntervento, String nome) throws RemoteException;

}
