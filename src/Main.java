import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int  id;

    public Employee(String name , int id){
        this.name= name;
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }

    static class FullTimeEmployee extends Employee{
        private double monthlySalary;
        public FullTimeEmployee(String name,int id,double monthSalary){
            super(name,id);
            this.monthlySalary=monthSalary;
        }
        @Override
        public double calculateSalary(){
            return monthlySalary;
        }

    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorks;
    private double hoursRate;
    public PartTimeEmployee(String name,int id,int hoursWorks,double hoursRate){

        super(name,id);
        this.hoursWorks=hoursWorks;
        this.hoursRate=hoursRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorks*hoursRate;
    }

}

class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();

    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove =employee;
                break;
            }

        }
        if(employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }

}

public class Main {
    public static void main(String[] args) {
      PayrollSystem payrollSystem = new PayrollSystem();
      Employee.FullTimeEmployee Emp1= new Employee.FullTimeEmployee("Aashu",1,25000);
      PartTimeEmployee Emp2 = new PartTimeEmployee("Aaman ",2,40,100);
      payrollSystem.addEmployee(Emp1);
      payrollSystem.addEmployee(Emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployee();
        System.out.println("Employee Remove Successfully  ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees Details: ");
        payrollSystem.displayEmployee();

    }
}