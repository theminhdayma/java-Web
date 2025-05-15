package com.data.session06.dao.Bai4;

import com.data.session06.model.Bai4.Employee;
import com.data.session06.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> listEmployees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_get_all_employees()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBirthday(rs.getString("birthday"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getFloat("salary"));
                employee.setPosition(rs.getString("position"));
                listEmployees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listEmployees;
    }

    @Override
    public boolean save(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean isSuccess = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_add_employee(?,?,?,?,?,?)}");
            callSt.setString(1, employee.getName());
            callSt.setString(2, employee.getBirthday());
            callSt.setString(3, employee.getPhone());
            callSt.setString(4, employee.getEmail());
            callSt.setDouble(5, employee.getSalary());
            callSt.setString(6, employee.getPosition());
            isSuccess = callSt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return isSuccess;
    }

    @Override
    public Employee findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Employee employee = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_get_employee_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBirthday(rs.getString("birthday"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getFloat("salary"));
                employee.setPosition(rs.getString("position"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employee;
    }

    @Override
    public boolean update(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean isSuccess = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_update_employee(?,?,?,?,?,?,?)}");
            callSt.setInt(1, employee.getId());
            callSt.setString(2, employee.getName());
            callSt.setString(3, employee.getBirthday());
            callSt.setString(4, employee.getPhone());
            callSt.setString(5, employee.getEmail());
            callSt.setDouble(6, employee.getSalary());
            callSt.setString(7, employee.getPosition());
            isSuccess = callSt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return isSuccess;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean isSuccess = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_delete_employee(?)}");
            callSt.setInt(1, id);
            isSuccess = callSt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return isSuccess;
    }

    @Override
    public List<Employee> searchEmployeeByName(String nameEmployee) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> listEmployees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_search_employee_by_name(?)}");
            callSt.setString(1, nameEmployee);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBirthday(rs.getString("birthday"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getFloat("salary"));
                employee.setPosition(rs.getString("position"));
                listEmployees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listEmployees;
    }
}
