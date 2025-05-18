package com.data.session10.controller.Bai7;

import com.data.session10.dao.Bai7.ProjectDao;
import com.data.session10.model.Bai7.Document;
import com.data.session10.model.Bai7.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private ProjectDao projectDao;

    @GetMapping("/projectForm")
    public String showForm(Model model) {
        model.addAttribute("project", new Project());
        return "Bai7/projectForm";
    }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute("project") Project project, Model model) {
        int projectId = projectDao.createProject(project);

        String uploadDir = servletContext.getRealPath("/project_docs/");
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        List<MultipartFile> files = project.getDocuments();
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String fileName = file.getOriginalFilename();
                    file.transferTo(new File(uploadDir + fileName));
                    fileNames.add(fileName);

                    Document doc = new Document();
                    doc.setProjectId(projectId);
                    doc.setFilename(fileName);
                    projectDao.insertDocument(doc);

                } catch (IOException e) {
                    model.addAttribute("message", "Lỗi khi upload file: " + e.getMessage());
                    return "Bai7/projectResult";
                }
            }
        }

        model.addAttribute("message", "Tạo dự án thành công!");
        model.addAttribute("name", project.getName());
        model.addAttribute("description", project.getDescription());
        model.addAttribute("files", fileNames);
        System.out.println("files: " + fileNames);

        return "Bai7/projectResult";
    }
}
