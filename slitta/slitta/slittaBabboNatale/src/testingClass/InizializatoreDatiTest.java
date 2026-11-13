package testingClass;
import workingClass.InizializzatoreDati;
import workingClass.Pacco;
import workingClass.SpazioLibero;
public class InizializatoreDatiTest {

    public static void main(String[] args) {
        
        String stringa1 = "22,26";
        String stringa2 = "6,5";
        String stringa3 = "3,5";


        InizializzatoreDati inizializzatore = new InizializzatoreDati();

        SpazioLibero container1 = inizializzatore.creaContainer(stringa1);

        Pacco pacco1 = inizializzatore.creaPacco(stringa2);

        Pacco pacco2 = inizializzatore.creaPacco(stringa3);

        System.out.println(container1.getIdSpazio());

        System.out.println(pacco1.getIsGirato());

        pacco2.giraIlPacco();

        System.out.println(pacco2.getIsGirato());




    }


}
