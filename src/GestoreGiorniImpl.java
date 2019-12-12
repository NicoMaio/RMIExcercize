/**
 * @author Nicolò Maio
 *
 * */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class GestoreGiorniImpl extends UnicastRemoteObject implements GestoreGiorni {

    private Vector<Giorno> days;
    private int ndays;

    public GestoreGiorniImpl(int ndays,int nSessioni,int nIntervents) throws RemoteException{

        this.ndays = ndays;
        days = new Vector<>(ndays);

        for(int i=0;i<ndays;i++){
            days.add(new GiornoImpl(nSessioni));
        }

    }

    // restituisco array di Giorno con elenco degli interventi nei 3 giorni
    public Giorno[] getAllDays() throws RemoteException{

        Giorno[] arrayGiorni = new Giorno[ndays];

        for(int i =0;i<ndays;i++){

            arrayGiorni[i] = days.elementAt(i);
        }
        return arrayGiorni;
    }

    // restituisco solo un giorno dei 3
    public Giorno getOneDay(int nday) throws RemoteException{

        return days.elementAt(nday);
    }


    // setta intervento in giorno nday, sessione nsessione, intervento nIntervents con nome name
    public boolean setIntervento(int nday,int nsessione,int nIntervents,String name)throws RemoteException{

        return days.elementAt(nday).setIntervento(nIntervents, nsessione, name);

    }


}
