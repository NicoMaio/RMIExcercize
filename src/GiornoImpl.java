/**
 * @author Nicolò Maio
 *
 * */

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

    // occupa intervento in sessione nSessione e intervento nInter.
    public boolean setIntervento(int nInter, int nSessione,  String nome)throws RemoteException{

        return sessioni.elementAt(nSessione).setIntervento(nInter,nome);

    }

    // restituisce elenco sessione
    public Vector<Sessione> getSessione()throws RemoteException{

        return sessioni;
    }
}
