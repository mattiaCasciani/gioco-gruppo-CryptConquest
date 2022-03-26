package gioco;

import gioco.Campo;

public class Partita {
    private Campo crypt;
    private boolean isFinished;
    private boolean victory;

    public Partita(Campo crypt, boolean boss, boolean isFinished, boolean victory) throws Exception {
        this.crypt = new Campo(crypt.getCampo(), boss);
        this.isFinished = isFinished;
        this.victory = victory;
    }

    public Partita() throws Exception {
        crypt = new Campo();
        isFinished=false;
        victory=false;
    }

    public Campo getCrypt(){return crypt;}

    public void setCampo(Campo crypt) throws Exception {
        this.crypt = new Campo(crypt.getCampo(), crypt.getBoss());
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public void event(char key) throws Exception {

            Protagonista prot = (Protagonista) crypt.getCampo()[crypt.getyProt()][crypt.getxProt()].getInside();
             System.out.println("posizione attuale: " + crypt.getxProt() + crypt.getyProt() +"cella a destra: " + crypt.getCampo()[getCrypt().getyProt()][crypt.getxProt()+1].getInside());
            switch (key){
                case 'w':
                    if ((crypt.getyProt()-1) > 0) {
                        spostamenti(prot, crypt.getxProt(), (crypt.getyProt()-1));
                    }
                    break;
                case 'a':
                    if ((crypt.getxProt()-1) > crypt.getCampo()[getCrypt().getyProt()].length)
                        spostamenti(prot, (crypt.getxProt()-1), crypt.getyProt());
                    break;
                case 's':
                    if ((crypt.getyProt()+1) < crypt.getCampo().length){
                        spostamenti(prot, crypt.getxProt(), (crypt.getyProt()+1));
                    }
                    break;
                case 'd':
                    if ((crypt.getxProt()+1) < crypt.getCampo()[getCrypt().getyProt()].length)
                        spostamenti(prot, (getCrypt().getxProt()+1), getCrypt().getyProt());
                    break;
                default:
                    throw new Exception("errore, dato non valido");
            }
        
    }

    private void spostamenti(Protagonista prot, int x, int y) throws Exception {
        if (getCrypt().getSettoreInside(x, y) instanceof Mostro) {
            Mostro mon = (Mostro) getCrypt().getCampo()[y][x].getInside();
            System.out.println("tipo: " +      mon.getTipo() + "\tattacco: " + mon.getAttacco()+ "\tvita: " + mon.getVita()+ "\tdifesa: " + mon.getDifesa());
            boolean atk = prot.attacca(mon);
            if (atk == false) {
                victory = false;
                isFinished = true;
                System.out.println("attacco");
            }
        } else if (getCrypt().getSettoreInside(x, y) instanceof Plus) {
            Plus pl = (Plus) getCrypt().getSettoreInside(x, y);
            if (pl.getTipo() == 1)
                prot.setVita(prot.getVita() + pl.getValue());
            else if (pl.getTipo() == 2)
                prot.setDifesa(prot.getDifesa() + pl.getValue());
            else
                prot.setAttacco( prot.getAttacco() + pl.getValue());
            System.out.println("prendo plus");
        }
        crypt.campiaPosizione(x, y);

    }

    public void boss(FondatoreDellaCripta boss){

    }

    public void cambiaPosBoss(){

    }

    @Override
    public String toString() {
        Protagonista prot = (Protagonista) crypt.getCampo()[crypt.getyProt()][crypt.getxProt()].getInside();
        String s = "Partita{\n" +
                crypt.toString() +
                "\nattacco: " + prot.getAttacco() + "\tdifesa: " + prot.getDifesa() + "\tvita: " + prot.getVita() +
                "\nisFinished=" + isFinished +
                ", victory=" + victory +
                '}';
        return s;
    }
}
