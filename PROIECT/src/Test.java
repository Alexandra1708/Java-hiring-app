import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.json.*;

public class Test {

    public static void main(String args[]) throws Exception {
        initData();
        new LogInPage();
    }

    private static void initData() throws Exception {
        Application application = Application.getInstance();

        try {
            File file = new File("C:\\Users\\Alexandra\\Desktop\\SURSE\\informatii.txt");

            FileReader fileReader = new FileReader(file);

            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {
                String[] arrayLine = line.split("\n");
                Company company = new Company(arrayLine[0]);
                application.add(company);
            }

            reader.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(getJsonFileAsString());
        JSONArray jsonEmployeesArray = jsonObject.getJSONArray("employees");

        for (int i = 0; i < jsonEmployeesArray.length(); i++) {
            JSONObject obj = jsonEmployeesArray.getJSONObject(i);

            String name = String.valueOf(obj.get("name"));
            String email = String.valueOf(obj.get("email"));
            String phone = String.valueOf(obj.get("phone"));
            String date_of_birth = String.valueOf(obj.get("date_of_birth"));
            String genre = String.valueOf(obj.get("genre"));

            SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");

            Date dateBirth=formatter1.parse(date_of_birth);

            ArrayList<Language> lan = new ArrayList<>();

            JSONObject firstElementFromList = jsonEmployeesArray.getJSONObject(i);
            JSONArray languages = firstElementFromList.getJSONArray("languages");
            JSONArray languages_levels = firstElementFromList.getJSONArray("languages_level");
            String languagename = String.valueOf(languages);
            String languageslevel = String.valueOf(languages_levels);
            String[] languageNames = languagename.split(",");
            String[] languagesLevel = languageslevel.split(",");
            String LEVEL;
            String LANGUAGE;

            for (int index = 0; index < languageNames.length; index++) {
                LANGUAGE = languageNames[index];
                LEVEL = languagesLevel[index];
                Language language = new Language(LANGUAGE,LEVEL);
                lan.add(language);
                ArrayList<String> levels = new ArrayList<>();
                levels.add(LEVEL);
            }

            JSONArray educationArray = firstElementFromList.getJSONArray("education");

            for (int j = 0; j < educationArray.length(); j++) {
                JSONObject objectEducation = educationArray.getJSONObject(j);

                String levelInstitution = String.valueOf(objectEducation.get("level"));
                String nameInstitution = String.valueOf(objectEducation.get("name"));
                String start_date = String.valueOf(objectEducation.get("start_date"));
                String end_date = String.valueOf(objectEducation.get("end_date"));
                Double grade = objectEducation.getDouble("grade");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate startDate = LocalDate.parse(start_date, formatter);
                LocalDate endDate;

                if (end_date.equals("null")) {
                    LocalDate dateNull = LocalDate.of(2099,12,20);
                    endDate = dateNull;
                } else
                    endDate = LocalDate.parse(end_date, formatter);


                Education education = new Education(startDate, endDate, nameInstitution, levelInstitution, grade);

                SortedSet<Education> educations = new TreeSet<>();
                educations.add(education);

            }

            ArrayList<Consumer> acquintances = new ArrayList<>();
            ArrayList<String> companies = new ArrayList<>();

            Information information = new Information(name,name, email, phone, dateBirth, genre, lan);


            Consumer.Resume resume = new Consumer.Resume.ResumeBuilder()
                    .information(information)
                    .build();


        }

        JSONArray jsonUsersArray = jsonObject.getJSONArray("users");

        for (int j = 0; j < jsonUsersArray.length(); j++) {
            JSONObject objectUsers = jsonUsersArray.getJSONObject(j);

            String nameUser = String.valueOf(objectUsers.get("name"));
            String emailUser = String.valueOf(objectUsers.get("email"));
            String phoneUser = String.valueOf(objectUsers.get("phone"));
            String date_of_birth_user = String.valueOf(objectUsers.get("date_of_birth"));
            String genreUser = String.valueOf(objectUsers.get("genre"));

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

            Date dateBirthUser = formatter.parse(date_of_birth_user);

            ArrayList<Consumer> acquintances = new ArrayList<>();
            ArrayList<String> companies = new ArrayList<>();
            ArrayList<Language> languagesUser = new ArrayList<>();

            JSONObject firstElementFromList = jsonEmployeesArray.getJSONObject(j);
            JSONArray languages = firstElementFromList.getJSONArray("languages");
            JSONArray languages_levels = firstElementFromList.getJSONArray("languages_level");
            String languagename = String.valueOf(languages);
            String languageslevel = String.valueOf(languages_levels);
            String[] languageNames = languagename.split(",");
            String[] languagesLevel = languageslevel.split(",");
            String LEVEL;
            String LANGUAGE;

            for (int index = 0; index < languageNames.length; index++) {
                LANGUAGE = languageNames[index];
                LEVEL = languagesLevel[index];
                Language language = new Language(LANGUAGE,LEVEL);
                languagesUser.add(language);
                ArrayList<String> levels = new ArrayList<>();
                levels.add(LEVEL);
            }

            Information information = new Information(nameUser,nameUser, emailUser, phoneUser, dateBirthUser, genreUser, languagesUser);


            Consumer.Resume resume = new Consumer.Resume.ResumeBuilder()
                    .information(information)
                    .build();

            User user = new User(resume, acquintances, companies);

            application.add(user);
        }
    }

    private static String getJsonFileAsString() throws FileNotFoundException {

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\Alexandra\\Desktop\\SURSE\\consumers.json"));

        while(scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
