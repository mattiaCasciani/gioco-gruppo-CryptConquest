package com.company;
import java.lang.Math;
import java.util.Arrays;

public class Campo <T>{
    private T [][] field;
    private boolean[][] full;
    private boolean isBoss;
    private int xexit=7;
    private int xprot=0;
    private int yexit=11;
    private int yprot=0;
    private int[] boss;

    /**
     * Costruttore della classe Campo
     * @param field
     * @param isBoss
     */
    public Campo(T[][] field, boolean isBoss){
        this.field = field.clone();
        this.isBoss=isBoss;
    }

    /**
     * Costruttore della classe campo al cui interno viene chiamato il metodo per caricare il campo
     */
    public Campo(){
        try {
            load();
            isBoss=false;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo utilizzato per il caricamento del campo,
     * chiama il metodo add per aggiungere i personaggi e i plus all'interno del campo
     * @throws Exception
     */
    private void load() throws Exception{
        field = (T[][]) new Object[12][12]; //crea un campo 12 x 12
        full = new boolean[12][12]; // istanzia una matrice booleana della stessa grandezza del campo
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) { //fase in cui si impostano tutte le celle del campo a " "
                field[i][j]= (T) " "; //fase in cui si impostano tutte le celle del campo a " "
                full[i][j]=false; //fase in cui si impostano tutte le celle del campo booleano a false (indica che è vuoto)
            }
        }
        full[yexit][xexit]=true; //imposta a true la cella in cui è presente l'uscita
        full[yprot][xprot]=true; // imposta a true la cella in cui è presente il protagonista

        /*nelle sette righe seguenti vengono istanziati il protagonista, il plus e i vari mostri presenti nella cripta */

        Plus pl[] = {new Plus(15.0, 1), new Plus(20.0, 2), new Plus(10.0, 3)};
        Protagonista prot= new Protagonista(30.00, 50.00, 30.00, "protagonista");
        Falciatore mietitore = new Falciatore(8, 99999999.9, 99999999.9, 99999999.9, "mietitore");
        Mostro nonMorto = new Mostro(20.0, 30.0, 40.0, "non morto");
        NonMortoStregato nonMortoStregato = new NonMortoStregato(2, 20.0, 30.0, 40.0, "non morto stregato");
        Stregone streg = new Stregone(3, 22.0, 30.0, 45.0, "stregone");
        Mostro guardianoDellaCripta = new Mostro(100.0, 70.0, 200.0, "guardiano della cripta");
        field[yprot][xprot]=(T)prot; //viene aggiunto il protagonista alle coordinate yprot xprot

        /* tramite il metodo add vengono aggiunti i personaggi e i plus in coordinate casuali*/

        add((T)"░", 8);
        add((T)mietitore, 3);
        add((T)pl[1], 6);
        add((T)pl[0], 6);
        add((T)pl[2], 6);
        add((T)nonMorto, 22);
        add((T)nonMortoStregato, 9);
        add((T)streg, 12);
        add((T)guardianoDellaCripta, 8);
    }

    /**
     * metodo utilizzato per riempire il campo
     * @param ogg
     * @param n
     * @return
     */
    private int[] add(T ogg, int n){
        int xCas=xexit;
        int yCas=yexit;
        //System.out.println("exit y: " + yexit + " x: " + xexit);
        for (int i =0; i< n; i++){
            while (occupato(yCas, xCas)){
                xCas= ((int) (Math.random()*12)); //viene generato un numero casuale da 0 a 11
                yCas= ((int) (Math.random()*12));
                //System.out.println("creo nuove posizioni");
            }
            field[yCas][xCas]=ogg; //viene inserito l'oggetto passato da parametro nel campo alle coordinate precedentemente calcolate

            //System.out.println(field[yCas][xCas].toString() + " x: " + xCas + " y: " + yCas);
            full[yCas][xCas]=true; // viene impostata a true la cella della matrice booleana con le
                                   // medesime coordinate per indicare che la casella è piena
        }
        return null;
    }

    /**
     * metodo utilizzato per il cambiamento di posizione del protagonista
     * @param y
     * @param x
     */
    public void cambiaPos(int y, int x){
        field[y][x]=field[yprot][xprot];
        full[y][x]=true;
        field[yprot][xprot]=(T)" ";
        full[yprot][xprot]=false;
        yprot=y;
        xprot=x;
    }

    /**
     * metodo che ritorna true se la cella è occupata
     * @param y
     * @param x
     * @return
     */
    private boolean occupato(int y, int x){
        return full[y][x] == true;
    }

    /**
     * metodo get dell'attributo isBoss
     * @return true o false a seconda se è il boss o meno
     */
    public boolean getIsBoss(){return isBoss;}

    /**
     * metodo get dell'attributo xprot
     * @return xprot
     */
    public int getXprot(){return xprot;}

    /**
     * metodo get dell'attributo yprot
     * @return yprot
     */
    public int getYprot(){return yprot;}

    /**
     * metodo set dell'attributo field
     * @param field
     */
    public void setField(T[][] field) {this.field = field;}

    /**
     * metodo set dell'attributo isBoss
     * @param boss
     */
    public void setIsBoss(boolean boss) {isBoss = boss;}

    /**
     * metodo che ritorna l'indirizzo di memori dell'attributo field
     * @return field
     */
    public T[][] getCampo(){return field;}
    @Override

    /**
     * metodo utilizzato per stampare il campo
     */
    public String toString() {
        String out=" ╔═══════════════════════════════════════════════════╗\n";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (j == 0)
                    out += " ║ ";
                if (i==yexit && j==xexit)
                    out += "\uD83D\uDEAA\t";
                else
                    out+=field[i][j]+" \t";

            }
            out +=" ║\n";
            if (i==11)
                out+=" ╚═══════════════════════════════════════════════════╝";
        }

        out+="\n\n\n ╔═══════════════════════════════════════════════════╗\n";

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (j == 0)
                    out += " ║ ";
                if (full[i][j] == true)
                    out+="T\t";
                else
                    out+="F\t";

            }
            out +=" ║\n";
            if (i==11)
                out+=" ╚═══════════════════════════════════════════════════╝";
        }
        return out;
    }
}
