package com.data.session10.dao.Bai7;

import com.data.session10.model.Bai7.Document;
import com.data.session10.model.Bai7.Project;

public interface ProjectDao {
    int createProject(Project project);
    void insertDocument(Document document);
}
