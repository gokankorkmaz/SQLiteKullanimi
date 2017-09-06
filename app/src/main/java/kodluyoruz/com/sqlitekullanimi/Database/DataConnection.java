package kodluyoruz.com.sqlitekullanimi.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import kodluyoruz.com.sqlitekullanimi.Kisiler;

/**
 * Created by GokhanKorkmaz on 6.09.2017.
 */

//3-
// veritabanımdaki verilere erişmek ve CRUD işlemlerini yapabilmek için
// Data Connection sınıfını oluşturuyorum.


public class DataConnection {

    private static SQLiteDatabase db;
    private static DatabaseHelper databaseHelper;

    public DataConnection(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }


    //veritabani baglantisini ac
    public void open() {
        db = databaseHelper.getWritableDatabase();
    }

    //veritabani baglantisini kapat
    public void close() {
        databaseHelper.close();
    }

    //Tabloya kisi ekleyen metot


    // ContentValues tipinde bir değişken tanımlıyorum.
    // cv.put(COLUMN_NAME,VALUES) ile değer veriyoruz.
    //db.insert(TABLE_NAME,null,cv) metodu ile veritabanına sorguyu gönderiyoruz.

    public void addKisi(Kisiler kisiler) {

        ContentValues cv = new ContentValues();
        cv.put(Contract.ConractEntry.COLUMN_NAME, kisiler.getIsim());     //kisiler,gelen isim
        cv.put(Contract.ConractEntry.COLUMN_NUMARA, kisiler.getNumara()); //kisiler,gelen numara

        db.insert(Contract.ConractEntry.TABLE_NAME, null, cv);

    }

    //Tablodaki tüm verileri silen  metot
    public void deleteKisi() {
        ContentValues cv = new ContentValues();
        db.delete(Contract.ConractEntry.TABLE_NAME, null, null);
    }


    // Veritabanıntaki tüm kayıtları döndürecek metot

    /**
     * Listelemek icin cursor kullanıyorum.Cursor veritabanindaki nesneleri temsil eder.
     * getAllData metodumda db.query() ile tüm verilerimi listeledikten
     * sonra cursoru cursor.moveToFirst() ile en başa gönderdim ve cursor
     * son veriye gelinceye kadar tüm verileri oluşturduğum listeye atmasını
     * istedim. En son bu listeyi return ederek tüm verileri listelemiş oldum.
     */


    public List<Kisiler> getAllData() {
        //Bir Dizi Olusturuyorum
        String columns[] = {
                Contract.ConractEntry._ID + "," +
                        Contract.ConractEntry.COLUMN_NAME + ", " +
                        Contract.ConractEntry.COLUMN_NUMARA

        };

        //Bu metottaki verileri dönecek olan liste
        List<Kisiler> list = new ArrayList<>();

        //tablo adi,tablodaki kolonlar,gerisi null
        Cursor cursor = db.query(Contract.ConractEntry.TABLE_NAME, columns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            //kayıtlı verileri degiskenlere atatim
            int ID = cursor.getInt(0);
            String isim = cursor.getString(1);
            String numara = cursor.getString(2);

            //bir sonraki kayda git
            cursor.moveToNext();
            //Kisiler sınıfına kurucu metot yardımıyla buradan elde ettigim verileri yazdim
            Kisiler kisiler = new Kisiler(ID,isim,numara);
            //donecek olan listeme de  bu verileri ekledim
            list.add(kisiler);


        }

        cursor.close();
        return list;

    }


}
