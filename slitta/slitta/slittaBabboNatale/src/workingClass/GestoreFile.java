package workingClass;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class GestoreFile 
{
    
    private String nomeFileInput = "santa_simulation_data.csv";
    private String nomeFileOutput = "output.csv";
    private BufferedReader bufferR;
    private BufferedWriter bufferW;
    private String testo;
    private int nInserimenti;
    
    public GestoreFile()
    {
        try
        {
            bufferR = new BufferedReader(new FileReader(nomeFileInput));
            bufferW = new BufferedWriter(new FileWriter(nomeFileOutput));
        }
        catch(FileNotFoundException e)
        {
            System.err.println("errore di tipo: "+e.getMessage());
        }
        catch(IOException e)
        {
            System.err.println("errore di tipo: "+e.getMessage());
        }

        nInserimenti=0;
        testo = "";
    }

    public String leggiStringaFile()
    {
        try 
        {
            return bufferR.readLine();
        } catch (IOException e) 
        {
            System.err.println("errore di tipo: "+e.getMessage());
            return null;
        }
        
    }

    public void trascriviDati(ArrayList<Pacco> pacchi)
    {
        nInserimenti++;

        for(Pacco p:pacchi)
        {
            if(!p.getIsGirato())
            {
                testo += "("+p.getAltezza()+","+p.getLarghezza()+")";
            }
            else
            {
                testo += "("+p.getLarghezza()+","+p.getAltezza()+")";
            } 
        }
        testo += "\n";
    }

    public void salvaSuFile(String seed)
    {
        try
        {
            
            bufferW.write(seed);
            bufferW.newLine();
            bufferW.write(""+nInserimenti);
            bufferW.newLine();
            bufferW.write(testo);

            bufferR.close();
            bufferW.close();
        }
        catch(IOException e)
        {
            System.err.println("errore di tipo: "+e.getMessage());
        }

    }
}
