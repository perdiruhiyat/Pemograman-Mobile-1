package com.example.uts_moneytrackerapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_moneytrackerapp.model.Transaksi;

import java.util.ArrayList;
import java.util.Calendar;

public class PemasukanActivity extends AppCompatActivity {

    EditText inputTanggal, inputJumlah, inputSumber;
    Button btnSimpan;
    String name;
    float saldo;
    ArrayList<Transaksi> transaksiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        inputTanggal = findViewById(R.id.inputTanggal);
        inputJumlah = findViewById(R.id.inputJumlah);
        inputSumber = findViewById(R.id.inputSumber);
        btnSimpan = findViewById(R.id.btnSimpan);

        name = getIntent().getStringExtra("name");
        saldo = getIntent().getFloatExtra("saldo", 0);
        transaksiList = getIntent().getParcelableArrayListExtra("transaksiList");
        if (transaksiList == null) transaksiList = new ArrayList<>();

        // Set DatePicker ketika inputTanggal diklik
        inputTanggal.setOnClickListener(v -> showDatePicker());

        btnSimpan.setOnClickListener(v -> {
            float uangMasuk = Float.parseFloat(inputJumlah.getText().toString());
            String tanggal = inputTanggal.getText().toString();
            String sumber = inputSumber.getText().toString();

            // Tambah saldo dan simpan transaksi
            saldo += uangMasuk;
            transaksiList.add(new Transaksi(tanggal, uangMasuk, sumber, true));

            // Kembali ke dashboard dengan data baru
            Intent intent = new Intent(PemasukanActivity.this, DashboardActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("saldo", saldo);
            intent.putParcelableArrayListExtra("transaksiList", transaksiList);
            startActivity(intent);
            finish();
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    // Format: DD/MM/YYYY
                    String formattedDate = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear);
                    inputTanggal.setText(formattedDate);
                },
                year, month, day
        );
        datePickerDialog.show();
    }
}
