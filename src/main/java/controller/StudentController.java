package controller;

import com.khamid.first_data.dto.StudentDTO;
import com.khamid.first_data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    private ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        StudentDTO result = studentService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    private ResponseEntity<List<StudentDTO>> all() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/byId/{id}")
    private ResponseEntity<StudentDTO> byId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @RequestBody StudentDTO dto) {
        StudentDTO result = studentService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<StudentDTO> delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    private ResponseEntity<StudentDTO> deleteALl() {
        studentService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byName/{name}")
    private ResponseEntity<List<StudentDTO>> byName(@PathVariable("name") String name) {
        return ResponseEntity.ok(studentService.getByName(name));
    }

    @GetMapping("/bySurname/{surname}")
    private ResponseEntity<List<StudentDTO>> bySurname(@PathVariable("surname") String surname) {
        return ResponseEntity.ok(studentService.getBySurname(surname));
    }


}
