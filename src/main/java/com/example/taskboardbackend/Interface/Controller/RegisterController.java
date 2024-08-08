package com.example.taskboardbackend.Interface.Controller;
import com.example.taskboardbackend.Core.CorePort;
import com.example.taskboardbackend.GlobalData.RegisterUserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final CorePort corePort;

    public RegisterController(CorePort corePort) {
        this.corePort = corePort;
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> register(@ModelAttribute RegisterUserDTO user,
                                      @RequestParam(value = "image", required = false) MultipartFile userImage){
        return corePort.register(user, userImage);
    }
}
