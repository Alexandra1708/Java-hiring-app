import java.util.ArrayList;
import java.util.Collection;

public class Manager extends Employee {
    Collection<Request> jobApplications;

    public Manager(Resume resume, ArrayList<Consumer> acquaintances, String companyName, Double salary, Collection<Request> jobApplications) {
        super(resume, acquaintances, companyName, salary);
        this.jobApplications = jobApplications;
    }
}