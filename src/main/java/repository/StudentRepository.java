package repository;

import com.khamid.first_data.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    List<entity.StudentEntity> getByName(String name);
    List<StudentEntity> getBySurname(String surname);
}