package kodluyoruz.com.sqlitekullanimi.Database;

/**
 * Created by GokhanKorkmaz on 6.09.2017.
 */

//1-tablo ve kolon isimlerini tanımla

import android.provider.BaseColumns;

/**Oluşturduğum Contract sınıfı içerinde ConractEntry sınıfı
 oluşturuyorum. Oluşturuduğum ConractEntry’i BaseColumns adlı
 interfaceden implement ediyorum. Bu sayede tablomun ID kolunu
 otomatik olarak tanımlanmış oluyor
 *
 *
 */
public class Contract {




    public static final class ConractEntry implements BaseColumns{
            //tablo adi
        public static final String TABLE_NAME="kisiler";
            //tablodaki sutun adlari
        public static final String COLUMN_NAME="isim";

        public static final String COLUMN_NUMARA="numara";
    }
}
