package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToStudents() {
        // Tự động chuyển hướng trình duyệt sang URL /students
        return "redirect:/students";
    }
}