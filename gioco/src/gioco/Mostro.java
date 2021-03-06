
package gioco;

/**
 *
 * @author luca.visintainer
 */
public class Mostro extends Personaggio{
    private String tipo;

    /**
     * costruttore della classe Mostro
     * @param difesa
     * @param attacco
     * @param vita
     * @param tipo
     * @throws Exception
     */
    public Mostro(double difesa, double attacco, double vita, String tipo) throws Exception {
        super(difesa, attacco, vita);
        setTipo(tipo);
    }

    /**
     * costruttore senza parametri
     */
    public Mostro() {
        super();
    }


    /**
     * ritorna il tipo di mostro
     * @return
     */
    public String getTipo() {
        return tipo;
    }


    /**
     * dopo aver effettuato dei controlli, setta il tipo del mostro in caso non solevi un'eccezione
     * @param tipo
     * @throws Exception
     */
    public void setTipo(String tipo)throws Exception {
        try{
            if(!tipo.equals(""))
                this.tipo = tipo;
            else
                throw new Exception("ERRORE: tipo non valido");
        }catch(NullPointerException ex ){
            throw new Exception("ERRORE: tipo null");
        }

    }

    /**
     * metodo ereditato dalla classe Personaggio
     * @param attacco
     * @throws Exception
     */
    @Override
    public void setAttacco(double attacco) throws Exception {
        super.setAttacco(attacco);
    }

    /**
     * metodo ereditato dalla classe Personaggio
     * @param difesa
     * @throws Exception
     */
    @Override
    public void setDifesa(double difesa)throws Exception{
        super.setDifesa(difesa);
    }

    /**
     * metodo ereditato dalla classe Personaggio
     * @param vita
     * @throws Exception
     */
    @Override
    public void setVita(double vita)throws Exception{
        super.setVita(vita);
    }


    @Override
    /**
     * metodo che stampa le caratteristiche della classe
     */
    public String toString() {
        String out ="";
        if (tipo.equals("non morto"))
            out = "\uD83E\uDDDF";
        else
            out = "GC";
        return out;
    }
}
