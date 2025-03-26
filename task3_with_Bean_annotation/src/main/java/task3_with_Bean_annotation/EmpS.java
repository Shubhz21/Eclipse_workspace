package task3_with_Bean_annotation;



import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmpS {

    private final IempDAO employeeDAO;

    
    public EmpS(IempDAO employeeDAO) {
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

