package kodluyoruz.com.sqlitekullanimi.Database;

/**
 * Created by GokhanKorkmaz on 6.09.2017.
 */



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//2-onCreate ve onUpdate metotlarini yaziyorum

/**Oluşturduğum DatabaseHelper sınıfını SQLiteOpenHelper sınıfından
 extends ediyorum. Extends ettikten sonra DatabaseHelper sınıfı hata
 verip, onCreate() ve onUpgrade() metotlarını override etmemi
 isteyecek. Override işleminden sonra en son sınıfın constructor’ ını
 oluşturuyorum.
 *
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME="kisiler.db";

    public static final int DATABASE_VERSION=1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // CREATE TABLE TABLE_NAME (COLUMN TYPE , COLUMN TYPE , COLUMN TYPE);

        final String SQL_CREATE_KISILER_TABLE =
                " CREATE TABLE "+ Contract.ConractEntry.TABLE_NAME+
                        " ( " +
                        Contract.ConractEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Contract.ConractEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                        Contract.ConractEntry.COLUMN_NUMARA + " TEXT NOT NULL " +
                        " ); ";
        db.execSQL(SQL_CREATE_KISILER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.ConractEntry.TABLE_NAME);
        onCreate(db);
    }
}
