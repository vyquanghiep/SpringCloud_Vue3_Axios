package com.example.frontendservice.client;

import com.example.frontendservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping(value = "/user")
    List<UserDto> findAllUser();

    @PostMapping("/user/save")
    void saveUser(UserDto userDto);

    @GetMapping("/user/{id}")
    UserDto findUserById(@PathVariable("id") Integer id);

    @DeleteMapping("/user/{id}")
    void DeleteUser(@PathVariable("id") Integer id);

    @GetMapping("/user/byKeyword")
    List<UserDto>  findUserByKeyword(@RequestParam("keyword") String keyword);
}
