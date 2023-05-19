package com.oauth2.authorizationserver.controller;

import com.oauth2.authorizationserver.dto.CreateAppUserDto;
import com.oauth2.authorizationserver.dto.MessageDto;
import com.oauth2.authorizationserver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;
    @PostMapping("/sla")
    public ResponseEntity<MessageDto> createUser(@RequestBody CreateAppUserDto dto){
        System.out.println("Hola");
        return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
    }

    @GetMapping("/slas")
    public  String mess(){
        System.out.println("Holass");
        return "save";
    }
}
