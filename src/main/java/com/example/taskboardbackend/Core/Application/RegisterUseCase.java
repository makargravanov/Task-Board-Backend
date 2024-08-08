package com.example.taskboardbackend.Core.Application;

import com.example.taskboardbackend.Core.Domain.EmailUtility.IsValidEmailUseCase;
import com.example.taskboardbackend.Core.Domain.StockImageCreation.CreateStockImageUseCase;
import com.example.taskboardbackend.GlobalData.RegisterUserDTO;
import com.example.taskboardbackend.Infrastructure.InfraPort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Service
public class RegisterUseCase {
    private final InfraPort infraPort;
    private final IsValidEmailUseCase isValid;
    private final CreateStockImageUseCase createImg;
    private final BCryptPasswordEncoder encoder;

    public RegisterUseCase(InfraPort infraPort, IsValidEmailUseCase isValid, CreateStockImageUseCase createImg, BCryptPasswordEncoder encoder) {
        this.infraPort = infraPort;
        this.isValid = isValid;
        this.createImg = createImg;
        this.encoder = encoder;
    }

    public ResponseEntity<?> execute(RegisterUserDTO userDTO, MultipartFile image) {
        var isDtoValid = switch (checkFields(userDTO)) {
            case ALL_VALID -> true;
            case INVALID_PASSWORD -> "Password is invalid";
            case INVALID_EMAIL -> "Email is invalid";
            case INVALID_FIRST_NAME -> "First name is invalid";
            case INVALID_MIDDLE_NAME -> "Middle name is invalid";
            case INVALID_LAST_NAME -> "Last name is invalid";
            case INVALID_GENDER -> "Gender is invalid";
            case INVALID_GRADE -> "Grade is invalid";
            case INVALID_GROUP -> "Group number is invalid";
        };
        if (!isDtoValid.equals(true)) {
            return ResponseEntity.badRequest().body(isDtoValid);
        }
        if (infraPort.isUserExists(userDTO.email())) {
            return ResponseEntity.status(409).body("An account with this email already exists");
        }
        BufferedImage newImage;
        BufferedImage stockImage = createImg.execute(userDTO.email());
        switch (checkImageValid(image)) {
            case ALL_VALID -> {try {
                newImage = ImageIO.read(image.getInputStream());
                Long userId = infraPort.createUser(getUserDtoWithEncodedPassword(userDTO));
                infraPort.saveImageWithUserId(stockImage,userId,true);
                infraPort.saveImageWithUserId(newImage,userId,false);
                return ResponseEntity.ok().body("Success");
            } catch (IOException | NullPointerException e) {
                return ResponseEntity.status(500).body("InternalError");
            }}
            case NULL_IMAGE -> {try {
                Long userId = infraPort.createUser(getUserDtoWithEncodedPassword(userDTO));
                infraPort.saveImageWithUserId(stockImage,userId,true);
                return ResponseEntity.ok().body("Success");
            }catch (RuntimeException e) {
                return ResponseEntity.status(500).body("InternalError");
            }}
            case NOT_JPEG -> {return ResponseEntity.badRequest().body("Image file must be JPEG");}
            case INCOMPATIBLE_SIZE -> {return ResponseEntity.badRequest().body("Incompatible size: 150*150min, 5000*5000max, from 16:9 to 9:16");}
            case UNEXPECTED_ERROR -> {return ResponseEntity.status(500).body("Internal error");}
        }
        return ResponseEntity.status(500).body("Internal Error");
    }
    private RegisterUserDTO getUserDtoWithEncodedPassword(RegisterUserDTO userDTO){
        return new RegisterUserDTO(userDTO.firstName(),
                userDTO.middleName(),
                userDTO.lastName(),
                userDTO.gender(),
                userDTO.grade(),
                userDTO.group(),
                userDTO.email(),
                encoder.encode(userDTO.password()));
    }
    private ImageStates checkImageValid(MultipartFile image) {
        try {
            if (image == null) {
                return ImageStates.NULL_IMAGE;
            } else if (!Objects.equals(image.getContentType(), "image/jpeg")) {
                return ImageStates.NOT_JPEG;
            } else {
                BufferedImage img = ImageIO.read(image.getInputStream());

                float width = img.getWidth();
                float height = img.getHeight();
                if (width < 150 || height < 150 || width > 5000 || height > 5000) {
                    return ImageStates.INCOMPATIBLE_SIZE;
                }
                boolean condition1 = (width / height) > (16f / 9f);
                boolean condition2 = (width / height) < (9f / 16f);
                if (condition1 || condition2) {
                    return ImageStates.INCOMPATIBLE_SIZE;
                }
                return ImageStates.ALL_VALID;
            }
        } catch (IOException e) {
            return ImageStates.UNEXPECTED_ERROR;
        }
    }

    private FieldStates checkFields(RegisterUserDTO userDTO) {
        if (userDTO.password() == null || userDTO.password().length() < 8 || userDTO.password().length() > 40) {
            return FieldStates.INVALID_PASSWORD;
        } else if (userDTO.email() == null || isValid.execute(userDTO.email())) {
            return FieldStates.INVALID_EMAIL;
        } else if (userDTO.firstName() == null || userDTO.firstName().isEmpty() || userDTO.firstName().length() > 50) {
            return FieldStates.INVALID_FIRST_NAME;
        } else if (userDTO.middleName() == null || userDTO.middleName().isEmpty() || userDTO.middleName().length() > 50) {
            return FieldStates.INVALID_MIDDLE_NAME;
        } else if (userDTO.lastName() == null || userDTO.lastName().isEmpty() || userDTO.lastName().length() > 50) {
            return FieldStates.INVALID_LAST_NAME;
        } else if (userDTO.gender() == null) {
            return FieldStates.INVALID_GENDER;
        } else if (userDTO.grade() == null || userDTO.grade() < 1 || userDTO.grade() > 5) {
            return FieldStates.INVALID_GRADE;
        } else if (userDTO.group() == null || userDTO.group() < 1 || userDTO.group() > 10000) {
            return FieldStates.INVALID_GROUP;
        } else {
            return FieldStates.ALL_VALID;
        }
    }

    private static enum ImageStates {
        NULL_IMAGE,
        NOT_JPEG,
        INCOMPATIBLE_SIZE,
        UNEXPECTED_ERROR,
        ALL_VALID
    }

    private static enum FieldStates {
        INVALID_PASSWORD,
        INVALID_EMAIL,
        INVALID_FIRST_NAME,
        INVALID_MIDDLE_NAME,
        INVALID_LAST_NAME,
        INVALID_GENDER,
        INVALID_GRADE,
        INVALID_GROUP,
        ALL_VALID
    }
}
