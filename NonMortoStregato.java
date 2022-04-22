package gioco;


public class NonMortoStregato extends Mostro implements CanUseMana {

    private int mana;

    /**
     * Costruttore della classe NonMortoStregato che chiama il costruttore della classe Mostro
     * @param mana
     * @param difesa
     * @param attacco
     * @param vita
     * @param tipo
     * @throws Exception
     */
    public NonMortoStregato(int mana, double difesa, double attacco, double vita, String tipo) throws Exception {
        super(difesa, attacco, vita, tipo);
        setMana(mana);
    }

    /**
     * Costruttore senza parametri della classe NonMortoStregato
     */
    public NonMortoStregato() {
        super();
    }

    /**
     * metodo implementato dall'interfaccia CanUseMana
     * @return
     */
    @Override
    public int getMana() {
        return mana;
    }

    /**
     * metodo implementato dall'interfaccia CanUseMana
     * @param mana
     */

    @Override
    public void setMana(int mana) throws Exception {
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
     * metodo che stampa le caratteristiche della classe
     * @return
     */
    public String toString() {
        return "\uD83E\uDDDB";
    }

}

