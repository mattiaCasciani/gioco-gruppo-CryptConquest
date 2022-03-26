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
public class Plus {
    private double value;
    private int tipo;

    /**
     * Costruttore senza parametri della classe Plus
     */
    public Plus() {
    }

    /**
     * Costruttore con parametri della classe Plus
     * @param value
     * @param tipo
     * @throws Exception                                                                                                 
     */
    public Plus(double value, int tipo) throws Exception {
        setValue(value);
        setTipo(tipo);
    }

    /**
     * metodo che ritorna il valore dell'attributo value
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     * metodo che modifica il valore dell'attributo value con quello passato da parametro
     * @param value
     * @throws Exception
     */
    public void setValue(double value) throws Exception {  
            if (value > 0) {
                this.value = value;
            } else {
                throw new Exception("valore non valido");
            }
  
    }


    /**
     * metodo che ritorna il tipo di plus (attacco, difesa, vita)
     * @return
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * metodo che ritorna il valore dell'attributo tipo con quello passato da parametro
     * @param tipo
     * @throws Exception
     */
    public void setTipo(int tipo) throws Exception {
        if (tipo > 0) {
            this.tipo = tipo;
        } else {
            throw new Exception("tipo non valido");
        }
    }


    /**
     * metodo che stampa le caratteristiche della classe
     * @return
     */
    @Override
    public String toString() {
        return "➕";
    }
}

