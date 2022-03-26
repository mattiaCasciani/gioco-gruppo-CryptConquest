
package gioco;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        /*System.out.println("\n-------------- Parametri dei personaggi -----------------\n");
        Mostro m = new Mostro();
        m.setAttacco(130.0);
        m.setDifesa(30.0);
        m.setVita(10.0);
        m.setTipo("Normale");
        System.out.println(m.toString());

        Protagonista p = new Protagonista();
        p.setAttacco(100.0);
        p.setDifesa(40.0);
        p.setVita(100.0);
        p.setNome("Polimeni");

        System.out.println(p.toString());

        System.out.println("\n---------------------------------------------------------\n");
        System.out.println("Il protagonista ha vinto: "+p.attacca(m));
        System.out.println("\n---Parametri dei personaggi dopo lo scontro -------\n");
        System.out.println(p.toString());
        System.out.println(m.toString());
        System.out.println("\n---------------------------------------------------------\n");
            Partita p = new Partita();
            Scanner scan = new Scanner(System.in);
            Character key='a';
            while (key == 'w' || key == 'a' || key == 's' || key == 'd'){
                System.out.println(p.toString()+"\nscegli cosa premere: ");
                key = scan.nextLine().charAt(0);
                p.event(key);
            }*/
        Campo c = new Campo();
        System.out.println(c.toString());
        c.campiaPosizione(1, 0);
        System.out.println(c.toString());
        c.campiaPosizione(2, 0);
        System.out.println(c.toString());
        /*c.campiaPosizione(3, 0);
        System.out.println(c.toString());
        c.campiaPosizione(3, 1);
        System.out.println(c.toString());*/
    }
}

