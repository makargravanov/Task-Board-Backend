package com.example.taskboardbackend.Core;

import com.example.taskboardbackend.Core.Application.LoginUseCase;
import com.example.taskboardbackend.Core.Application.RegisterUseCase;
import com.example.taskboardbackend.GlobalData.LoginUserDTO;
import com.example.taskboardbackend.GlobalData.RegisterBuffer;
import com.example.taskboardbackend.GlobalData.RegisterUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CorePort {
    private final RegisterUseCase registerUseCase;
    private final LoginUseCase loginUseCase;
    private final RegisterBuffer registerBuffer;

    public CorePort(RegisterUseCase registerUseCase, LoginUseCase loginUseCase, RegisterBuffer registerBuffer) {
        this.registerUseCase = registerUseCase;
        this.loginUseCase = loginUseCase;
        this.registerBuffer = registerBuffer;
    }

    public ResponseEntity<?> register(RegisterUserDTO userDTO, MultipartFile image) {
        if (registerBuffer.checkEmail(userDTO.email())) {
            return ResponseEntity.status(409).body("Re-request was rejected, wait for the result of processing the previous one");
        } else {
            registerBuffer.addEmail(userDTO.email());
            ResponseEntity<?> response = registerUseCase.execute(userDTO, image);
            registerBuffer.removeEmail(userDTO.email());
            return response;
        }
    }

    public ResponseEntity<?> login(LoginUserDTO userDTO){
        if(registerBuffer.checkEmail(userDTO.email())){
            return ResponseEntity.status(409).body("Wait for the result of registration");
        } else {
            return loginUseCase.execute(userDTO);
        }
    }

}
