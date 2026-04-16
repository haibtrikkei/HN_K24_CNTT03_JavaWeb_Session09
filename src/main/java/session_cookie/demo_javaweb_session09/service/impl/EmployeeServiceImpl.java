package session_cookie.demo_javaweb_session09.service.impl;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import session_cookie.demo_javaweb_session09.model.dto.Employee;
import session_cookie.demo_javaweb_session09.repository.EmployeeRepository;
import session_cookie.demo_javaweb_session09.service.EmployeeService;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private ServletContext servletContext;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ServletContext servletContext){
        this.employeeRepository = employeeRepository;
        this.servletContext = servletContext;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Long empId) {
        return employeeRepository.deleteEmployee(empId);
    }

    @Override
    public List<Employee> searchByName(String fullName) {
        return employeeRepository.findByName(fullName);
    }

    @Override
    public String uploadToLocal(MultipartFile file) {

        return "";
    }
}
