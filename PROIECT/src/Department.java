import java.util.ArrayList;

abstract class Department {
    public ArrayList<Employee> employees = new ArrayList<>();
    public ArrayList<Job> jobs = new ArrayList<>();

    public Department(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        this.employees = employees;
        this.jobs = jobs;
    }

    public abstract double getTotalSalaryBudget();

    public ArrayList<Job> getJobs() {
        ArrayList<Job> availableJobs = new ArrayList<>();
        int i;

        for(i = 0; i < jobs.size(); i++) {
            Job j = jobs.get(i);
            if(j.jobAvailability) {
                availableJobs.add(j);
            }
        }
        return availableJobs;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public void add(Job job) {
        jobs.add(job);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}


class DepartmentFactory {

    static class InvalidTypeDepartmentException extends RuntimeException {
        public InvalidTypeDepartmentException(String s) {
            super(s);
        }
    }

    public Department factory(String type, ArrayList<Employee> employees, ArrayList<Job> jobs) {
        if (type.equals("IT"))
            return new IT(employees, jobs);
        if (type.equals("Marketing"))
            return new Marketing(employees, jobs);
        if (type.equals("Finance"))
            return new Finance(employees, jobs);
        if (type.equals("Management"))
            return new Management(employees, jobs);
        throw new InvalidTypeDepartmentException("This department does not exist!!\n");
    }
}
