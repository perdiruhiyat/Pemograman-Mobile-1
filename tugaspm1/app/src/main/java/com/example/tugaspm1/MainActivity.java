package com.example.tugaspm1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton imgKucing, imgKuda, imgCapybara, imgMonyet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imgKucing = findViewById(R.id.imgKucing);
        imgKucing.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("nama", "Kucing");
            intent.putExtra("makanan", "Karnivora");
            intent.putExtra("habitat", "Hutan, Lingkungan Manusia");
            intent.putExtra("deskripsi", "Kucing adalah hewan mamalia karnivora dari keluarga Felidae yang dikenal sebagai hewan peliharaan populer. Kucing memiliki tubuh ramping, " +
                    "cakar tajam, dan gigi yang tajam untuk berburu. Mereka dikenal karena kelincahan, keunikan, dan kemampuan beradaptasi. ");
            intent.putExtra("gambar", R.drawable.kucing);
            startActivity(intent);
        });

        imgMonyet = findViewById(R.id.imgMonyet);
        imgMonyet.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("nama", "Monyet");
            intent.putExtra("makanan", "Omnivora");
            intent.putExtra("habitat", "Hutan, Lingkungan Manusia");
            intent.putExtra("deskripsi", "Monyet atau wanara adalah istilah untuk semua anggota primata yang bukan prosimia (\"pra-kera\", seperti lemur dan tarsius) atau kera, " +
                    "baik yang tinggal di Dunia Lama maupun Dunia Baru. Hingga saat ini dikenal 264 jenis monyet yang hidup di dunia. Tidak seperti kera, monyet biasanya berekor dan berukuran lebih kecil. " +
                    "Monyet diketahui dapat belajar dan menggunakan alat untuk membantunya dalam mendapatkan makanan..");
            intent.putExtra("gambar", R.drawable.monyet);
            startActivity(intent);
        });

        imgCapybara = findViewById(R.id.imgCapybara);
        imgCapybara.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("nama", "Capybara");
            intent.putExtra("makanan", "Herbivora");
            intent.putExtra("habitat", "Tepi Danau, Sungai, atau Rawa yang dekat dengan perairan");
            intent.putExtra("deskripsi", "Capybara adalah hewan pengerat terbesar di dunia, dengan berat yang bisa mencapai 60 kilogram atau lebih. Mereka hidup berkelompok di dekat" +
                    " sumber air seperti sungai, danau, atau rawa-rawa di Amerika Selatan. Capybara adalah hewan semi-akuatik, yang berarti mereka menghabiskan banyak waktu di dalam air untuk " +
                    "mendinginkan tubuh dan menghindari predator..");
            intent.putExtra("gambar", R.drawable.capybara);
            startActivity(intent);
        });

        imgKuda = findViewById(R.id.imgKuda);
        imgKuda.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("nama", "Kuda");
            intent.putExtra("makanan", "Herbivora");
            intent.putExtra("habitat", "Stepa, Padang Rumput");
            intent.putExtra("deskripsi", "Kuda (Equus caballus atau Equus ferus caballus) merupakan salah satu jenis ternak yang memiliki lambung tunggal. Kuda memiliki banyak manfaat " +
                    "ekonomis dan selama ribuan tahun digunakan manusia sebagai alat transportasi dan simbol status sosial kebudayaan tertentu serta hewan kesayangan.");
            intent.putExtra("gambar", R.drawable.kuda);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}