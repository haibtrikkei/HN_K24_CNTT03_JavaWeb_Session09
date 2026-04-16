package session_cookie.demo_javaweb_session09.repository.impl;

import org.springframework.stereotype.Repository;
import session_cookie.demo_javaweb_session09.model.dto.Employee;
import session_cookie.demo_javaweb_session09.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepositoryImpl(){
        employees = new ArrayList<>();
        employees.add(new Employee(1L,"Nguyễn Thanh Huyền",false,"Rikkei software","huyen.jpg"));
        employees.add(new Employee(2L,"Trần Mạnh Đức",true,"FPT software","duc.jpg"));
        employees.add(new Employee(3L,"Lê Thị Lan",false,"Rikkei soft","lan.jpg"));
        employees.add(new Employee(4L,"Mạnh Thường Quân",true,"Rikkei soft","quan.jpg"));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    @Override
    public boolean deleteEmployee(Long empId) {
        Employee employee = employees.stream().filter(e -> e.getEmpId() == empId).findFirst().orElse(null);
        if(employee!=null){
            return employees.remove(employee);
        }
        return false;
    }

    @Override
    public List<Employee> findByName(String empName) {
        return employees.stream().filter(e -> e.getFullName().toLowerCase().contains(empName.toLowerCase())).toList();
    }
}
