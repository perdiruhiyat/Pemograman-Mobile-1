package com.example.uts_moneytrackerapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.uts_moneytrackerapp.R;
import com.example.uts_moneytrackerapp.model.Transaksi;
import java.util.List;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.ViewHolder> {

    private List<Transaksi> transaksiList;

    public TransaksiAdapter(List<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
    }

    @NonNull
    @Override
    public TransaksiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaksi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiAdapter.ViewHolder holder, int position) {
        Transaksi transaksi = transaksiList.get(position);
        holder.textTanggal.setText(transaksi.getTanggal());
        holder.textKeterangan.setText(transaksi.getKeterangan());
        float jumlah = transaksi.getJumlah();
        boolean isPemasukan = transaksi.isPemasukan();

        String jenis = isPemasukan ? "Pemasukan" : "Pengeluaran";
        holder.textJenis.setText(jenis);

        String prefix = isPemasukan ? "+ Rp " : "- Rp ";
        holder.textJumlah.setText(prefix + jumlah);
    }

    @Override
    public int getItemCount() {
        return transaksiList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTanggal, textKeterangan, textJumlah, textJenis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTanggal = itemView.findViewById(R.id.textTanggal);
            textKeterangan = itemView.findViewById(R.id.textKeterangan);
            textJumlah = itemView.findViewById(R.id.textJumlah);
            textJenis = itemView.findViewById(R.id.textJenis);
        }
    }
}
