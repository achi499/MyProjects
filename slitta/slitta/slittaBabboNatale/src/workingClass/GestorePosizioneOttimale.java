package workingClass;

import java.util.ArrayList;

public class GestorePosizioneOttimale {
    

    public GestorePosizioneOttimale(){    }


    public SpazioLibero trovaMiglioreSpazio(Pacco paccoScelto,ArrayList<SpazioLibero> spaziPossibili)
    {
        
        ArrayList<Integer> areaSprecata = new ArrayList<>();
        ArrayList<SpazioLibero> spaziFinali = new ArrayList<>();

        //confronto per area sprecata minore
        for(SpazioLibero s: spaziPossibili)
        {
            areaSprecata.add(s.getAreaSpazio()-paccoScelto.getArea());
        }

        int areaSprecataMinima=Integer.MAX_VALUE;

        for(int i : areaSprecata)
        {
            if(i<areaSprecataMinima)
            {
                areaSprecataMinima = i;
            }
        }

        for(int i = 0;i < spaziPossibili.size(); i++)
        {
            if(areaSprecata.get(i) == areaSprecataMinima)
            {
                spaziFinali.add(spaziPossibili.get(i));
            }
        }


        if(spaziFinali.size()==1)
        {
            return spaziFinali.get(0);
        }
        
        //caso in cui c'è più di un numero == areaSprecataMinima

        ArrayList<Integer> yBassa = new ArrayList<>();
        ArrayList<Integer> xBassa = new ArrayList<>();
        ArrayList<SpazioLibero> spaziFinaliY = new ArrayList<>();
        ArrayList<SpazioLibero> spaziFinaliX = new ArrayList<>();
        
        //preferisco la Y per prima
        for(SpazioLibero s : spaziFinali)
        {
            yBassa.add(s.getY());
        }

        int yPiuBassa=Integer.MAX_VALUE;

        for(int i : yBassa)
        {
            if(i<yPiuBassa)
            {
                yPiuBassa = i;
            }
        }

        for(int i = 0;i < spaziFinali.size(); i++)
        {
            if(yBassa.get(i) == yPiuBassa)
            {
                spaziFinaliY.add(spaziFinali.get(i));
            }
        }

        if(spaziFinaliY.size()==1)
        {
            return spaziFinaliY.get(0);
        }

        //ora si va con la X
        for(SpazioLibero s : spaziFinaliY)
        {
            xBassa.add(s.getX());
        }

        int xPiuBassa = Integer.MAX_VALUE;

        for(int i : xBassa)
        {
            if(i<xPiuBassa)
            {
                xPiuBassa = i;
            }
        }

        for(int i = 0;i < spaziFinaliY.size(); i++)
        {
            if(xBassa.get(i) == xPiuBassa)
            {
                spaziFinaliX.add(spaziFinaliY.get(i));
            }
        }

        return spaziFinaliX.get(0);
        

    }












}
