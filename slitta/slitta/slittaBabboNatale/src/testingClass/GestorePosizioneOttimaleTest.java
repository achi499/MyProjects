package testingClass;
import java.util.ArrayList;
import workingClass.GestorePosizioneOttimale;
import workingClass.Pacco;
import workingClass.SpazioLibero;
public class GestorePosizioneOttimaleTest 
{
    public static void main(String[] args) 
    {
        GestorePosizioneOttimale gestore = new GestorePosizioneOttimale();
        
        Pacco pacco = new Pacco(5,5);

        SpazioLibero spazio1 = new SpazioLibero(5,5, 0, 0);
        SpazioLibero spazio2 = new SpazioLibero(5,7, 5, 0);
        SpazioLibero spazio3 = new SpazioLibero(7,5, 0, 5);
        SpazioLibero spazio4 = new SpazioLibero(5,5, 0, 12);

        ArrayList<SpazioLibero> spaziScelti = new ArrayList<>();

        spaziScelti.add(spazio1);
        spaziScelti.add(spazio2);
        spaziScelti.add(spazio3);
        spaziScelti.add(spazio4);

        System.out.println(gestore.trovaMiglioreSpazio(pacco,spaziScelti).getIdSpazio());


    }
    

}
