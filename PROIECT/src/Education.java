import java.time.LocalDate;

public class Education implements Comparable<Education> {
    public LocalDate startDate;
    public LocalDate finishDate;
    public String nameInstitution;
    public String level;
    public Double finalGrade;

    static class InvalidDatesException extends Exception {
        public InvalidDatesException(String s) {
            super(s);
        }
    }

    public Education(LocalDate startDate, LocalDate finishDate, String nameInstitution, String level, Double finalGrade) {
        try {
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.nameInstitution = nameInstitution;
            this.level = level;
            this.finalGrade = finalGrade;

            if (startDate.compareTo(finishDate) > 0) {
                throw new InvalidDatesException("The start date must be before the finish date!\n");
            }
        }
        catch (InvalidDatesException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int compareTo(Education e) {
       if (this.finishDate.compareTo(e.finishDate) != 0) {
           return e.finishDate.compareTo(this.finishDate);
       }
       else if (this.finalGrade - e.finalGrade != 0.0){
           return (int)(e.finalGrade - this.finalGrade);
       }
       else if (e.finishDate == null) {
           return this.startDate.compareTo(e.startDate);
       }
       return 0;
    }
}
