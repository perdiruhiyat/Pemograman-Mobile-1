package com.example.uts_moneytrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
    private float saldo;

    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        // Get data
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        saldo = intent.getFloatExtra("saldo", 0);
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
        totalSaldo.setText(String.format("Total Saldo: Rp %.2f", saldo));

        // RecyclerView setup
        adapter = new TransaksiAdapter(transaksiList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Click listeners
        cardPemasukan.setOnClickListener(v -> {
            Intent i = new Intent(DashboardActivity.this, PemasukanActivity.class);
            i.putExtra("name", name);
            i.putExtra("saldo", saldo);
            i.putParcelableArrayListExtra("transaksiList", transaksiList);
            startActivity(i);

        });

        cardPengeluaran.setOnClickListener(v -> {
            Intent i = new Intent(DashboardActivity.this, PengeluaranActivity.class);
            i.putExtra("name", name);
            i.putExtra("saldo", saldo);
            i.putParcelableArrayListExtra("transaksiList", transaksiList);
            startActivity(i);

        });
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(DashboardActivity.this, LoginActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(logoutIntent);
            finish(); //
        });

    }
}
