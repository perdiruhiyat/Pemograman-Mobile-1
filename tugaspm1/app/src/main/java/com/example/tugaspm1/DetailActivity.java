package com.example.tugaspm1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    ImageView imgHewan;
    TextView txtNama, txtDesc, txtHabitat, txtMakanan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        imgHewan = findViewById(R.id.imgHewan);
        txtNama = findViewById(R.id.txtNamaHewan);
        txtHabitat = findViewById(R.id.txtHabitat);
        txtMakanan = findViewById(R.id.txtMakanan);
        txtDesc = findViewById(R.id.txtDeskripsi);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String makanan = intent.getStringExtra("makanan");
        String habitat = intent.getStringExtra("habitat");
        String deskripsi = intent.getStringExtra("deskripsi");
        int gambar = intent.getIntExtra("gambar", 0);

        txtNama.setText(nama);
        txtMakanan.setText(makanan);
        txtHabitat.setText(habitat);
        txtDesc.setText(deskripsi);
        imgHewan.setImageResource(gambar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}