package task2_with_xml_bean;

import java.util.List;

public class EmpS {

    private IempDAO employeeDAO;

    
    public EmpS() {}

    
    public EmpS(IempDAO employeeDAO) {
    	
        this.employeeDAO = employeeDAO;
    }

    
    public void setEmployeeDAO(IempDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Emp emp) {
        employeeDAO.addEmployee(emp);
    }

    public Emp getEmployee(Emp id) {
        return employeeDAO.getEmployee(id);
    }

    public List<Emp> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public void updateSalary(int id, int salary) {
        employeeDAO.updateSalary(id, salary);
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
