package gioco;

/**
 *
 * @author luca.visintainer
 */


public class Falciatore extends Mostro {

    private int nCelle;

    /**
     * costruttore con parametri
     * @param nCelle
     * @param difesa
     * @param attacco
     * @param vita
     * @param tipo
     * @throws Exception
     */
    public Falciatore(int nCelle, double difesa, double attacco, double vita, String tipo) throws Exception {
        super(difesa, attacco, vita, tipo);
        setnCelle(nCelle);
    }


    /**
     * costruttore senza parametri
     */
    public Falciatore() {
        super();
    }

    /**
     * metodo get dell'attributo
     * @return
     */
    public int getnCelle() {
        return nCelle;
    }

    /**
     * metodo set dell'attributo
     * @param nCelle
     * @throws Exception
     */
    public void setnCelle(int nCelle) throws Exception{
        try{
            if(nCelle >= 0)
                this.nCelle = nCelle;
            else
                throw new Exception("Valore di nCelle non valido");
        }catch(NullPointerException ex){
            throw new Exception("ERRORE: valore di nCelle null");
        }

    }

    /**
     * metodo che ritorna le caratteristiche della classe
     * @return
     */
    public String toString() {
        return "FL";
    }

}
