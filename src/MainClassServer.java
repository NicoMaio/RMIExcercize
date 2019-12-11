import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainClassServer {

    public static void main(String args[])
    {

        try {


             GestoreGiorni giorni = new GestoreGiorniImpl(3,12,5);

             LocateRegistry.createRegistry(9999);

             Registry r = LocateRegistry.getRegistry(9999);

             r.rebind(GestoreGiorni.SERVICE_NAME,giorni);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Congress bound in registry");
        System.out.println("Ready to listen requests ...");
    }
}
