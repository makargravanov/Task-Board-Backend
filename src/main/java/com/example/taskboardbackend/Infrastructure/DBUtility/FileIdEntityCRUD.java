package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.FileEntity;
import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.FileIdEntity;
import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.FileIdEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FileIdEntityCRUD {
    private final FileIdEntityRepository fileIdEntityRepository;

    public FileIdEntityCRUD(FileIdEntityRepository fileIdEntityRepository) {
        this.fileIdEntityRepository = fileIdEntityRepository;
    }
    public FileIdEntity saveFileIdWithFile(FileEntity fileEntity){
        FileIdEntity fileId = new FileIdEntity();
        fileId.setFileId(fileEntity);
        return fileIdEntityRepository.save(fileId);
    }
}
