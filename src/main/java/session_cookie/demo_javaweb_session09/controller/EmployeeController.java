package session_cookie.demo_javaweb_session09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import session_cookie.demo_javaweb_session09.model.dto.Employee;
import session_cookie.demo_javaweb_session09.model.dto.EmployeeDTO;
import session_cookie.demo_javaweb_session09.model.dto.UserLogin;
import session_cookie.demo_javaweb_session09.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(Model model){
        model.addAttribute("listEmployee",employeeService.getEmployees());
        return "list-employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("employeeDTO",new EmployeeDTO());
        return "addEmployee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("empId")Long empId, Model model){
        boolean bl = employeeService.deleteEmployee(empId);
        if(bl){
            model.addAttribute("message","Xóa thành công nhân viên có mã "+empId);
        }else{
            model.addAttribute("message","Không xóa được nhân viên có mã "+empId);
        }
        model.addAttribute("listEmployee",employeeService.getEmployees());
        return "list-employees";
    }

    @GetMapping("/search-by-name")
    public String searchByName(@RequestParam("fullName")String fullName, Model model){
        if(fullName==null){
            fullName = "";
        }
        model.addAttribute("listEmployee",employeeService.searchByName(fullName));
        return "list-employees";
    }
}
