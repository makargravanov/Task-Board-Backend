package com.example.taskboardbackend.Infrastructure.DBUtility;

import com.example.taskboardbackend.Infrastructure.DBUtility.Repository.StateRepository;
import org.springframework.stereotype.Service;

@Service
public class StateCRUD {
    private final StateRepository stateRepository;

    public StateCRUD(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }
}
