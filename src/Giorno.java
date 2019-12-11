import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface Giorno extends Remote {

    public boolean setIntervento(int nInter, int nSessione,  String nome)throws RemoteException;

    public Vector<Sessione> getSessione()throws RemoteException;



}
