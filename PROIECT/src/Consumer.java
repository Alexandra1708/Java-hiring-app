import java.util.*;

abstract class Consumer {
    public Resume resume;
    public ArrayList<Consumer> acquaintances = new ArrayList<>();

    public Consumer(Resume resume, ArrayList<Consumer> acquaintances) {
        this.resume = resume;
        this.acquaintances = acquaintances;
    }

    public void add(Education education) {
        resume.education.add(education);
    }

    public void add(Experience experience) {
        resume.experience.add(experience);
    }

    public void add(Consumer consumer) {
        acquaintances.add(consumer);
    }

    public void remove(Consumer consumer) {
        acquaintances.remove(consumer);
    }

    public Double meanGPA() {
        Education ed = this.resume.education.first();
        Double GPA = 0.0;

        while(ed != resume.education.last()) {
            GPA = GPA + ed.finalGrade;
        }

        return GPA;
    }

    public Integer getGraduationYear() {
        Education education = this.resume.education.first();
        return education.finishDate.getYear();
    }


    static class Resume {
        private final Information information;
        private final SortedSet<Education> education;
        private final SortedSet<Experience> experience;

        private Resume(ResumeBuilder builder) {
            this.information = builder.information;
            this.education = builder.education;
            this.experience = builder.experience;
        }

        public SortedSet<Experience> getExperience() {
            return experience;
        }

        public Information getInformation() {
            return information;
        }

        public SortedSet<Education> getEducation() {
            return education;
        }

        public static class ResumeBuilder {
            private Information information;
            private SortedSet<Education> education;
            private SortedSet<Experience> experience;

            public ResumeBuilder information(Information information) {
                this.information = information;
                return this;
            }

            public ResumeBuilder education(SortedSet<Education> education) {
                this.education = education;
                return this;
            }

            public ResumeBuilder experience(SortedSet<Experience> experience) {
                this.experience = experience;
                return this;
            }

            public Resume build() {
                return new Resume(this);
            }
        }


    }
}

