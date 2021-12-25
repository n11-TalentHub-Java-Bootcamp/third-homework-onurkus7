package com.onurkus.springboot.controller;

import com.onurkus.springboot.converter.CategoryConverter;
import com.onurkus.springboot.converter.UserConverter;
import com.onurkus.springboot.dto.CategoryDto;
import com.onurkus.springboot.dto.UserDto;
import com.onurkus.springboot.entity.Category;
import com.onurkus.springboot.entity.User;
import com.onurkus.springboot.service.entityservice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("/get-all-users")
    public List<UserDto> findAll(){
        List<User> userList=userEntityService.findAll();

        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUserListToUserDtoList(userList);

        return userDtoList;
    }

    @GetMapping("/get-username")
    public UserDto findByUsername(@RequestParam("username") String userName){
        User user =userEntityService.findByUserName(userName);

        UserDto userDto = UserConverter.INSTANCE.convertFromUserToUserDto(user);

        return userDto;
    }

    @GetMapping("/get-phone-number")
    public UserDto findByPhoneNumber(@RequestParam("phone") String phoneNumber){
        User user =userEntityService.findByPhoneNumber(phoneNumber);

        UserDto userDto = UserConverter.INSTANCE.convertFromUserToUserDto(user);

        return userDto;
    }

    @PostMapping("/save-user")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){

        User user = UserConverter.INSTANCE.convertFromUserDtoToUser(userDto);
        userEntityService.save(user);

        return ResponseEntity.ok("Successful");
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUserByUserNameAndPhone(@RequestParam("username") String userName, @RequestParam("phone") String phoneNumber){

        String message= userEntityService.deleteUserByUserNameAndPhoneNumber(userName,phoneNumber);

        return ResponseEntity.ok(message);
    }


    @PutMapping("/update-user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        User user = UserConverter.INSTANCE.convertFromUserDtoToUser(userDto);
        userEntityService.save(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
