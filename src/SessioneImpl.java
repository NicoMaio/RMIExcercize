import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class SessioneImpl extends UnicastRemoteObject implements Sessione {

    private Vector<Intervento> elencoInterventi;

    public SessioneImpl(int nInterventi)throws RemoteException {

        elencoInterventi = new Vector<>(nInterventi);
        for(int i =0;i<5;i++){
            elencoInterventi.add(new InterventoImpl("Free Space"));

        }

    }

    public Intervento getIntervento(int nIntervento) throws RemoteException {
        return elencoInterventi.get(nIntervento);
    }



    public boolean setIntervento(int nIntervento, String nome)throws RemoteException {
        if(elencoInterventi.get(nIntervento).getIntervento().equals("Free Space")){
            elencoInterventi.set(nIntervento, new InterventoImpl(nome));
            return true;

        }
        return false;
    }
}
