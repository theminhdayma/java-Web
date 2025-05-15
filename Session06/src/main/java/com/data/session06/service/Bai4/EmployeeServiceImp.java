package com.data.session06.service.Bai4;

import com.data.session06.dao.Bai4.EmployeeDao;
import com.data.session06.dao.Bai4.EmployeeDaoImp;
import com.data.session06.model.Bai4.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public boolean save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeDao.delete(id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String nameEmployee) {
        return employeeDao.searchEmployeeByName(nameEmployee);
    }
}
