/**
 * @author Nicolò Maio
 *
 * */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class SessioneImpl extends UnicastRemoteObject implements Sessione {

    private Vector<Intervento> elencoInterventi;

    public SessioneImpl(int nInterventi)throws RemoteException {

        elencoInterventi = new Vector<>(nInterventi);

        for(int i =0;i<5;i++) {
            // setto tutti gli interventi di default con "Free Space"
            elencoInterventi.add(new InterventoImpl("Free Space"));

        }

    }

    // restituisce intervento con indice nIntervento
    public Intervento getIntervento(int nIntervento) throws RemoteException {

        return elencoInterventi.get(nIntervento);
    }

    // restituisce true se riesce a settare correttamente intervento, altrimenti false
    public boolean setIntervento(int nIntervento, String nome)throws RemoteException {

        if(elencoInterventi.get(nIntervento).getIntervento().equals("Free Space")){

            elencoInterventi.set(nIntervento, new InterventoImpl(nome));
            return true;

        }
        return false;
    }
}
