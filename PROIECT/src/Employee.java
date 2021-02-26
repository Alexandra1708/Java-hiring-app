import java.util.ArrayList;

public class Employee extends Consumer {
    public String companyName;
    public Double salary;

    public Employee(Resume resume, ArrayList<Consumer> acquaintances, String companyName, Double salary) {
        super(resume, acquaintances);
        this.companyName = companyName;
        this.salary = salary;
    }

}

