package workingClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InizializzatoreDati {

    public InizializzatoreDati(){   }

    public Pacco creaPacco(String stringa)
    {
        Pattern p = Pattern.compile("(\\d+),(\\d+)");
        Matcher sequenza = p.matcher(stringa);

        if(sequenza.find())
        {
            int altezza = Integer.parseInt(sequenza.group(1));
            int larghezza = Integer.parseInt(sequenza.group(2));

            Pacco pacco = new Pacco(altezza,larghezza);

            return pacco;
        }
        else
        {
            System.err.println("si è verificato un errore nella lettura del file");
            return null;
        }

    }

    public SpazioLibero creaContainer(String stringa)
    {
        Pattern p = Pattern.compile("(\\d+),(\\d+)");
        Matcher sequenza = p.matcher(stringa);

        if(sequenza.find())
        {
            int altezza = Integer.parseInt(sequenza.group(1));
            int larghezza = Integer.parseInt(sequenza.group(2));

            SpazioLibero container = new SpazioLibero(altezza,larghezza,0,0);

            return container;
        }
        else
        {
            System.err.println("si è verificato un errore nella lettura del file");
            return null;
        }

    }

}
