import java.util.ArrayList;
import java.util.List;

class Application {
    public ArrayList<Company> companies = new ArrayList<>();
    public ArrayList<User> users = new ArrayList<>();

    private static Application instance = null;

    private Application() {
    }

    public static Application getInstance() {
        if (instance == null)
            instance = new Application();

        return instance;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public Company getCompany(String name) {
        int i;
        Company company = null;
        for (i = 0; i < companies.size(); i++) {
            Company c = companies.get(i);
            if (c.name.equals(name)) {
                company = c;
            }
        }
        return company;
    }

    public void add(Company company) {
        companies.add(company);
    }

    public void add(User user) {
        users.add(user);
    }

    public boolean remove(Company company) {
        return companies.remove(company);
    }

    public boolean remove(User user) {
        return users.remove(user);
    }

    public ArrayList<Job> getJobs(List<String> companies) {
        int i, j, k, z;
        ArrayList<Job> jobsAvailable = new ArrayList<>();

        for (i = 0; i < companies.size(); i++) {
            String stringCompany = companies.get(i);
            for (j = 0; j < this.companies.size(); j++) {
                Company company = this.companies.get(j);
                if (stringCompany.equals(company.name)) {
                    for (k = 0; k < company.departments.size(); k++) {
                        Department department = company.departments.get(k);
                        for (z = 0; z < department.jobs.size(); z++) {
                            Job job = department.jobs.get(z);
                            if (job.jobAvailability)
                                jobsAvailable.add(job);
                        }
                    }
                }
            }
        }

        return jobsAvailable;
    }

}

