import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterventoImpl extends UnicastRemoteObject implements Intervento {

    private String nomeInt;

    public InterventoImpl(String nome)throws RemoteException {

        nomeInt = nome;
    }

    public void setIntervento(String nome)throws RemoteException {

        nomeInt = nome;
    }

    public String getIntervento()throws RemoteException {

        return nomeInt;
    }

}
