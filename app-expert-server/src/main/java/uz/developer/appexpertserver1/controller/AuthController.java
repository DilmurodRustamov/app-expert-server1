package uz.developer.appexpertserver1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;
import uz.developer.appexpertserver1.payload.ApiResponse;
import uz.developer.appexpertserver1.payload.ReqLogin;
import uz.developer.appexpertserver1.payload.ReqUser;
import uz.developer.appexpertserver1.security.JwtProvider;
import uz.developer.appexpertserver1.service.AuthService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public HttpEntity<?> register(@Valid @RequestBody ReqUser reqUser){
        ApiResponse apiResponse = authService.register(reqUser);
        return ResponseEntity.status(apiResponse.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(apiResponse );
    }

//    @PostMapping("/login")
//    public HttpEntity<?> login(@RequestBody ReqLogin reqLogin){
//
//    }
}
