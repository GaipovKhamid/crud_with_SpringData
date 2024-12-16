package com.khamid.FirstApi;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private List<UserDTO> userList = new LinkedList<>();

    public UserController() {
        UserDTO dto1 = new UserDTO();
        dto1.setId(UUID.randomUUID().toString());
        dto1.setName("Khamid");
        dto1.setSurname("Gaipov");
        dto1.setCreated_date(LocalDateTime.now());

        UserDTO dto2 = new UserDTO();
        dto2.setId(UUID.randomUUID().toString());
        dto2.setName("Rustam");
        dto2.setSurname("Raimov");
        dto2.setCreated_date(LocalDateTime.now());

        UserDTO dto3 = new UserDTO();
        dto3.setId(UUID.randomUUID().toString());
        dto3.setName("Gulnoza");
        dto3.setSurname("Gaipova");
        dto3.setCreated_date(LocalDateTime.now());

        userList.add(dto1);
        userList.add(dto2);
        userList.add(dto3);
    }

    @RequestMapping("/all")
    public List<UserDTO> getAll() {
        return userList;
    }

    @RequestMapping("/byid/{id}")
    public UserDTO getById(@PathVariable("id") String id) {
        for (UserDTO dto : userList) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }
        return null;
    }

    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        userDTO.setId(UUID.randomUUID().toString());
        userList.add(userDTO);
        return userDTO;
    }

    
    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") String id, @RequestBody UserDTO userDTO) {
        for (UserDTO exist : userList) {
            if (exist.getId().equals(id)) {
                exist.setName(userDTO.getName());
                exist.setSurname(userDTO.getSurname());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        for (UserDTO dto : userList) {
            if (dto.getId().equals(id)) {
                userList.remove(dto);
                return true;
            }
        }
        return false;
    }
}
