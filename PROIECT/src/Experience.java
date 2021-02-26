import java.time.LocalDate;
import java.time.Period;

public class Experience implements Comparable<Experience> {
    public LocalDate startDate;
    public LocalDate finishDate;
    public String companyName;
    public String position;

    static class InvalidDatesException extends Exception {
        public InvalidDatesException(String s) {
            super(s);
        }
    }

    public Experience(LocalDate startDate, LocalDate finishDate, String companyName, String position) {
        try {
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.companyName = companyName;
            this.position = position;

            if (startDate.compareTo(finishDate) > 0) {
                throw new InvalidDatesException("The start date must be before the end date!\n");
            }
        }
        catch (InvalidDatesException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getExperience() {
        Period period = Period.between(startDate, finishDate);
        int years = 0;
        int months = period.getMonths();
        if (months > 0 || months <= 12)
            years = 1;
        else
            years = (months / 12) + 1;
        return years;
    }

    @Override
    public int compareTo(Experience e) {
        if (this.finishDate.compareTo(e.finishDate) != 0) {
            return e.finishDate.compareTo(this.finishDate);
        }
        else if (e.finishDate == null) {
            return this.companyName.compareTo(e.companyName);
        }
        return 0;
    }
}