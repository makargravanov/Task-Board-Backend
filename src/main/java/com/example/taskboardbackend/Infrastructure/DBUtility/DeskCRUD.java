package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.DeskRepository;
import org.springframework.stereotype.Service;

@Service
public class DeskCRUD {
    private final DeskRepository deskRepository;

    public DeskCRUD(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }
}
