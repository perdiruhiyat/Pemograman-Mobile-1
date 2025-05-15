package com.example.uts_moneytrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.uts_moneytrackerapp.adapter.TransaksiAdapter;
import com.example.uts_moneytrackerapp.model.Transaksi;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private CardView cardPemasukan, cardPengeluaran;
    private TextView textNamaUser, totalSaldo;
    private RecyclerView recyclerView;
    private TransaksiAdapter adapter;
    private ArrayList<Transaksi> transaksiList;
    private String name;
    private int saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Get data
        Intent intent = getIntent();
        name = intent.getStringExtra("username");
        saldo = intent.getIntExtra("saldo", 0);
        transaksiList = intent.getParcelableArrayListExtra("transaksiList");
        if (transaksiList == null) {
            transaksiList = new ArrayList<>();
        }

        // Init view
        textNamaUser = findViewById(R.id.textNamaUser);
        totalSaldo = findViewById(R.id.totalSaldo);
        cardPemasukan = findViewById(R.id.cardPemasukan);
        cardPengeluaran = findViewById(R.id.cardPengeluaran);
        recyclerView = findViewById(R.id.recyclerViewMutasi);

        // Set text
        textNamaUser.setText("Halo, " + name);
        totalSaldo.setText("Total Saldo: Rp " + saldo);

        // RecyclerView setup
        adapter = new TransaksiAdapter(transaksiList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Click listeners
        cardPemasukan.setOnClickListener(v -> {
            Intent i = new Intent(DashboardActivity.this, PemasukanActivity.class);
            i.putExtra("username", name);
            i.putExtra("saldo", saldo);
            i.putParcelableArrayListExtra("transaksiList", transaksiList);
            startActivity(i);
            finish();
        });

        cardPengeluaran.setOnClickListener(v -> {
            Intent i = new Intent(DashboardActivity.this, PengeluaranActivity.class);
            i.putExtra("username", name);
            i.putExtra("saldo", saldo);
            i.putParcelableArrayListExtra("transaksiList", transaksiList);
            startActivity(i);
            finish();
        });
    }
}
