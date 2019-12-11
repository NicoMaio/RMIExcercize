import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class GiornoImpl extends UnicastRemoteObject implements Giorno {

    private Vector<Sessione> sessioni;


    public GiornoImpl(int nSessioni) throws RemoteException {

        sessioni = new Vector<>(nSessioni);

        for (int i =0;i<nSessioni;i++){
            sessioni.add(new SessioneImpl(5));
        }
    }

    public boolean setIntervento(int nInter, int nSessione,  String nome)throws RemoteException{
        return sessioni.elementAt(nSessione).setIntervento(nInter,nome);

    }

    public Vector<Sessione> getSessione()throws RemoteException{
        return sessioni;
    }
}
