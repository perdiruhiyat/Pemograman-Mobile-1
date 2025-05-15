package com.example.uts_moneytrackerapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_moneytrackerapp.model.Transaksi;

import java.util.ArrayList;
import java.util.Calendar;

public class PengeluaranActivity extends AppCompatActivity {

    EditText inputTanggal, inputJumlah, inputKeterangan;
    Button btnSimpan;
    String name;
    float saldo;
    ArrayList<Transaksi> transaksiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        inputTanggal = findViewById(R.id.inputTanggal);
        inputJumlah = findViewById(R.id.inputJumlah);
        inputKeterangan = findViewById(R.id.inputKeterangan);
        btnSimpan = findViewById(R.id.btnSimpan);

        name = getIntent().getStringExtra("name");
        saldo = getIntent().getFloatExtra("saldo", 0);
        transaksiList = getIntent().getParcelableArrayListExtra("transaksiList");
        if (transaksiList == null) {
            transaksiList = new ArrayList<>();
        }

        inputTanggal.setOnClickListener(v -> showDatePicker());

        btnSimpan.setOnClickListener(v -> {
            String tanggal = inputTanggal.getText().toString();
            String alasan = inputKeterangan.getText().toString();
            float jumlahPengeluaran = Float.parseFloat(inputJumlah.getText().toString());

            saldo -= jumlahPengeluaran;
            Transaksi transaksi = new Transaksi(tanggal, jumlahPengeluaran, alasan, false);
            transaksiList.add(transaksi);

            Intent intent = new Intent(PengeluaranActivity.this, DashboardActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("saldo", saldo);
            intent.putParcelableArrayListExtra("transaksiList", transaksiList);
            startActivity(intent);
            finish();
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int tahun = calendar.get(Calendar.YEAR);
        int bulan = calendar.get(Calendar.MONTH);
        int hari = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (DatePicker view, int year, int month, int dayOfMonth) -> {
                    String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                    inputTanggal.setText(selectedDate);
                }, tahun, bulan, hari);
        datePickerDialog.show();
    }
}
