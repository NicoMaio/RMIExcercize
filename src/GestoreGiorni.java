/**
 * @author Nicolò Maio
 *
 * */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestoreGiorni extends Remote {

    public String SERVICE_NAME = "Gestore";
    public Giorno[] getAllDays() throws RemoteException;


    public Giorno getOneDay(int nday) throws RemoteException;


    public boolean setIntervento(int nday,int nsessione,int nIntervents,String name)throws RemoteException;
}
