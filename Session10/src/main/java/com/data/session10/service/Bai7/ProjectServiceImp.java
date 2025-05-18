package com.data.session10.service.Bai7;

import com.data.session10.dao.Bai7.ProjectDao;
import com.data.session10.model.Bai7.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public void createProject(Project project) {
        projectDao.createProject(project);
    }
}
