package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.LocalEntity.FileEntity;
import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.FileEntityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FileEntityCRUD {
    private final FileEntityRepository fileEntityRepository;

    public FileEntityCRUD(FileEntityRepository fileEntityRepository) {
        this.fileEntityRepository = fileEntityRepository;
    }
    public FileEntity saveFile(String path, boolean isStockImage){
        FileEntity image = new FileEntity();
        image.setFilePath(path);
        image.setStockImage(isStockImage);
        image.setCreatedAt(LocalDateTime.now());
        return fileEntityRepository.save(image);
    }
}
