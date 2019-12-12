/**
 * @author Nicolò Maio
 *
 * */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterventoImpl extends UnicastRemoteObject implements Intervento {

    private String nomeInt;

    public InterventoImpl(String nome)throws RemoteException {

        nomeInt = nome;
    }

    // setta nomeInt dell'intervento con nome
    public void setIntervento(String nome)throws RemoteException {

        nomeInt = nome;
    }

    // restituisce nomeInt
    public String getIntervento()throws RemoteException {

        return nomeInt;
    }

}
