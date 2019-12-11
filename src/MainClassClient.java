import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.Vector;

public class MainClassClient {

    public static void main(String args[]) throws Exception {
        Registry reg = LocateRegistry.getRegistry(9999);

        GestoreGiorni giorniCongresso = (GestoreGiorni) reg.lookup(GestoreGiorni.SERVICE_NAME);


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        boolean term_var = true;
        while(term_var){
            System.out.println("Select Option: ");
            System.out.println("1. Show all days programs");
            System.out.println("2. Show one day program");
            System.out.println("3. Exit");

            int request = Integer.parseInt(input.readLine());

            switch (request) {

                case 1: {
                    printAllDays(giorniCongresso.getAllDays());

                    System.out.println("Choose next Option: ");
                    System.out.println("1. Go back to last menu");
                    System.out.println("2. Occupy an intervent");

                    request = Integer.parseInt(input.readLine());

                    if(request == 1) {

                        continue;

                    } else {

                        try {

                            occupyIntervent(giorniCongresso,input);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }break;

                case 2: {

                    System.out.println("Insert number of day");

                    int day = Integer.parseInt(input.readLine());

                    while(day < 0 || day >=3) {
                        System.out.println("wrong day selected, try again");
                        System.out.println("The days avalaible are 0,1,2");
                        day = Integer.parseInt(input.readLine());
                    }

                    try {

                        printOneDay(giorniCongresso.getOneDay(day), day);

                    } catch (RemoteException e) {

                        e.printStackTrace();
                    }

                    System.out.println("1. Occupy Intervent");
                    System.out.println("2. Go back to principle menu");

                    request = Integer.parseInt(input.readLine());

                    if(request == 1) {

                            occupyInterventInChoosedDay(giorniCongresso,input,day);

                    } else {

                        continue;
                    }
                } break;

                case 3: {

                    term_var = false;

                    System.out.println("GG EZ, BB");
                }
            }

        }





    }

    public static void printOneDay(Giorno giorni,int choosen) throws RemoteException {

        System.out.println("Giorno " + choosen);
        Vector<Sessione> sessione = giorni.getSessione();
        for (int i = 0; i < sessione.size(); i++) {
            Sessione sessione1 = sessione.elementAt(i);
            System.out.print("Sessione n " +  i+": ");
            for (int j = 0; j < 5; j++) {
                Intervento temp = sessione1.getIntervento(j);
                System.out.print("Intervento n " + j +": " + temp.getIntervento()+" | ");
            }
            System.out.println();
        }
    }

    public static void printAllDays(Giorno[] giorni)throws RemoteException {
        for (int k = 0; k < giorni.length; k++) {
            System.out.println("Giorno " + k);
            Vector<Sessione> sessione = giorni[k].getSessione();
            for (int i = 0; i < sessione.size(); i++) {
                Sessione sessione1 = sessione.elementAt(i);
                System.out.print("Sessione n " +  i+": ");
                for (int j = 0; j < 5; j++) {
                    Intervento temp = sessione1.getIntervento(j);
                    System.out.print("Intervento n " + j +": " + temp.getIntervento()+" | ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static void occupyInterventInChoosedDay(GestoreGiorni giorniCongresso, BufferedReader input,int day)throws IOException,RemoteException {


        System.out.println("Insert the number of the session");

        int session = Integer.parseInt(input.readLine());

        System.out.println("Insert number of the intervent");

        int intervent = Integer.parseInt(input.readLine());

        System.out.println("Insert your Name");

        String name = input.readLine();

        boolean ok = giorniCongresso.setIntervento(day,session,intervent,name);

        if(ok) {

            System.out.println("Intervent booked up correctly");

        } else {

            System.out.println("Intervent choosed doesn't avalaible");

        }
    }

    public static void occupyIntervent(GestoreGiorni giorniCongresso, BufferedReader input)throws IOException,RemoteException {

        System.out.println("Insert the number of the day");

        int day = Integer.parseInt(input.readLine());

        System.out.println("Insert the number of the session");

        int session = Integer.parseInt(input.readLine());

        System.out.println("Insert number of the intervent");

        int intervent = Integer.parseInt(input.readLine());

        System.out.println("Insert your Name");

        String name = input.readLine();

        boolean ok = giorniCongresso.setIntervento(day,session,intervent,name);

        if(ok) {

            System.out.println("Intervent booked up correctly");

        } else {

            System.out.println("Intervent choosed doesn't avalaible");

        }
    }
}
