import java.rmi.registry.*;
import java.util.Vector;

public class MainClassClient {

    public static void main(String args[]) throws Exception {
        Registry reg = LocateRegistry.getRegistry(9999);

        GestoreGiorni giorniCongresso = (GestoreGiorni) reg.lookup(GestoreGiorni.SERVICE_NAME);

        System.out.println(giorniCongresso);

        boolean ok = giorniCongresso.setIntervento(0,0,0,"Jonny");
        Giorno[] giorni = giorniCongresso.getAllDays();

        if(!ok) {


            for (int k = 0; k < giorni.length; k++) {
                System.out.println("Giorno " + k);
                Vector<Sessione> sessione = giorni[k].getSessione();
                for (int i = 0; i < sessione.size(); i++) {
                    Sessione sessione1 = sessione.elementAt(i);
                    System.out.println("Sessione n" + i);
                    for (int j = 0; j < 5; j++) {
                        Intervento temp = sessione1.getIntervento(j);
                        System.out.println("Intervento n" + j + temp.getIntervento());
                    }
                }
            }
        }


        // TODO va impostata interfaccia da mandare in loop con le varie richieste possibili.




    }
}
