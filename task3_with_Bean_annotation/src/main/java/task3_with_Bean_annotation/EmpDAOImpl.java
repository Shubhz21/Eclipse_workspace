package task3_with_Bean_annotation;



import java.util.List;

public class EmpDAOImpl implements IempDAO {

    public EmpDAOImpl() {
        System.out.println("EmpDAOImpl constructor called...");
    }

    
    public void addEmployee(Emp emp) {
        System.out.println("Employee added: " + emp.getName());
    }

    
    public Emp getEmployee(Emp id) {
        System.out.println("Employee viewed");
        return null;
    }

    
    public List<Emp> getAllEmployees() {
        System.out.println("All employees fetched");
        return null;
    }

    
    public void updateSalary(int id, int salary) {
        System.out.println("Salary updated for ID: " + id);
    }

    
    public void deleteEmployee(int id) {
        System.out.println("Employee deleted: " + id);
    }
}

