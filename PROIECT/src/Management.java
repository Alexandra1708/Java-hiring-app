import java.util.ArrayList;

class Management extends Department {

    public Management(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        super(employees, jobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        int i;
        double finalSalary = 0.0;
        for (i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            finalSalary = finalSalary + (e.salary - 0.16 * e.salary);
        }
        return finalSalary;
    }
}

