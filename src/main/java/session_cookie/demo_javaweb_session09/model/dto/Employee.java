package session_cookie.demo_javaweb_session09.model.dto;

public class Employee {
    private Long empId;
    private String fullName;
    private Boolean gender;
    private String company;
    private String avatar;

    public Employee() {
    }

    public Employee(Long empId, String fullName, Boolean gender, String company, String avatar) {
        this.empId = empId;
        this.fullName = fullName;
        this.gender = gender;
        this.company = company;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
