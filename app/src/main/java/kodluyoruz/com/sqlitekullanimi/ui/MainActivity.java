package kodluyoruz.com.sqlitekullanimi.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import kodluyoruz.com.sqlitekullanimi.Adapter.KisilerAdapter;
import kodluyoruz.com.sqlitekullanimi.Database.DataConnection;
import kodluyoruz.com.sqlitekullanimi.Kisiler;
import kodluyoruz.com.sqlitekullanimi.R;

public class MainActivity extends AppCompatActivity
{
    EditText mEtIsim,mEtNumara;
    Button mBtnEkle,mBtnSil;

    RecyclerView recyclerView;
    KisilerAdapter kisilerAdapter;

    List<Kisiler>kisiler;
   // CustomItemClickListener customItemClickListener;

    String isim,numara;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mEtIsim = (EditText)findViewById(R.id.etIsim);
        mEtNumara = (EditText)findViewById(R.id.etNumara);
        mBtnEkle = (Button)findViewById(R.id.btnEkle);
        mBtnSil=(Button)findViewById(R.id.btnSil);


        //Veritabanı bağlantısı açıldı
        final DataConnection dataConnection = new DataConnection(this);
        dataConnection.open();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Donen verileri kisiler listesine aktardım
        kisiler = dataConnection.getAllData();
        kisilerAdapter = new KisilerAdapter(kisiler);
        recyclerView.setAdapter(kisilerAdapter);



        //Button click olduğunda veritabanına kişi eklenecek
        mBtnEkle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int ID = 0;
                isim = mEtIsim.getText().toString();
                numara = mEtNumara.getText().toString();
                try
                {
                    //Burası verileri kaydetme
                    Kisiler kisi = new Kisiler(ID,isim,numara);
                    dataConnection.addKisi(kisi);

                    //Kaydedilen verileri gosterme
                    kisiler = dataConnection.getAllData();
                    kisilerAdapter = new KisilerAdapter(kisiler);
                    recyclerView.setAdapter(kisilerAdapter);

                    mEtIsim.setText("");
                    mEtNumara.setText("");
                    mEtIsim.requestFocus();

                    Toast.makeText(MainActivity.this,"Kisi Eklendi",Toast.LENGTH_LONG).show();
                }
                catch (android.database.sqlite.SQLiteException ex)
                {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Button click olduğu zaman veritabanındaki tüm veriler silenecek
        mBtnSil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dataConnection.deleteKisi();

                kisiler = dataConnection.getAllData();
                kisilerAdapter = new KisilerAdapter(kisiler);
                recyclerView.setAdapter(kisilerAdapter);

                Toast.makeText(MainActivity.this,"Tüm Kişiler Silindi",Toast.LENGTH_LONG).show();
            }
        });

    }
}