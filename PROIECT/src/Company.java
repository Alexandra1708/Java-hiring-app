import java.util.ArrayList;

public class Company {
    public Company company;
    public String name;
    public Manager manager;
    public ArrayList<Department> departments = new ArrayList<Department>();
    public ArrayList<Recruiter> recruiters = new ArrayList<Recruiter>();

    public Company(Company company, String name, Manager manager, ArrayList<Department> departments, ArrayList<Recruiter> recruiters) {
        this.company = company;
        this.name = name;
        this.manager = manager;
        this.departments = departments;
        this.recruiters = recruiters;
    }

    public Company(String name) {
        this.name = name;
    }

    public void add(Department department) {
        departments.add(department);
    }

    public void add(Recruiter recruiter) {
        recruiters.add(recruiter);
    }

    public void add(Employee employee, Department department) {
        department.employees.add(employee);
    }

    public void remove(Employee employee) {
        int i;
        for (i = 0; i < departments.size(); i++) {
            Department d = departments.get(i);
            d.employees.remove(employee);
        }
    }

    public void remove(Department department) {
        departments.remove(department);
        department.employees.clear();
    }

    public void remove(Recruiter recruiter) {
        recruiters.remove(recruiter);
    }

    public void move(Department source, Department destination) {
        int i;
        for (i = 0; i < source.employees.size(); i++) {
            Employee e = source.employees.get(i);
            destination.add(e);
        }
    }

    public void move(Employee employee, Department newDepartment) {
        int i;
        for (i = 0; i < departments.size(); i++) {
            Department d = departments.get(i);
            d.employees.remove(employee);
        }
        newDepartment.employees.add(employee);
    }

    public boolean contains(Department department) {
        return departments.contains(department);
    }

    public boolean contains(Employee employee) {
        int i;
        boolean a = false;
        for (i = 0; i < departments.size(); i++) {
            Department d = departments.get(i);
            a = d.employees.contains(employee);
        }
        return a;
    }

    public boolean contains(Recruiter recruiter) {
        return recruiters.contains(recruiter);
    }

    public ArrayList<Job> getJobs() {
        int i, j;
        ArrayList<Job> jobs = new ArrayList<>();
        for (i = 0; i < departments.size(); i++) {
            Department d = departments.get(i);
            for (j = 0; j < d.jobs.size(); j++) {
                Job job = d.jobs.get(i);
                if (job.jobAvailability)
                    jobs.add(job);
            }
        }
        return jobs;
    }
}

