package com.tugas.deploy.model;

public class User {
    private String nama;
    private String nim;
    private String gender;

    // Constructor Kosong
    public User() {}

    // Constructor dengan Parameter
    public User(String nama, String nim, String gender) {
        this.nama = nama;
        this.nim = nim;
        this.gender = gender;
    }

    // Getter dan Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}