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

    EditText inputTanggal, inputJumlah, inputAlasan;
    Button btnSimpan;
    String namaUser;
    int saldo;
    ArrayList<Transaksi> transaksiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);

        inputTanggal = findViewById(R.id.inputTanggal);
        inputJumlah = findViewById(R.id.inputJumlah);
        inputAlasan = findViewById(R.id.inputAlasan);
        btnSimpan = findViewById(R.id.btnSimpan);

        namaUser = getIntent().getStringExtra("username");
        saldo = getIntent().getIntExtra("saldo", 0);
        transaksiList = getIntent().getParcelableArrayListExtra("transaksiList");
        if (transaksiList == null) {
            transaksiList = new ArrayList<>();
        }

        inputTanggal.setOnClickListener(v -> showDatePicker());

        btnSimpan.setOnClickListener(v -> {
            String tanggal = inputTanggal.getText().toString();
            String alasan = inputAlasan.getText().toString();
            int jumlahPengeluaran = Integer.parseInt(inputJumlah.getText().toString());

            // Kurangi saldo dan simpan transaksi
            saldo -= jumlahPengeluaran;
            Transaksi transaksi = new Transaksi(tanggal, jumlahPengeluaran, alasan, false);
            transaksiList.add(transaksi);

            // Kembali ke dashboard
            Intent intent = new Intent(PengeluaranActivity.this, DashboardActivity.class);
            intent.putExtra("username", namaUser);
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
