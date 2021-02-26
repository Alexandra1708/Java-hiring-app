import java.util.ArrayList;

class Marketing extends Department {

    public Marketing(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        super(employees, jobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        int i;
        double finalSalaryAbove5000 = 0.0;
        double finalSalaryBelow3000 = 0.0;
        double finalSalaryOthers = 0.0;
        for (i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.salary >= 5000) {
                finalSalaryAbove5000 = finalSalaryAbove5000 + (e.salary - 0.16 * e.salary);
            }

            else if (e.salary <= 3000) {
                finalSalaryBelow3000 = finalSalaryBelow3000 + e.salary;
            }

            else {
                finalSalaryOthers = finalSalaryOthers + (e.salary - 0.1 * e.salary);
            }
        }
        return finalSalaryAbove5000 + finalSalaryBelow3000 + finalSalaryOthers;
    }
}

