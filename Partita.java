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

    public void event(char key) throws Exception {
        boolean out=true;
        int newX, newY;
        switch (key){
            case 'w':
                newX= crypt.getXprot();
                newY= crypt.getYprot()-1;
                if (newY>0 || !(crypt.getCampo()[newY][newX].equals("░"))) {
                    possibilities(newY, newX);
                    System.out.println("mi muovo in alto");
                }
            break;
            case 'a':
                newX= crypt.getXprot()-1;
                newY= crypt.getYprot();
                if (newY>0 || !(crypt.getCampo()[newY][newX].equals("░"))){
                    possibilities(newY,newX);
                    System.out.println("mi muovo a sinistra");
                }
            break;
            case 's':
                newX= crypt.getXprot();
                newY= crypt.getYprot()+1;
                if (newY>0 || !(crypt.getCampo()[newY][newX].equals("░"))) {
                    possibilities(newY, newX);
                    System.out.println("mi muovo in basso");
                }
            break;
            case 'd':
                newX= crypt.getXprot()+1;
                newY= crypt.getYprot();
                if (newY>0 || !(crypt.getCampo()[newY][newX].equals("░"))) {
                    possibilities(newY, newX);
                    System.out.println("mi muovo a destra");
                }
            break;
        }
    }

    private void possibilities(int newY, int newX) throws Exception {
        boolean out=true;
        System.out.println("posso andare");
        if (!(newX == crypt.getXexit() && newY == crypt.getYexit())) {
            if (crypt.getCampo()[newY][newX] instanceof Mostro) {
                System.out.println("ho trovato un mostro, vita: " + ((Mostro) crypt.getCampo()[newY][newX]).getVita() + " , difesa: " + ((Mostro) crypt.getCampo()[newY][newX]).getDifesa() + " , attacco: " + ((Mostro) crypt.getCampo()[newY][newX]).getAttacco());
                out = prot.attacca((Mostro) crypt.getCampo()[newY][newX]);
                System.out.println("ho attaccato");
                if (!out) {
                    isFinished = true;
                    victory = false;
                    System.out.println("ho perso");
                } else {
                    move(newY, newX);
                    System.out.println("mi muovo, ho vinto");
                }
            } else {
                if (crypt.getCampo()[newY][newX] instanceof Plus) {
                    System.out.println("ho trovato un plus");
                    int tipo = (((Plus) crypt.getCampo()[newY][newX]).getTipo());
                    if (tipo == 1)
                        prot.setAttacco(prot.getAttacco() + ((Plus) crypt.getCampo()[newY][newX]).getValue());
                    else if (tipo == 2)
                        prot.setVita(prot.getVita() + ((Plus) crypt.getCampo()[newY][newX]).getValue());
                    else
                        prot.setDifesa(prot.getDifesa() + ((Plus) crypt.getCampo()[newY][newX]).getValue());
                    System.out.println("cambiato i parametri");
                    move(newY, newX);
                } else {
                    move(newY, newX);
                    System.out.println("visto che ho trovato vuoto vado");
                }
            }
        }else{
            System.out.println("wow hai trovato l'uscita!");
            isFinished=true;
            victory=true;
        }
    }

    public void move(int y, int x){
        crypt.cambiaPos(y,x);
        prot=(Protagonista) crypt.getCampo()[y][x];
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isVictory() {
        return victory;
    }

    @Override
    public String toString() {
        String out=crypt.toString();
        out += "\nprotagonista: vita: " + prot.getVita() + " difesa: " + prot.getDifesa() + " attacco: " + prot.getAttacco();
        return out;
    }
}
