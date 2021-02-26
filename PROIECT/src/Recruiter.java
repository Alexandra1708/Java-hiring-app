import java.util.ArrayList;

public class Recruiter extends Employee {
    public Double rating = 5.0;

    public Recruiter(Resume resume, ArrayList<Consumer> acquaintances, String companyName, Double salary, Double rating) {
        super(resume, acquaintances, companyName, salary);
        this.rating = rating;
    }

    public int evaluate(Job job, User user) {
        return (int) (rating * user.getTotalScore());

    }
}
