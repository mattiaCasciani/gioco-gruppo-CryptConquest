package gioco;


public class FondatoreDellaCripta extends Stregone implements CanUseMana{

    private int nMosse;

    /**
     * Costruttore della classe FondatoredellaCripta che chiama il costruttore della classe Stregone
     * @param mana
     * @param difesa
     * @param attacco
     * @param vita
     * @param tipo
     * @param nMosse
     * @throws Exception
     */
    public FondatoreDellaCripta(int mana, double difesa, double attacco, double vita, String tipo, int nMosse) throws Exception {
        super(mana, difesa, attacco, vita, tipo);
        setnMosse(nMosse);
    }

    /**
     * Costruttore senza parametri della classe FondatoredellaCripta
     */
    public FondatoreDellaCripta() {
        super();
    }

    /**
     * metodo che ritorna il numero di mosse del Fondatore
     * @return
     */
    public int getnMosse() {
        return nMosse;
    }

    /**
     * metodo che modifica il valore dell'attributo nMosse con quello passato da parametro
     * @param nMosse
     * @throws Exception
     */
    public void setnMosse(int nMosse)throws Exception {
        try{
            if(nMosse >= 0)
                this.nMosse = nMosse;
            else
                throw new Exception("Numero mosse non valido");
        }catch(NullPointerException ex){
            throw new Exception("ERRORE: valore di nMosse null");
        }

    }

    /**
     * metodo ereditato dalla classe Stregone
     * @return
     */
    @Override
    public String getTipo() {
        return super.getTipo();
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @param tipo
     * @throws Exception
     */
    @Override
    public void setTipo(String tipo) throws Exception {
        super.setTipo(tipo);
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @param attacco
     * @throws Exception
     */
    @Override
    public void setAttacco(double attacco) throws Exception {
        super.setAttacco(attacco);
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @param difesa
     * @throws Exception
     */
    @Override
    public void setDifesa(double difesa) throws Exception {
        super.setDifesa(difesa);
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @return
     */
    @Override
    public double getDifesa() {
        return super.getDifesa();
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @param vita
     * @throws Exception
     */
    @Override
    public void setVita(double vita) throws Exception {
        super.setVita(vita);
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @return
     */
    @Override
    public double getAttacco() {
        return super.getAttacco();
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @return
     */
    @Override
    public double getVita() {
        return super.getVita();
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @return
     */
    @Override
    public int getMana() {
        return super.getMana();
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @param mana
     * @throws Exception
     */
    @Override
    public void setMana(int mana) throws Exception {
        super.setMana(mana);
    }

    /**
     * metodo ereditato dalla classe Stregone
     * @throws Exception
     */
    @Override
    public void incrementa() throws Exception {
        super.incrementa();
    }


    /**
     * metodo che stampa le caratteristiche della classe
     * @return
     */
    @Override
    public String toString() {
        return "\uD83D\uDC64";
    }
}
