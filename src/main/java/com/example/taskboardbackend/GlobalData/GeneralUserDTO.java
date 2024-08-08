package com.example.taskboardbackend.GlobalData;

import java.util.List;

public record GeneralUserDTO(Long id,
                             String firstName,
                             String middleName,
                             String lastName,
                             Boolean gender,
                             String email,
                             String password,
                             int accessLevel,
                             Integer grade,
                             Integer group,
                             boolean isEmailVerified,
                             boolean isTwoFactorAuth,
                             List<ImageIdWithFlag> imageIdSet) {
}
