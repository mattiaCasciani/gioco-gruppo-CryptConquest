/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gioco;

/**
 *
 * @author luca.visintainer
 */
public class Settore <T>{
    private boolean isFull;
    private T inside;


    /**
     * costruttore della classe Settore
     * @param isFull
     * @param inside
     * @throws Exception
     */
    public Settore(boolean isFull, T inside) throws Exception {
        setFull(isFull);
        setInside(inside);
    }

    /**
     * costruttore senza parametri
     */
    public Settore() {
    }

    /**
     * metodo che mi ritorna se la cella è piena o vuota
     * @return
     */
    public boolean getIsFull() {
        return isFull;
    }

    /**
     * metodo che setta il valore dell'attributo isFull con il valore passato da parametro
     * @param full
     */
    public void setFull(boolean full) {
        isFull = full;
    }

    /**
     * metodo get dell'attributo inside
     * @return
     */
    public T getInside() {
        return inside;
    }

    /**
     * metodo che dopo aver effettuato dei controlli assegna all'attributo il parametro
     * @param inside
     * @throws Exception
     */
    public void setInside(T inside)throws Exception {
        try{
            this.inside = inside;
        }catch(NullPointerException ex){
            throw new Exception("Errore: parametro null");
        }

    }

    /**
     * metodo che rimuove l'elemento
     */
    public void remove(){
        inside = null;
    }


    /**
     * metodo che stampa le caratteristiche della classe
     * @return
     */
    public String toString() {
        String out = "";
        out = inside != null ? "Settore{" +
                "isFull=" + isFull +
                ", inside=" + inside +
                '}': out;
        return out ;
    }
}
