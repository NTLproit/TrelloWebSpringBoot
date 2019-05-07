package com.ntl.trello.service;

import com.ntl.trello.entity.Project;
import com.ntl.trello.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProjectByUserId(Long users_id) {
        return projectRepository.getAllProjectByUserId(users_id);
    }
}
