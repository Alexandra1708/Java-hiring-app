import java.util.ArrayList;

public class Job {
    public String nameJob;
    public String nameCompany;
    public boolean jobAvailability;
    public Constraint graduationYear;
    public Constraint yearsExperience;
    public Constraint grade;
    public ArrayList<User> candidates;
    public Integer noPositions;
    public Double salary;

    public Job(String nameJob, String nameCompany, boolean jobAvailability, Constraint graduationYear, Constraint yearsExperience, Constraint grade, ArrayList<User> candidates, Integer noPositions, Double salary) {
        this.nameJob = nameJob;
        this.nameCompany = nameCompany;
        this.jobAvailability = jobAvailability;
        this.graduationYear = graduationYear;
        this.yearsExperience = yearsExperience;
        this.grade = grade;
        this.candidates = candidates;
        this.noPositions = noPositions;
        this.salary = salary;
    }

    public boolean meetsRequirements(User user) {
        if (this.graduationYear.inferiorLimit >= user.resume.getEducation().first().finishDate.getYear() && this.graduationYear.superiorLimit <= user.resume.getEducation().first().finishDate.getYear()
             && this.yearsExperience.inferiorLimit >= user.resume.getExperience().first().getExperience() && this.yearsExperience.superiorLimit <= user.resume.getExperience().first().getExperience()
             && this.grade.inferiorLimit >= user.meanGPA() && this.grade.superiorLimit <= user.meanGPA())
            return true;
        return false;
    }

}