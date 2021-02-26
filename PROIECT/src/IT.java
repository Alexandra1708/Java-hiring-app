import java.util.ArrayList;

class IT extends Department {

    public IT(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        super(employees, jobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        int i;
        double finalSalary = 0.0;
        int numberEmployees = employees.size();
        for (i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            finalSalary = e.salary;
        }
        return numberEmployees * finalSalary;
    }
}