package com.data.session10.dao.Bai3;

import com.data.session10.model.Bai3.Account;
import com.data.session10.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class AccountDaoImp implements AccountDao {
    @Override
    public void save(Account account) {
        Connection con = null;
        CallableStatement callst = null;
        try {
            con = ConnectionDB.openConnection();
            callst = con.prepareCall("{call register(?, ?, ?)}");
            callst.setString(1, account.getUsername());
            callst.setString(2, account.getPassword());
            callst.setString(3, account.getEmail());
            callst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callst);
        }
    }
}
