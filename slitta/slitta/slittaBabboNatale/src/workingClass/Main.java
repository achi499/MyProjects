package workingClass;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        String seed;
        String container;
        ArrayList<Pacco> pacchiTotali = new ArrayList<>();
        GestoreFile gestore = new GestoreFile();
        InizializzatoreDati inizializzatore = new InizializzatoreDati();
        GestorePosizioneOttimale posizionatore = new GestorePosizioneOttimale();

        seed = gestore.leggiStringaFile();
        container = gestore.leggiStringaFile();

        String stringa;
        while((stringa = gestore.leggiStringaFile())!=null)
        {
            pacchiTotali.add(inizializzatore.creaPacco(stringa));
        }

        //ciclo principale
        
        while(!pacchiTotali.isEmpty())
        {

            SpazioLibero spazioIniziale = inizializzatore.creaContainer(container);
            ArrayList<SpazioLibero> spazi = new ArrayList<>();
            ArrayList<Pacco>pacchiInseriti = new ArrayList<>();
            spazi.add(spazioIniziale);



            for(int p=pacchiTotali.size()-1;p>=0;p--)//p sta per pacco
            {

                ArrayList<SpazioLibero>spaziPossibili = new ArrayList<>();

                for(SpazioLibero s: spazi)
                {
                    if(s.controlloInserimento(pacchiTotali.get(p)))
                    {
                        spaziPossibili.add(s);
                    }
                    else
                    {
                        pacchiTotali.get(p).giraIlPacco();
                        if(s.controlloInserimento(pacchiTotali.get(p)))
                        {
                            spaziPossibili.add(s);
                        }
                    }
                }


                if(spaziPossibili.size()>1)
                {
                    ArrayList<SpazioLibero> spaziNuovi = new ArrayList<>();

                    SpazioLibero spazioScelto = posizionatore.trovaMiglioreSpazio(pacchiTotali.get(p),spaziPossibili);

                    spaziNuovi = spazioScelto.inserimentoPacco(pacchiTotali.get(p));

                    spazi.remove(spazioScelto);
                    spazi.addAll(spaziNuovi);

                    pacchiInseriti.add(pacchiTotali.get(p));
                    pacchiTotali.remove(p);

                }
                else if(spaziPossibili.size()==1)
                {
                    ArrayList<SpazioLibero> spaziNuovi = new ArrayList<>();

                    spaziNuovi = spaziPossibili.get(0).inserimentoPacco(pacchiTotali.get(p));

                    spazi.remove(spaziPossibili.get(0));
                    spazi.addAll(spaziNuovi);

                    pacchiInseriti.add(pacchiTotali.get(p));
                    pacchiTotali.remove(p);
                }
            }

            gestore.trascriviDati(pacchiInseriti);
        }

        gestore.salvaSuFile(seed);
    }



    
}
