package session_cookie.demo_javaweb_session09.service;

import org.springframework.web.multipart.MultipartFile;
import session_cookie.demo_javaweb_session09.model.dto.Employee;
import session_cookie.demo_javaweb_session09.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    boolean insertEmployee(Employee employee);
    boolean deleteEmployee(Long empId);
    List<Employee> searchByName(String fullName);
    String uploadToLocal(MultipartFile file);
}
