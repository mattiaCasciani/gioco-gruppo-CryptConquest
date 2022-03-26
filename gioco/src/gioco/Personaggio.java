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
public abstract class Personaggio {
    private double difesa;
    private double attacco;
    private double vita;

    /**
     * Costruttore senza parametri
     */
    public Personaggio() {
    }

    /**
     * Costruttore con parametri della classe Personaggio
     * @param difesa
     * @param attacco
     * @param vita
     * @throws Exception
     */
    public Personaggio(double difesa, double attacco, double vita) throws Exception {
        setDifesa(difesa);
        setAttacco(attacco);
        setVita(vita);
    }

    /**
     * metodo get dell'attribto difesa
     * @return
     */
    public double getDifesa() {
        return difesa;
    }

    /**
     * metodo che modifica il valore dell'attributo difesa
     * @param difesa
     * @throws Exception
     */
    public void setDifesa(double difesa) throws Exception {
       
            if (difesa >= 0) {
                this.difesa = difesa;
            } else {
                throw new Exception("valore difesa non valido");
            }
        
    }

    /**
     * metodo che restituisce il valore dell'attributo attacco
     * @return
     */
    public double getAttacco() {
        return attacco;
    }

    /**
     * metodo che modifica ol valore dell'attributo attacco con quello passato da parametro
     * @param attacco
     * @throws Exception
     */
    public void setAttacco(double attacco) throws Exception {
      
            if (attacco > 0) {
                this.attacco = attacco;
            } else {
                throw new Exception("valore attacco non valido");
            }
       
    }

    /**
     * metodo che ritorna il valore dell'attributo vita
     * @return
     */
    public double getVita() {
        return vita;
    }

    /**
     * metodo che modifica il valore dell'attributo vita con quello passato da parametro
     * @param vita
     * @throws Exception
     */
    public void setVita(double vita) throws Exception {
    
            if (vita >= 0) {
                this.vita = vita;
            } else {
                throw new Exception("valore vita non valido");
            }
      
    }

    /**
     * metodo che stampa le caratteristiche della classe
     * @return
     */
    public String toString() {
        return "Personaggio{" + "difesa=" + difesa + ", attacco=" + attacco + ", vita=" + vita + '}';
    }


}

