/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deeon_labti.view;

import com.deeon_labti.controller.MahasiswaController;
import com.deeon_labti.model.MahasiswaDAO;
import java.util.Scanner;

/**
 *
 * @author hyun
 */
public class MahasiswaView {
    public static void main(String[] args) {
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDAO);
        
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
         while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Tampilkan seluruh mhs");
            System.out.println("2. Tambahkan mhs");
            System.out.println("3. Update mhs");
            System.out.println("4. Hapus mhs");
            System.out.println("5. Cek Koneksi");
            System.out.println("6. Keluar");
            System.out.print("PILIH OPSI: ");

            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1 -> // Case 1: Display all students
                    mahasiswaController.displayAllMahasiswa();

                case 2 -> {
                    // Case 2: Add a new student
                    System.out.println("Masukkan NPM: ");
                    String npm = scanner.next();
                    scanner.nextLine();
                    
                    System.out.println("Masukkan Nama: ");
                    String nama = scanner.next();
                    scanner.nextLine();
                    
                    System.out.println("Masukkan Semester: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Masukkan IPK: ");
                    float ipk = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.println(npm + " " + nama + " " + semester + " " + ipk);
                    mahasiswaController.addMahasiswa(npm, nama, semester, ipk);
                }

                case 3 -> {
                    // Case 3: Update a student’s details
                    System.out.print("Masukkan ID mahasiswa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear newline

                    System.out.println("Masukkan NPM: ");
                    String npmBaru = scanner.next();
                    System.out.println("Masukkan Nama: ");
                    String namaBaru = scanner.next();
                    System.out.println("Masukkan Semester: ");
                    int semesterBaru = scanner.nextInt();
                    System.out.println("Masukkan IPK: ");
                    float ipkBaru = scanner.nextFloat();

                    System.out.println(npmBaru + " " + namaBaru + " " + semesterBaru + " " + ipkBaru);
                    mahasiswaController.updateMahasiswa(id, npmBaru, namaBaru, semesterBaru, ipkBaru);
                }

                case 4 -> {
                    // Case 4: Delete a student by ID
                    System.out.print("Masukkan ID mahasiswa: ");
                    int idHapus = scanner.nextInt();
                    mahasiswaController.deleteMahasiswa(idHapus);
                    break;
                }

                case 5 -> { // Case 5: Check the database connection
                    mahasiswaController.checkDatabaseConnection();
                    break;
                }
                
                case 6 -> {
                    // Case 6: Close the connection and exit
                    mahasiswaController.closeConnection();
                    System.out.println("Program Selesai");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Input tidak valid.");
            }
         }
    }
}
