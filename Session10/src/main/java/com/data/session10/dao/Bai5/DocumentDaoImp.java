package com.data.session10.dao.Bai5;

import com.data.session10.model.Bai5.Document;
import com.data.session10.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class DocumentDaoImp implements DocumentDao {
    @Override
    public void save(Document document) {
        Connection con = null;
        CallableStatement callst = null;
        try {
            con = ConnectionDB.openConnection();
            callst = con.prepareCall("{call uploadDocument(?, ?, ?)}");
            callst.setString(1, document.getTitle());
            callst.setString(2, document.getDescription());
            callst.setString(3, String.valueOf(document.getFileName()));
            callst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callst);
        }
    }
}
