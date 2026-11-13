package workingClass;

import java.util.ArrayList;

//questa classe rappresenta lo spazio libero all'interno del contenitore. all'inizio sarà uguale al contenitore,
//ma successivamente si ridurra in più pezzi più piccoli
public class SpazioLibero {

    private final int altezza;
    private final int larghezza;
    private final int x;
    private final int y;
    private static int contatore = 0;
    private final int idSpazio;


    public SpazioLibero(int altezza,int larghezza,int x,int y)
    {
        this.altezza=altezza;
        this.larghezza=larghezza;
        this.x=x;
        this.y=y;
        contatore++;
        idSpazio = contatore;
    }

    public Boolean controlloInserimento(Pacco pacco)
    {
        return altezza >= pacco.getAltezza() && larghezza >= pacco.getLarghezza();
    }

    public ArrayList<SpazioLibero> inserimentoPacco(Pacco pacco)
    {
        ArrayList<SpazioLibero> nuoviSpazi= new ArrayList<>();

        //spazio a destra
        int nuovaLargezzaDestra = this.larghezza-pacco.getLarghezza();

        if(nuovaLargezzaDestra > 0)
        {
            int nuovaX=this.x+pacco.getLarghezza();
            int nuovaAltezzaDestra = pacco.getAltezza();

            SpazioLibero nuovoSpazio =new SpazioLibero(nuovaAltezzaDestra,nuovaLargezzaDestra,nuovaX,this.y);

            nuoviSpazi.add(nuovoSpazio);
        }

        //spazio sotto
        int nuovaAltezzaSotto = this.altezza-pacco.getAltezza();
        if(nuovaAltezzaSotto > 0)
        {
            int nuovaY = this.y+pacco.getAltezza();

            SpazioLibero nuovoSpazio =new SpazioLibero(nuovaAltezzaSotto,this.larghezza,this.x,nuovaY);

            nuoviSpazi.add(nuovoSpazio);
        }

        return nuoviSpazi;
        
    }

    public int getAltezzaSpazio()
    {
        return altezza;
    }

    public int getLarghezzaSpazio()
    {
        return larghezza;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getIdSpazio()
    {
        return idSpazio;
    }

    public int getAreaSpazio()
    {
        return larghezza*altezza;
    }






}
