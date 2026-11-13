package workingClass;

public class Pacco {

    private int altezza;
    private int larghezza;
    private Boolean isGirato;

    public Pacco(int altezza, int larghezza)
    {
        this.altezza=altezza;
        this.larghezza=larghezza;
        isGirato=false;
    }

    public void giraIlPacco()
    {
        int supporto;
        supporto = altezza;
        altezza = larghezza;
        larghezza = supporto;

        isGirato=!isGirato;
    }

    public Boolean getIsGirato()
    {
        return isGirato;
    }

    public int getAltezza()
    {
        return altezza;
    }

    public int getLarghezza()
    {
        return larghezza;
    }

    public int getArea()
    {
        return altezza*larghezza;
    }


}
