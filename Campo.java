package com.company;
import java.lang.Math;
import java.util.Arrays;

public class Campo <T>{
    private Settore[][] field;
    private boolean boss;
    private int xExit;
    private int yExit;
    private int xProt;
    private int yProt;
    private Integer xBoss;
    private Integer yBoss;

    public Campo(Settore[][] field, boolean boss) throws Exception  {
        this.boss=boss;
        this.field=field.clone();
    }

    public boolean getBoss(){return boss;}

    public T getSettoreInside(int x, int y)throws Exception{
        if ((x >= 0 && x<field[0].length) && (y >= 0 && y<field.length))
            return (T) field[y][x].getInside();
        else
            throw new Exception("errore, dato non valido");
    }

    public Settore getSettore(int x, int y)throws Exception{
        if ((x >= 0 && x<field[0].length) && (y >= 0 && y<field.length))
            return field[y][x];
        else
            throw new Exception("errore, dato non valido");
    }

    public void setxExit(int xExit) {
        this.xExit = xExit;
    }

    public void setyExit(int yExit) {
        this.yExit = yExit;
    }

    public void setxProt(int xProt) {
        this.xProt = xProt;
    }

    public void setyProt(int yProt) {
        this.yProt = yProt;
    }

    public void setxBoss(Integer xBoss) {
        this.xBoss = xBoss;
    }

    public void setyBoss(Integer yBoss) {
        this.yBoss = yBoss;
    }

    public int getxExit() {
        return xExit;
    }

    public int getyExit() {
        return yExit;
    }

    public int getxProt() {
        return xProt;
    }

    public int getyProt() {
        return yProt;
    }

    public Integer getxBoss() {
        return xBoss;
    }

    public Integer getyBoss() {
        return yBoss;
    }

    public Settore[][] getCampo(){return field;}

    public Campo() throws Exception {
        boss = false;
        xExit = 7;
        yExit=11;
        load();
    }

    public void add(T ogg, int x, int y) throws Exception{
        field[y][x] = null;
        field[y][x] = new Settore(true, ogg);
    }

    private void load() throws Exception{
        field = new Settore[12][12];
        for (int i =0; i< field.length; i++){
            for (int j =0; j<field[0].length; j++){
                field[i][j]=new Settore(false, "o");
            }
        }
        Plus pl[] = {new Plus(15.0, 1), new Plus(20.0, 2), new Plus(10.0, 3)};
        Protagonista prot= new Protagonista(30.0, 50.0, 30.0, "protagonista");
        xProt=0;
        yProt=0;

        add((T)prot, xProt, yProt);

        addPriv(10, (T)"░");

        addPriv(3, (T) new Falciatore(8, 99999999.9, 99999999.9, 99999999.9, "mietitore"));

        addPriv(30, (T) new Mostro(20.0, 30.0, 40.0, "non morto"));

        addPriv(12, (T) new NonMortoStregato(2, 20.0, 30.0, 40.0, "non morto stregato"));

        addPriv(20, (T)new Stregone(3, 22.0, 30.0, 45.0, "stregone"));

        addPriv(9, (T)new Mostro(100.0, 70.0, 200.0, "guardiano della cripta"));

        int xCas=xExit;
        int yCas=yExit;
        for (int i =0; i< 40; i++){
            int tipoPlus = (int) (Math.random());
            while (occupato(xCas, yCas)){
                xCas= ((int) (Math.random()*12));
                yCas= (int) ((Math.random()*12));
            }
            add((T)pl[tipoPlus], xCas, yCas);
        }
    }

    private void addPriv(int n, T ogg) throws Exception {
        int xCas=xExit;
        int yCas=yExit;
        for (int i =0; i< n; i++){
            while (occupato(xCas, yCas)){
                xCas= ((int) (Math.random()*12));
                yCas= ((int) (Math.random()*12));
            }
            add(ogg, xCas, yCas);
        }

        if(boss){
            xBoss=xCas;
            yBoss=yCas;
        }
    }

    private boolean occupato(int x, int y){
        return (x < 0 || x > field[0].length) || (y < 0 || y > field.length) || (x == xExit && y == yExit) || (field[y][x].getIsFull()==true);
    }

    public void campiaPosizione(int x, int y) throws Exception {
        add((T) field[xProt][yProt].getInside(), x, y);
        field[yProt][xProt].setInside("o");
        field[yProt][xProt].setFull(false);
        xProt=x;
        yProt=y;
    }

    public void cambiaPosBoss() throws Exception{
        int newXBoss;
        int newYBoss;
        if(xBoss == null || yBoss == null)
            throw new Exception("posizioni boss non valide");
        if(field[yBoss][xBoss].getInside()==null)
            throw new Exception("errore, fondatore della cripta non esiste");
        add((T)field[yBoss][xBoss].getInside(), xBoss-1, yBoss-1);
    }

    @Override
    public String toString() {
        String out = " ╔═══════════════════════════════════════════════════╗\n";
        for (int i =0; i< field.length; i++){
            for (int j =0; j<field[0].length; j++){
                if (j == 0)
                    out += " ║ ";
                if (i == yExit && j == xExit)
                    out += "\uD83D\uDEAA\t";
                else if (field[i][j].getInside() == "o")
                    out +=" \t";
                else
                    out += field[i][j] + "\t";
            }
            out +=" ║\n";
            if (i==11)
                out+=" ╚═══════════════════════════════════════════════════╝";
        }
        return out;
    }
}
