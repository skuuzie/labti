/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deeon_labti.parkiran.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author hyun
 */
@Entity
@Table(name = "parkiran")
public class ModelParkiran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "plat_nomor", nullable = false, length = 8)
    private String platNomor;
    
    @Column(name = "waktu_masuk", nullable = false, length = 8)
    private LocalDateTime waktuMasuk;
    
    @Column(name = "jenis_kendaraan", nullable = false, length = 8)
    private int jenisKendaraan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public LocalDateTime getWaktuMasuk() {
        return waktuMasuk;
    }

    public void setWaktuMasuk(LocalDateTime waktuMasuk) {
        this.waktuMasuk = waktuMasuk;
    }

    public int getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(int jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
    
    public String getJenisKendaraanStr() {
        return switch (this.jenisKendaraan) {
            case 1 -> "Motor";
            case 2 -> "Mobil";
            default -> "???";
        };
    }
    
    @Override
    public String toString() {
        return "[" + this.getJenisKendaraanStr() + "] " + this.platNomor + " - " + this.waktuMasuk.toString();
    }
    
    public ModelParkiran() {}

    public ModelParkiran(String platNomor, LocalDateTime waktuMasuk, int jenisKendaraan) {
        this.platNomor = platNomor;
        this.waktuMasuk = waktuMasuk;
        this.jenisKendaraan = jenisKendaraan;
    }
}
