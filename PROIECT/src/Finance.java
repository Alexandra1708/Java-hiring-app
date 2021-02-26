import java.util.ArrayList;

class Finance extends Department {

    public Finance(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        super(employees, jobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        int i, yearsExperience = 0, noEmployeesLittleExperience = 0;
        double finalSalaryLittleExperience = 0.0;
        double finalSalaryLotExperience = 0.0;

        for (i = 0; i < this.employees.size(); i++) {
            Consumer consumer = this.employees.get(i);
            Experience experience = consumer.resume.getExperience().first();

            while (experience != consumer.resume.getExperience().last()) {
                yearsExperience = yearsExperience + experience.getExperience();
            }

            if (yearsExperience <= 1) {
                finalSalaryLittleExperience = this.employees.get(i).salary - (0.1 * this.employees.get(i).salary);
                noEmployeesLittleExperience++;
            }
            else {
                finalSalaryLotExperience = this.employees.get(i).salary - (0.16 * this.employees.get(i).salary);
            }
        }

        return finalSalaryLittleExperience * noEmployeesLittleExperience + finalSalaryLotExperience * (this.employees.size() - noEmployeesLittleExperience);
    }
}
