package com.example.taskboardbackend.Infrastructure;

import com.example.taskboardbackend.GlobalData.GeneralUserDTO;
import com.example.taskboardbackend.GlobalData.LoginUserDTO;
import com.example.taskboardbackend.GlobalData.RegisterUserDTO;
import com.example.taskboardbackend.Infrastructure.DBUtility.DBMapper.UserEntityMapper;
import com.example.taskboardbackend.Infrastructure.DBUtility.UserCRUD;
import com.example.taskboardbackend.Infrastructure.MemoryUtility.GetFileFromMemoryCase;
import com.example.taskboardbackend.Infrastructure.MemoryUtility.SaveImageInMemoryCase;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class InfraPort {
    private final GetFileFromMemoryCase getFileFromMemoryCase;
    private final SaveImageInMemoryCase saveImageInMemoryCase;
    private final UserEntityMapper mapper;
    private final UserCRUD userCRUD;

    public InfraPort(GetFileFromMemoryCase getFileFromMemoryCase, SaveImageInMemoryCase saveImageInMemoryCase, UserEntityMapper mapper, UserCRUD userCRUD) {
        this.getFileFromMemoryCase = getFileFromMemoryCase;
        this.saveImageInMemoryCase = saveImageInMemoryCase;
        this.mapper = mapper;
        this.userCRUD = userCRUD;
    }

    public byte[] getStockImage(int i) {
        return getFileFromMemoryCase.execute(i);
    }

    public boolean isUserExists(String email) {
        return userCRUD.isUserExistsByEmail(email);
    }
    public Long createUser(RegisterUserDTO userDTO){
        return userCRUD.createNewUser(mapper.registerDTOtoEntity(userDTO));
    }
    public GeneralUserDTO getUserByEmail(String email){
        return mapper.EntityToGeneralUserDTO(userCRUD.getUserByEmail(email));
    }
    public String saveImageWithUserId(BufferedImage img, Long id, boolean isStock){
        String path = saveImageInMemoryCase.execute(img,id);
        userCRUD.addImageToUser(path,id,isStock);
        return path;
    }
}
