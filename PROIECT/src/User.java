import java.util.ArrayList;
import java.util.List;

public class User extends Consumer {
    public List<String> companies;

    public User(Resume resume, ArrayList<Consumer> acquaintances, List<String> companies) {
        super(resume, acquaintances);
        this.companies = companies;
    }

    public Double getTotalScore() {
        Experience ex = this.resume.getExperience().first();
        int totalExperience = 0;
        Double score = 0.0;
        Education ed = this.resume.getEducation().first();
        Double grade = 0.0;

        while (ex != this.resume.getExperience().last()) {
            totalExperience = totalExperience + ex.getExperience();
        }

        while (ed != this.resume.getEducation().last()) {
            grade = grade + ed.finalGrade;
        }

        score = totalExperience * 1.5 + grade;

        return score;
    }
}