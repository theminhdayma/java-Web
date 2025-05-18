package com.data.session10.dao.Bai6;

import com.data.session10.model.Bai6.UploadFile;
import com.data.session10.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class UploadDaoImp implements UploadDao {
    @Override
    public void save(UploadFile uploadFile) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call uploadFile(?, ?)}");
            callSt.setString(1, String.valueOf(uploadFile.getFile()));
            callSt.setString(2, uploadFile.getDescription());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}
