import java.util.ArrayList;
import java.util.Date;

public class Information {
    private String last_name;
    private String first_name;
    private String email;
    private String phone_number;
    private Date birth_date;
    private String sex;
    private ArrayList<Language> languages;

    public Information(String last_name, String first_name, String email, String phone_number, Date birth_date, String sex, ArrayList<Language> languages) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.phone_number = phone_number;
        this.birth_date = birth_date;
        this.sex = sex;
        this.languages = languages;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getSex() {
        return sex;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

}

