package com.example.taskboardbackend.Core.Application;

import com.example.taskboardbackend.Core.Domain.CustomJWT.JWTGenerator;
import com.example.taskboardbackend.GlobalData.GeneralUserDTO;
import com.example.taskboardbackend.GlobalData.LoginUserDTO;
import com.example.taskboardbackend.Infrastructure.InfraPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {
    private final InfraPort infraPort;
    private final JWTGenerator generator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginUseCase(InfraPort infraPort, JWTGenerator generator, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.infraPort = infraPort;
        this.generator = generator;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseEntity<?> execute(LoginUserDTO user) {
        if (!infraPort.isUserExists(user.email())) {
            return ResponseEntity.status(409).body("Password or email is not correct");
        }
        GeneralUserDTO generalUserDTO = infraPort.getUserByEmail(user.email());
        if(!bCryptPasswordEncoder.matches(user.password(), generalUserDTO.password())){
            return ResponseEntity.status(409).body("Password or email is not correct");
        }
        if(generalUserDTO.isEmailVerified()){
            if(generalUserDTO.isTwoFactorAuth()){
                //TODO
            }
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, produceJwtCookie(generalUserDTO.id()))
                    .build();
        }else {
            //TODO
        }

    }

    private String produceJwtCookie(Long userId){
        return ResponseCookie.from("jwtToken")
                .value(generator.generate(userId))
                .httpOnly(true)
                .build()
                .toString();
    }
}
