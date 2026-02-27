package vn.edu.hcmut.cse.adsoftweng.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.StudentEntity;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    // Spring Data JPA sẽ tự động tạo câu lệnh SQL: SELECT * FROM students WHERE name LIKE %keyword%
    List<StudentEntity> findByNameContainingIgnoreCase(String name);    
}
