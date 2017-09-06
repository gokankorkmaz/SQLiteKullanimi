package kodluyoruz.com.sqlitekullanimi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kodluyoruz.com.sqlitekullanimi.Kisiler;
import kodluyoruz.com.sqlitekullanimi.R;

/**
 * Created by GokhanKorkmaz on 6.09.2017.
 */

public class KisilerAdapter  extends RecyclerView.Adapter<ViewHolder>{

    List<Kisiler>kisilerList;

    //Kurucu metot
    public KisilerAdapter(List<Kisiler> kisilerList) {
        this.kisilerList = kisilerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.mtvIsim.setText(kisilerList.get(position).getIsim());
        holder.mtvNumara.setText(kisilerList.get(position).getNumara());
    }

    @Override
    public int getItemCount() {
        return kisilerList.size();
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
