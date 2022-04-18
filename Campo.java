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

    public Campo(T[][] field, boolean isBoss){
        this.field = field.clone();
        this.isBoss=isBoss;
    }

    public Campo(){
        try {
            load();
            isBoss=false;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getXexit() {
        return xexit;
    }

    public int getYexit() {
        return yexit;
    }

    private void load() throws Exception{
        field = (T[][]) new Object[12][12];
        full = new boolean[12][12];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j]= (T) " ";
                full[i][j]=false;
            }
        }
        full[yexit][xexit]=true;
        full[yprot][xprot]=true;
        Plus pl[] = {new Plus(15.0, 1), new Plus(20.0, 2), new Plus(10.0, 3)};
        Protagonista prot= new Protagonista(50.00, 50.00, 50.00, "protagonista");
        Falciatore mietitore = new Falciatore(8, 99999999.9, 99999999.9, 99999999.9, "mietitore");
        Mostro nonMorto = new Mostro(20.0, 30.0, 40.0, "non morto");
        NonMortoStregato nonMortoStregato = new NonMortoStregato(2, 20.0, 30.0, 40.0, "non morto stregato");
        Stregone streg = new Stregone(3, 22.0, 30.0, 45.0, "stregone");
        Mostro guardianoDellaCripta = new Mostro(100.0, 70.0, 200.0, "guardiano della cripta");
        field[yprot][xprot]=(T)prot;
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

    private int[] add(T ogg, int n){
        int xCas=xexit;
        int yCas=yexit;
        //System.out.println("exit y: " + yexit + " x: " + xexit);
        for (int i =0; i< n; i++){
            while (occupato(yCas, xCas)){
                xCas= ((int) (Math.random()*12));
                yCas= ((int) (Math.random()*12));
                //System.out.println("creo nuove posizioni");
            }
            field[yCas][xCas]=ogg;
            //System.out.println(field[yCas][xCas].toString() + " x: " + xCas + " y: " + yCas);
            full[yCas][xCas]=true;
        }
        return null;
    }

    public void cambiaPos(int y, int x){
        field[y][x]=field[yprot][xprot];
        full[y][x]=true;
        field[yprot][xprot]=(T)" ";
        full[yprot][xprot]=false;
        yprot=y;
        xprot=x;
    }

    private boolean occupato(int y, int x){
        if (full[y][x] == true){
            //System.out.println("il posto è occupato");
            return true;
        }
        else{
            //System.out.println("il posto è libero");
            return false;
        }
    }

    public boolean getIsBoss(){return isBoss;}

    public int getXprot(){return xprot;}
    public int getYprot(){return yprot;}
    public void setField(T[][] field) {this.field = field;}
    public void setIsBoss(boolean boss) {isBoss = boss;}

    public T[][] getCampo(){return field;}
    @Override
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
        return out;
    }
}
