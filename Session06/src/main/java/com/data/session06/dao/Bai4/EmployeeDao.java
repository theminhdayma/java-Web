package com.data.session06.dao.Bai4;

import com.data.session06.model.Bai4.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    boolean save(Employee employee);

    Employee findById(int id);

    boolean update(Employee employee);

    boolean delete(int id);

    List<Employee> searchEmployeeByName(String nameEmployee);
}
