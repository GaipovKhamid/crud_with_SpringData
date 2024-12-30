package service;

import com.khamid.first_data.dto.StudentDTO;
import com.khamid.first_data.entity.StudentEntity;
import com.khamid.first_data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //create
    public StudentDTO create(StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());

        studentRepository.save(studentEntity); //

        studentDTO.setId(studentEntity.getId());
        return studentDTO;
    }

    //get all list
    public List<StudentDTO> getAll() {
        Iterable<StudentEntity> interator = studentRepository.findAll(); //iterable = for each da aylantirish uchun royihatni retunr qiladi
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : interator) {
            list.add(toDto(entity));
        }
        return list;
    }

    //get students by their ids
    public StudentDTO getById(Integer id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        StudentEntity entity = optional.get();
        return toDto(entity);
    }

    //update method
    public StudentDTO update(Integer id, StudentDTO dto) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        StudentEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        studentRepository.save(entity);

        return dto;
    }

    //delete
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public List<StudentDTO> getByName(String name) {
        List<StudentEntity> Entitylist = studentRepository.getByName(name);
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : Entitylist) {
            list.add(toDto(entity));
        }
        return list;
    }

    public List<StudentDTO> getBySurname(String surname) {
        List<StudentEntity> Entitylist = studentRepository.getBySurname(surname);
        List<StudentDTO> list = new LinkedList<>();
        for (StudentEntity entity : Entitylist) {
            list.add(toDto(entity));
        }
        return list;
    }

    // for usage
    public StudentDTO toDto(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        return dto;
    }
}