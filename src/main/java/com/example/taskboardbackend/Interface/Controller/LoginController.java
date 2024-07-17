package com.example.taskboardbackend.Interface.Controller;
import com.example.taskboardbackend.Core.CorePort;
import com.example.taskboardbackend.DTO.LoginUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final CorePort corePort;
    public LoginController(CorePort corePort) {
        this.corePort = corePort;
    }

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO userDTO) {
        return "login";
        //TODO
    }
}
