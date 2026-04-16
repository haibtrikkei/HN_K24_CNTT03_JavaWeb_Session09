package session_cookie.demo_javaweb_session09.repository;

import session_cookie.demo_javaweb_session09.model.dto.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(Long empId);
    List<Employee> findByName(String empName);
}
