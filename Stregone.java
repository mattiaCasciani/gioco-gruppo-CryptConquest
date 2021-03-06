package gioco;

public class Stregone extends Mostro implements CanUseMana{

    private  int mana;

    /**
     * Costruttore con parametri che chiama il costruttore della classe Mostro
     * @param mana
     * @param difesa
     * @param attacco
     * @param vita
     * @param tipo
     * @throws Exception
     */
    public Stregone(int mana, double difesa, double attacco, double vita, String tipo) throws Exception {
        super(difesa, attacco, vita, tipo);
        setMana(mana);

    }

    /**
     * Costruttore senza parametri
     */
    public Stregone() {
        super();
    }

    /**
     * metodo ereditato dalla classe Mostro
     * @return
     */
    @Override
    public String getTipo() {
        return super.getTipo();
    }

    /**
     * metodo ereditato dalla classe Mostro
     * @param tipo
     * @throws Exception
     */
    @Override
    public void setTipo(String tipo) throws Exception {
        super.setTipo(tipo);
    }

    /**
     * metodo ereditato dalla classe Mostro
     * @param attacco
     * @throws Exception
     */
    @Override
    public void setAttacco(double attacco) throws Exception {
        super.setAttacco(attacco);
    }

    /**
     * metodo ereditato dalla classe Mostro
     * @param difesa
     * @throws Exception
     */
    @Override
    public void setDifesa(double difesa) throws Exception {
        super.setDifesa(difesa);
    }

    /**
     * metodo ereditato dalla classe Mostro
     * @param vita
     * @throws Exception
     */
    @Override
    public void setVita(double vita) throws Exception {
        super.setVita(vita);
    }


    /**
     * metodo ereditato dalla classe Mostro
     * @return
     */
    @Override
    public double getDifesa() {
        return super.getDifesa();
    }

    /**
     * metodo ereditato dalla classe Mostro
     * @return
     */
    @Override
    public double getAttacco() {
        return super.getAttacco();
    }

    /**
     * metodo ereditato dalla classe Mostro
     * @return
     */
    @Override
    public double getVita() {
        return super.getVita();
    }

    /**
     * metodo implementayo dall'interfaccia CanUsemana e ritorna il mana dello stregone
     * @return
     */
    @Override
    public int getMana() {
        return mana;
    }

    /**
     * metodo che modifica la quantit?? di mana dello stregone
     * @param mana
     * @throws Exception
     */
    @Override
    public void setMana(int mana)throws Exception {
        try{
            if(mana >= 0)
                this.mana= mana;
            else
                throw new Exception("valore mana non valido");

        }catch(NullPointerException ex){
            throw new Exception("ERRORE: valore mana null");
        }
    }

    /**
     * metodo che incrementa le statistiche del personaggio in base al mana utilizzato
     * @throws Exception
     */
    public void incrementa() throws Exception {
       int m = getMana();
        if(m != 0){

            Double rand =  (Math.random() * m);

            int i = random();



            switch(i){
                case 0:
                    setVita(getVita()+rand);
                    setMana((int) Math.ceil((m-rand)));
                    break;

                case 1:
                    setAttacco(getAttacco()+rand);
                    setMana((int) Math.ceil((m-rand)));
                    break;

                case 2:
                    setDifesa((getDifesa()+rand));
                    setMana((int) Math.ceil((m-rand)));
            }

        }
    }

    /**
     * metodo per randomizzare un numero da 0 a 2
     * @return
     */
    private int random(){
        int i = (int) (Math.random() * 2);
        return i;
    }


    /**
     * metodo che stampa le caratteristiche della classe
     * @return
     */
    @Override
    public String toString() {
        return "\uD83E\uDDD9\u200D";
    }
}

