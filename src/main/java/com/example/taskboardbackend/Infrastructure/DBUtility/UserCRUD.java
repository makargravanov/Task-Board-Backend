package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.FileIdEntity;
import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.UserEntity;
import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserCRUD {
    private final UserRepository userRepository;
    private final FileEntityCRUD fileEntityCRUD;
    private final FileIdEntityCRUD fileIdEntityCRUD;

    public UserCRUD(UserRepository userRepository, FileEntityCRUD fileEntityCRUD, FileIdEntityCRUD fileIdEntityCRUD) {
        this.userRepository = userRepository;
        this.fileEntityCRUD = fileEntityCRUD;
        this.fileIdEntityCRUD = fileIdEntityCRUD;
    }

    public UserEntity getUserByEmail(String email) throws NullPointerException {
        Optional<UserEntity> optional = userRepository.findByEmail(email);
        if (optional.isEmpty()) {
            throw new NullPointerException();
        } else {
            return optional.get();
        }
    }

    public boolean isUserExistsByEmail(String email) {
        try {
            return getUserByEmail(email) != null;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public Long createNewUser(UserEntity user) {
        return userRepository.save(user).getId();
    }

    public void addImageToUser(String path, Long id, boolean isStockImage) {
        Optional<UserEntity> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NullPointerException();
        }
        UserEntity user = optional.get();
        Set<FileIdEntity> set = user.getImageIdSet();
        set.add(fileIdEntityCRUD
                .saveFileIdWithFile(fileEntityCRUD
                        .saveFile(path, isStockImage)));
        user.setImageIdSet(set);
        userRepository.save(user);
    }
}
