package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired
    private StudentService service;

    // 1.1 TRANG DANH SÁCH
    @GetMapping
    public String getAllStudents(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<StudentEntity> students = (keyword != null) ? service.searchByName(keyword) : service.getAll();
        model.addAttribute("dsSinhVien", students);
        model.addAttribute("keyword", keyword);
        return "students"; // students.html
    }

    // 1.2 TRANG CHI TIẾT
    @GetMapping("/{id}")
    public String getStudentDetail(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "student-detail"; // student-detail.html
    }

    // 1.3 CHỨC NĂNG THÊM MỚI (Hiển thị Form)
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new StudentEntity());
        return "student-form"; // student-form.html
    }

    // 1.3 CHỨC NĂNG CHỈNH SỬA (Hiển thị Form với dữ liệu cũ)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "student-form"; 
    }

    // LƯU DỮ LIỆU (Dùng chung cho cả Thêm và Sửa)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") StudentEntity student) {
        service.save(student); 
        return "redirect:/students";
    }

    // XÓA SINH VIÊN
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteById(id); 
        return "redirect:/students";
    }
}