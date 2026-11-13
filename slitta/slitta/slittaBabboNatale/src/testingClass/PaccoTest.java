package testingClass;
import workingClass.Pacco;
public class PaccoTest {

    public static void main(String[] args)
    {
        Pacco pacco;

        pacco = new Pacco(6,5);

        System.out.println(pacco.getAltezza());
        System.out.println(pacco.getLarghezza());
        System.out.println(pacco.getArea());
        System.out.println(pacco.getIsGirato());

        pacco.giraIlPacco();

        System.out.println(pacco.getAltezza());
        System.out.println(pacco.getLarghezza());
        System.out.println(pacco.getArea());
        System.out.println(pacco.getIsGirato());

    }
}
