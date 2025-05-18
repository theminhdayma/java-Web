package com.data.session10.dao.Bai7;

import com.data.session10.model.Bai7.Document;
import com.data.session10.model.Bai7.Project;
import com.data.session10.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class ProjectDaoImp implements ProjectDao {

    @Override
    public int createProject(Project project) {
        Connection con = null;
        CallableStatement callst = null;
        int projectId = 0;
        try {
            con = ConnectionDB.openConnection();
            callst = con.prepareCall("{call createProject(?, ?, ?)}");
            callst.setString(1, project.getName());
            callst.setString(2, project.getDescription());
            callst.registerOutParameter(3, java.sql.Types.INTEGER);
            callst.executeUpdate();
            projectId = callst.getInt(3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callst);
        }
        return projectId;
    }

    @Override
    public void insertDocument(Document document) {
        Connection con = null;
        CallableStatement callst = null;
        try {
            con = ConnectionDB.openConnection();
            callst = con.prepareCall("{call insertDocument(?, ?)}");
            callst.setInt(1, document.getProjectId());
            callst.setString(2, document.getFilename());
            callst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callst);
        }
    }
}
