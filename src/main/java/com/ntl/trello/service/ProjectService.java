package com.ntl.trello.service;

import com.ntl.trello.entity.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectService {
    List<Project> getAllProjectByUserId(int users_id);
}
