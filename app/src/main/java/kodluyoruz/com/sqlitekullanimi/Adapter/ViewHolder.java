package kodluyoruz.com.sqlitekullanimi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kodluyoruz.com.sqlitekullanimi.R;

/**
 * Created by GokhanKorkmaz on 6.09.2017.
 */


//Öncelikle ViewHolder olusturdum şimdi Adapter Sınıfını olusturacagım ve bu sınıfı da orada extend edicem
public class ViewHolder extends RecyclerView.ViewHolder {

    //Burada olusturdugum list.item.xml deki nesneleri tanımlıyorum

    TextView mtvIsim,mtvNumara;

    public ViewHolder(View itemView) {
        super(itemView);

        //Buradada itemView üzerinden findViewById metodu sayesinde eslestirme yapıyorum

        mtvIsim=(TextView) itemView.findViewById(R.id.tvIsim);
        mtvNumara=(TextView) itemView.findViewById(R.id.tvNumara);
    }
}
