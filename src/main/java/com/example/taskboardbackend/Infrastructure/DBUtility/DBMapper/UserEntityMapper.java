package com.example.taskboardbackend.Infrastructure.DBUtility.DBMapper;

import com.example.taskboardbackend.GlobalData.GeneralUserDTO;
import com.example.taskboardbackend.GlobalData.ImageIdWithFlag;
import com.example.taskboardbackend.GlobalData.LoginUserDTO;
import com.example.taskboardbackend.GlobalData.RegisterUserDTO;
import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.FileEntity;
import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.FileIdEntity;
import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserEntityMapper {

    public UserEntity registerDTOtoEntity(RegisterUserDTO dto) {
        UserEntity user = new UserEntity();
        user.setFirstName(dto.firstName());
        user.setMiddleName(dto.middleName());
        user.setLastName(dto.lastName());
        user.setGender(dto.gender());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setAccessLevel(0);
        user.setGrade(dto.grade());
        user.setGroup(dto.group());
        user.setEmailVerified(false);
        user.setTwoFactorAuth(false);
        user.setCreatedAt(LocalDateTime.now());
        user.setImageIdSet(new HashSet<>());
        return user;
    }

    public LoginUserDTO EntityToLoginDTO(UserEntity user) {
        return new LoginUserDTO(user.getEmail(), user.getPassword());
    }

    public GeneralUserDTO EntityToGeneralUserDTO(UserEntity user) {
        return new GeneralUserDTO(
                user.getId(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.isGender(),
                user.getEmail(),
                user.getPassword(),
                user.getAccessLevel(),
                user.getGrade(),
                user.getGroup(),
                user.isEmailVerified(),
                user.isTwoFactorAuth(),
                getIds(user.getImageIdSet()));
    }

    private List<ImageIdWithFlag> getIds(Set<FileIdEntity> set) {
        return set.stream()
                .map(FileIdEntity::getFileId)
                .sorted(Comparator.comparing(FileEntity::getCreatedAt))
                .skip(set.size() > 1 ? 1 : 0)
                .map(UserEntityMapper::apply)
                .toList();
    }

    private static ImageIdWithFlag apply(FileEntity fileEntity) {
        return new ImageIdWithFlag(fileEntity.getId(), fileEntity.isStockImage());
    }
}
