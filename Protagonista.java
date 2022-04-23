package gioco;


public class Protagonista extends Personaggio {
    private String nome;

    public Protagonista(double difesa, double attacco, double vita, String nome) throws Exception {
        super(difesa, attacco, vita);
        setNome(nome);
    }

    public Protagonista() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome)throws Exception {
        try{
            this.nome = nome != "" ? nome : this.nome;
        }catch(NullPointerException ex ) {
            throw new Exception("ERRORE: Nome null");
        }
    }

    @Override
    public void setAttacco(double attacco) throws Exception {
        super.setAttacco(attacco);
    }

    @Override
    public void setDifesa(double difesa)throws Exception{
        super.setDifesa(difesa);
    }

    @Override
    public void setVita(double vita)throws Exception{
        super.setVita(vita);
    }

   public boolean attacca(Mostro monster) throws Exception{
        Double nuovaVitaMostro=((monster.getVita()+ (monster.getDifesa())/2))-getAttacco();
        Double nuovaVitaProtagonista=((getVita()+(getDifesa())/2))- monster.getAttacco();
        while (nuovaVitaProtagonista > 0 || nuovaVitaMostro > 0) {
            if (nuovaVitaMostro <= 0){ //controlla se il mostro riesce a sopravvivere all'attacco del protagonista
                Double nuovaDifesa = getDifesa() - (monster.getAttacco()*2);
                if (nuovaDifesa <=0){ // controlla se la difesa del protagonista è minore di 0, in questo caso allora la difesa viene portata a 0 e viene scalata la vita
                    setDifesa(0.0);
                    setVita(getVita()+(nuovaDifesa/2));
                }else
                    setDifesa(nuovaDifesa);
                return true;
            }
            nuovaVitaMostro -= getAttacco();
            nuovaVitaProtagonista -= monster.getAttacco();
        }
        return false; // non serve fare un controllo se l'attacco del mostro è maggiore dell'attacco e difesa del protagonista perché nuovaVitaProtagonista alla fine del ciclo sarebbe minore di zero in caso di sconfitta, portando ad uscire dal ciclo e ritornando false, quindi una sconfitta.
    }



            @Override
    public String toString() {
        return "\uD83E\uDDCD";
    }
}
