package testingClass;
import java.util.ArrayList;
import workingClass.GestoreFile;
import workingClass.Pacco;
public class GestoreFileTest {


    public static void main(String[] args) {
        
        GestoreFile gestore = new GestoreFile();


        String stringa;

        while((stringa=gestore.leggiStringaFile())!=null)
        {
            System.out.println(stringa);
        }

        System.out.println("------------------------");

        ArrayList<Pacco> pacchi1 = new ArrayList<>();
        ArrayList<Pacco> pacchi2 = new ArrayList<>();

        pacchi1.add(new Pacco(1, 2));
        pacchi1.add(new Pacco(3, 4));
        pacchi1.add(new Pacco(5, 6));

        pacchi2.add(new Pacco(7,8));
        pacchi2.add(new Pacco(9,10));
        pacchi2.add(new Pacco(11,12));

        gestore.trascriviDati(pacchi1);
        gestore.trascriviDati(pacchi2);

        gestore.salvaSuFile("164658");






    }

}
