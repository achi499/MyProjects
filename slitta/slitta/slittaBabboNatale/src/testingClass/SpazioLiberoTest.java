package testingClass;
import java.util.ArrayList;
import workingClass.Pacco;
import workingClass.SpazioLibero;
public class SpazioLiberoTest {

    public static void main(String[] args) {
        SpazioLibero spazio1 = new SpazioLibero(5, 6, 0, 0);
        SpazioLibero spazio2 = new SpazioLibero(3, 3, 0, 0);
        SpazioLibero spazio3 = new SpazioLibero(10, 10, 0, 0);

        Pacco pacco1 = new Pacco(10, 10);
        Pacco pacco2 = new Pacco(8,8);

        System.out.println(spazio1.getIdSpazio());
        System.out.println(spazio2.getIdSpazio());

        System.out.println("----------------------");

        System.out.println(spazio1.getAltezzaSpazio());
        System.out.println(spazio2.getAltezzaSpazio());

        System.out.println(spazio1.getLarghezzaSpazio());
        System.out.println(spazio2.getLarghezzaSpazio());

        System.out.println(spazio1.getX());
        System.out.println(spazio2.getX());

        System.out.println(spazio1.getY());
        System.out.println(spazio2.getY());

        System.out.println(spazio1.getAreaSpazio());
        System.out.println(spazio2.getAreaSpazio());

        System.out.println("----------------------");

        System.out.println(spazio1.controlloInserimento(pacco1));

        pacco1.giraIlPacco();

        System.out.println(spazio1.controlloInserimento(pacco1));

        System.out.println("----------------------");

        System.out.println(spazio1.controlloInserimento(pacco2));

        pacco2.giraIlPacco();

        System.out.println(spazio1.controlloInserimento(pacco2));

        System.out.println("----------------------");

        pacco1.giraIlPacco();

        ArrayList<SpazioLibero> spaziRimasti = new ArrayList<>();

        spaziRimasti.add(spazio3);

        boolean controllo = false;

        if(spazio3.controlloInserimento(pacco1))
        {
            controllo=true;
        }
        else
        {
            pacco1.giraIlPacco();
            if(spazio3.controlloInserimento(pacco1))
            {
                controllo=true;
            }
        }

        if(controllo)
        {
            ArrayList<SpazioLibero> spaziNuovi = new ArrayList<>();
            spaziNuovi = spazio3.inserimentoPacco(pacco1);

            spaziRimasti.remove(spazio3);
            spazio3 = null;
            spaziRimasti.addAll(spaziNuovi);
        }
        

        for(SpazioLibero s:spaziRimasti)
        {
            System.out.println(s.getIdSpazio());
        }






        
    }







}
