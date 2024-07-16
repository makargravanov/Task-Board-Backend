package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.SpaceRepository;
import org.springframework.stereotype.Service;

@Service
public class SpaceCRUD {
    private final SpaceRepository spaceRepository;
    public SpaceCRUD(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }
}
