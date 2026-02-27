package vn.edu.hcmut.cse.adsoftweng.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.StudentEntity;
import vn.edu.hcmut.cse.adsoftweng.lab.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<StudentEntity> getAll() {
        return repository.findAll();
    }

    public StudentEntity getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<StudentEntity> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }

    public void save(StudentEntity student) {
        repository.save(student);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
