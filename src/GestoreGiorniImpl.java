import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class GestoreGiorniImpl extends UnicastRemoteObject implements GestoreGiorni {

    private Vector<Giorno> days;
    private int nSessioni;
    private int ndays;
    private int nIntervents;

    public GestoreGiorniImpl(int ndays,int nSessioni,int nIntervents) throws RemoteException{

        this.ndays = ndays;
        setGestoreGiorni(ndays,nSessioni,nIntervents);
        for(int i=0;i<ndays;i++){
            days.add(new GiornoImpl(nSessioni));
        }

    }

    public Giorno[] getAllDays() throws RemoteException{
        Giorno[] arrayGiorni = new Giorno[ndays];
        for(int i =0;i<ndays;i++){
            arrayGiorni[i] = days.elementAt(i);
        }
        return arrayGiorni;
    }

    public Giorno getOneDay(int nday) throws RemoteException{
        return days.elementAt(nday);
    }

    public void setGestoreGiorni(int ndays,int nsessioni,int nintervents)throws RemoteException{
        days = new Vector<>(ndays);

    }

    public boolean setIntervento(int nday,int nsessione,int nIntervents,String name)throws RemoteException{

        return days.elementAt(nday).setIntervento(nIntervents, nsessione, name);
        // TODO va modificata.

    }


}
