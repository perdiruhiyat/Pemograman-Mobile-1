package com.example.uts_moneytrackerapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaksi implements Parcelable {
    private String tanggal;
    private float jumlah;
    private String keterangan;
    private boolean isPemasukan;

    public Transaksi(String tanggal, float jumlah, String keterangan, boolean isPemasukan) {
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.isPemasukan = isPemasukan;
    }

    protected Transaksi(Parcel in) {
        tanggal = in.readString();
        jumlah = in.readFloat();
        keterangan = in.readString();
        isPemasukan = in.readByte() != 0;
    }

    public static final Creator<Transaksi> CREATOR = new Creator<Transaksi>() {
        @Override
        public Transaksi createFromParcel(Parcel in) {
            return new Transaksi(in);
        }

        @Override
        public Transaksi[] newArray(int size) {
            return new Transaksi[size];
        }
    };

    public String getTanggal() {
        return tanggal;
    }

    public float getJumlah() {
        return jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public boolean isPemasukan() {
        return isPemasukan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(tanggal);
        parcel.writeFloat(jumlah);
        parcel.writeString(keterangan);
        parcel.writeByte((byte) (isPemasukan ? 1 : 0));
    }
}
