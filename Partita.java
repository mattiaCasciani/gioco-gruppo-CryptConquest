package com.company;

public class Partita {
    private Campo crypt;
    private boolean isFinished;
    private boolean victory;
    private Protagonista prot;

    public Partita(Campo crypt, boolean boss) {
        this.crypt = crypt;
        crypt.setIsBoss(boss);
        isFinished=false;
        victory=false;
        prot=(Protagonista) crypt.getCampo()[crypt.getYprot()][crypt.getXprot()];
    }

    public Partita(){
        crypt = new Campo();
        crypt.setIsBoss(false);
        isFinished=false;
        victory=false;
        prot=(Protagonista) crypt.getCampo()[crypt.getYprot()][crypt.getXprot()];
    }

    public void event(char key){
        switch (key){
            case 'w':
            break;
            case 'a':
                break;
            case 's':
                break;
            case 'd':
                break;
        }
    }

    private void move(int y, int x){
        crypt.cambiaPos(y,x);
        prot=(Protagonista) crypt.getCampo()[y][x];
    }


    @Override
    public String toString() {
        String out=crypt.toString();
        out += "\nprotagonista: vita: " + prot.getVita() + " difesa: " + prot.getDifesa() + " attacco: " + prot.getAttacco();
        return out;
    }
}
