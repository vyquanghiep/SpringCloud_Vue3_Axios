package com.example.frontendservice.controller;


import com.example.frontendservice.client.UserClient;


import com.example.frontendservice.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/front")
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/showUser")
    public String ShowUser(Model model, @Param("keyword") String keyword){
        if(keyword!=null) {
            List<UserDto> listUsers = userClient.findUserByKeyword(keyword);
            model.addAttribute("listUsers", listUsers);
        }else {
            List<UserDto> listUsers = userClient.findAllUser();
            model.addAttribute("listUsers", listUsers);
        }
        return "User";
    }
    @GetMapping("/addUser")
    public String AddUser(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user",user);
        return "AddUser";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") UserDto userDto) {
        userClient.saveUser(userDto);
        return "redirect:/front/showUser";

    }
    @GetMapping("/editUser/{id}")
    public String updateUser(@PathVariable (value = "id") int id, Model model){
        UserDto user = userClient.findUserById(id);
        model.addAttribute("user",user);
        return "AddUser";

    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") int id){
        userClient.DeleteUser(id);
        return "redirect:/front/showUser";
    }

}
