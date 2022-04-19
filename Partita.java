package com.company;

public class Partita {
    private Campo crypt;
    private boolean isFinished;
    private boolean victory;
    private Protagonista prot;

    /**
     * costruttore con parametri della classe Partita
     * @param crypt
     * @param boss
     */
    public Partita(Campo crypt, boolean boss) {
        this.crypt = crypt;
        crypt.setIsBoss(boss);
        isFinished=false;
        victory=false;
        prot=(Protagonista) crypt.getCampo()[crypt.getYprot()][crypt.getXprot()];
    }

    /**
     * costruttore senza parametri della classe Partita
     */
    public Partita(){
        crypt = new Campo();
        crypt.setIsBoss(false);
        isFinished=false;
        victory=false;
        prot=(Protagonista) crypt.getCampo()[crypt.getYprot()][crypt.getXprot()];
    }

    /**
     * metodo che, dato un carattere da parametro, fa muovere il protagonista nella posizione desiderata
     * @param key
     * @throws Exception
     */
    public void event(char key) throws Exception {
        /**
         * NB le coordinate funzionano nel modo opposto rispetto al normale per le matrici (campo[y][x])
         * gli if all'interno dei case degli switch servono a controllare che le coordinate non vadano fuori
         * dalle dimensioni della matrice e servono per controllare di non andare sopra un muro
         */
        boolean out=true;
        int newX, newY;
        switch (key){
            case 'w':
                newX= crypt.getXprot();
                newY= crypt.getYprot()-1;
                if ((newY>=0) && !(crypt.getCampo()[newY][newX].equals("░"))) {
                    possibilities(newY, newX);
                    System.out.println("mi muovo in alto");
                }
                break;
            case 'a':
                newX= crypt.getXprot()-1;
                newY= crypt.getYprot();
                if ((newX>=0)  && !(crypt.getCampo()[newY][newX].equals("░"))){
                    possibilities(newY,newX);
                    System.out.println("mi muovo a sinistra");
                }
                break;
            case 's':
                newX= crypt.getXprot();
                newY= crypt.getYprot()+1;
                if ((newY <= crypt.getCampo().length)  && !(crypt.getCampo()[newY][newX].equals("░"))) {
                    possibilities(newY, newX);
                    System.out.println("mi muovo in basso");
                }
                break;
            case 'd':
                newX= crypt.getXprot()+1;
                newY= crypt.getYprot();

                if ((newX <= crypt.getCampo().length-1)  && !(crypt.getCampo()[newY][newX].equals("░"))) {
                    possibilities(newY, newX);
                    System.out.println("mi muovo a destra");
                }
                break;
        }
    }


    /**
     * metodo utilizzato per analizzare le varie possibilità che si possono avere prima di spostarsi in una cella con coordinate
     * passate da parametro
     * @param newY  
     * @param newX
     * @throws Exception
     */
    private void possibilities(int newY, int newX) throws Exception {
        boolean out=true;
        System.out.println("posso andare");
        if (!(newX == crypt.getXexit() && newY == crypt.getYexit())) { //se le coordinate non corrispondono alle coordinate dell'uscita
            /**
             * nell'if seguente, tramite l'istanceof viene controllato se nella cella in cui si andrà a posizionare il protagonista
             * è presente un mostro. Se è vero stampa i parametri del mostro e l'esito del loro scontro, se il protagonista dovesse
             * vincere si posizionerebbe nella casella dove è presente il mostro, in caso contrario la partita termina
             *
             */
            if (crypt.getCampo()[newY][newX] instanceof Mostro) {
                System.out.println("ho trovato un mostro, vita: " + ((Mostro) crypt.getCampo()[newY][newX]).getVita() + " , difesa: " + ((Mostro) crypt.getCampo()[newY][newX]).getDifesa() + " , attacco: " + ((Mostro) crypt.getCampo()[newY][newX]).getAttacco());
                out = prot.attacca((Mostro) crypt.getCampo()[newY][newX]); //il protagonista attacca il mostro e mette l'esito dello scontro nella variabile booleana out
                System.out.println("ho attaccato");
                if (!out) { //se out = false viene impostato isFinished a true e victory a false, ciò significa che il giocatore ha perso
                    isFinished = true;
                    victory = false;
                    System.out.println("ho perso");
                } else {
                    move(newY, newX); //il giocatore si muove nella cella dove prima era presente il mostro
                    System.out.println("mi muovo, ho vinto");
                }
            } else {
                /**
                 * nell'if seguente, tramite l'istanceof, viene controllato se, nella cella in cui si andrà a posizionare il protagonista,
                 * è presente un Plus. Se è vero viene effettuato un controllo sul tipo di Plus e, a seconda di esso, viene aumentato
                 * uno dei parametri del protagonista. Infine viene spostato il protagonista nella cella dove prima era presente il Plus
                 */
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
                    /**
                     * se nella cella non sono presenti ne Mostri ne Plus significa che la cella è vuota, quindi il protagonista
                     * può spostarsi liberamente
                     */
                    move(newY, newX);
                    System.out.println("visto che ho trovato vuoto vado");
                }
            }
        }else{
            /**
             * vengono impostate gli attributi isFinished e victory a true perché le coordinate dell'uscita corrispondono con le coordinate
             * della cella su cui il protagonista dovrà spostarsi
             */
            System.out.println("wow hai trovato l'uscita!");
            isFinished=true;
            victory=true;
        }
    }

    /**
     * metodo che utilizza il metodo cambiaPos della classe Campo per far cambiare posizione al protagonista
     * @param y
     * @param x
     */
    public void move(int y, int x){
        crypt.cambiaPos(y,x);
        prot=(Protagonista) crypt.getCampo()[y][x];
    }

    /**
     * metodo che ritorna true se la partita è terminata, la partita termina in caso di vittoria o morte
     * @return isFinished
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * metodo che ritorna true se si ha vinto la partita
     * @return victory
     */
    public boolean isVictory() {
        return victory;
    }

    /**
     * metodo che stampa il campo e i parametri del protagonista
     * @return out
     */
    @Override
    public String toString() {
        String out=crypt.toString();
        out += "\nprotagonista: vita: " + prot.getVita() + " difesa: " + prot.getDifesa() + " attacco: " + prot.getAttacco();
        return out;
    }
}
