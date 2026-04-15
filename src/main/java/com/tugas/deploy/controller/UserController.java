package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // List statis untuk menyimpan data sementara selama aplikasi berjalan
    private static List<User> daftarMahasiswa = new ArrayList<>();

    // 1. Mapping untuk halaman Login (Root URL)
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    // 2. Logic untuk memproses Login
    @PostMapping("/login-process")
    public String loginProcess(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        // Verifikasi: Username 'admin' dan Password '20230140245'
        if ("admin".equals(username) && "20230140245".equals(password)) {
            return "redirect:/home";
        } else {
            // Jika salah, kembali ke login dengan pesan error
            model.addAttribute("error", "Username atau Password salah!");
            return "login";
        }
    }

    // 3. Mapping untuk halaman Home (Menampilkan Tabel)
    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("listMhs", daftarMahasiswa);
        return "home";
    }

    // 4. Mapping untuk menampilkan Form Input
    @GetMapping("/form")
    public String showFormPage(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    // 5. Mapping untuk memproses input data mahasiswa
    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") User user) {
        daftarMahasiswa.add(user); // Simpan ke list temporary
        return "redirect:/home";   // Setelah simpan, balik ke home
    }

    // 6. Logic untuk Logout (Kembali ke Login)
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}