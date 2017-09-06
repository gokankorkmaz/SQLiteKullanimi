package kodluyoruz.com.sqlitekullanimi;

/**
 * Created by GokhanKorkmaz on 6.09.2017.
 */

public class Kisiler {

    private String isim,numara;
    private int ID;

    public Kisiler(int ID , String isim ,String numara)
    {
        this.isim = isim;
        this.numara = numara;
        this.ID = ID;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
