package session_cookie.demo_javaweb_session09.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeDTO {
    private Long empId;
    private String fullName;
    private Boolean gender;
    private String company;
    private MultipartFile file;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long empId, String fullName, Boolean gender, String company, MultipartFile file) {
        this.empId = empId;
        this.fullName = fullName;
        this.gender = gender;
        this.company = company;
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
