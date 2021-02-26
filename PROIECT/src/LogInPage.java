import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogInPage extends JFrame {

    public LogInPage() {

        JFrame frame = new JFrame();
        frame.setTitle("Hiring App");
        frame.setLayout(new GridLayout(5,1));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        JLabel title = new JLabel("We are hiring!", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(30.0f));
        JLabel login = new JLabel("Log in as:");
        login.setFont(login.getFont().deriveFont(20.0f));

        JButton buttonAdmin = new JButton("Admin");
        buttonAdmin.setFont(buttonAdmin.getFont().deriveFont(20.0f));
        buttonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAdmin = new JFrame();
                frameAdmin.setSize(400,400);
                frameAdmin.setTitle("Admin Page");
                JPanel panel = new JPanel();
                JLabel title = new JLabel("Admin page", SwingConstants.CENTER);
                title.setFont(title.getFont().deriveFont(30.0f));
                JLabel labelCompanies = new JLabel("Companies registered:");
                labelCompanies.setFont(labelCompanies.getFont().deriveFont(20.0f));
                DefaultListModel<Company> listCompaniesModel = new DefaultListModel<>();
                DefaultListModel<String> listCompaniesNameModel = new DefaultListModel<>();

                int indexCompanies;
                for (indexCompanies = 0; indexCompanies < Application.getInstance().getCompanies().size(); indexCompanies++) {
                    Company company = Application.getInstance().getCompanies().get(indexCompanies);
                    listCompaniesModel.addElement(company);
                    listCompaniesNameModel.addElement(company.name);
                }

                JList<Company> listCompanies = new JList<>(listCompaniesModel);
                JList<String> listCompaniesName = new JList<>(listCompaniesNameModel);

                listCompaniesName.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            JFrame frameCompany = new JFrame();
                            frameCompany.setSize(400,400);
                            frameCompany.setTitle("Company Page");
                            frameCompany.setLayout(new GridLayout(6,2));

                            String value = (String)listCompaniesName.getModel().getElementAt(listCompaniesName.locationToIndex(event.getPoint()));

                            JLabel title = new JLabel("Company", SwingConstants.CENTER);
                            title.setFont(title.getFont().deriveFont(30.0f));

                            JLabel title3 = new JLabel("information", SwingConstants.CENTER);
                            title3.setFont(title.getFont().deriveFont(30.0f));

                            JLabel title2 = new JLabel("");
                            title2.setFont(title.getFont().deriveFont(00.0f));

                            JLabel title4 = new JLabel("");
                            title4.setFont(title.getFont().deriveFont(00.0f));

                            JLabel labelCompanyName = new JLabel("Name:");
                            labelCompanyName.setFont(labelCompanyName.getFont().deriveFont(20.0f));

                            JLabel labelCompanyManager = new JLabel("Manager:");
                            labelCompanyManager.setFont(labelCompanyManager.getFont().deriveFont(20.0f));


                            JLabel labelCompanyDepartments = new JLabel("Departments:");
                            labelCompanyDepartments.setFont(labelCompanyDepartments.getFont().deriveFont(20.0f));

                            JLabel labelCompanyRecruiters = new JLabel("Recruiters:");
                            labelCompanyRecruiters.setFont(labelCompanyRecruiters.getFont().deriveFont(20.0f));

                            JLabel labelCompanyName2 = new JLabel(value);
                            labelCompanyName2.setFont(labelCompanyName2.getFont().deriveFont(20.0f));

                            JLabel labelCompanyManager2 = new JLabel("");
                            labelCompanyManager2.setFont(labelCompanyManager2.getFont().deriveFont(20.0f));

                            String departments[]= {"IT", "Management", "Marketing", "Finance"};

                            JPanel panel = new JPanel();
                            JList<String> departmentsList = new JList<>(departments);
                            JScrollPane scroll = new JScrollPane(panel);
                            panel.add(departmentsList);

                            JLabel labelCompanyRecruiters2 = new JLabel("");
                            labelCompanyRecruiters2.setFont(labelCompanyRecruiters2.getFont().deriveFont(20.0f));

                            frameCompany.add(title);
                            frameCompany.add(title2);
                            frameCompany.add(title3);
                            frameCompany.add(title4);
                            frameCompany.add(labelCompanyName);
                            frameCompany.add(labelCompanyName2);
                            frameCompany.add(labelCompanyManager);
                            frameCompany.add(labelCompanyManager2);
                            frameCompany.add(labelCompanyDepartments);
                            frameCompany.add(scroll);
                            frameCompany.add(labelCompanyRecruiters);
                            frameCompany.add(labelCompanyRecruiters2);
                            frameCompany.setVisible(true);
                        }
                    }
                });

                JLabel labelUsers = new JLabel("Users registered:");
                labelUsers.setFont(labelUsers.getFont().deriveFont(20.0f));
                DefaultListModel<User> listUsersModel = new DefaultListModel<>();
                DefaultListModel<String> listUsersNameModel = new DefaultListModel<>();
                int indexUsers;
                for (indexUsers = 0; indexUsers < Application.getInstance().users.size(); indexUsers++) {
                    User user = Application.getInstance().users.get(indexUsers);
                    listUsersModel.addElement(user);
                    listUsersNameModel.addElement(user.resume.getInformation().getLast_name());
                }

                JList<User> listUsers = new JList<>(listUsersModel);
                JList<String> listUsersName = new JList<>(listUsersNameModel);

                panel.add(title);
                panel.add(labelCompanies);
                panel.add(listCompaniesName);
                panel.add(labelUsers);
                panel.add(listUsersName);

                panel.setLayout(new GridLayout(5,1));

                JScrollPane scroll = new JScrollPane(panel);

                frameAdmin.add(scroll);
                frameAdmin.setVisible(true);
            }
        });

        JButton buttonManager = new JButton("Manager");
        buttonManager.setFont(buttonManager.getFont().deriveFont(20.0f));
        buttonManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameManager = new JFrame();
                frameManager.setSize(400,400);
                frameManager.setTitle("Manager Page");
                frameManager.setLayout(new GridLayout(5,1));
                JLabel title = new JLabel("Manager page", SwingConstants.CENTER);
                title.setFont(title.getFont().deriveFont(30.0f));

                JLabel jobRequests = new JLabel("Job requests:");
                jobRequests.setFont(jobRequests.getFont().deriveFont(20.0f));
                DefaultListModel<Request> listRequestsModel = new DefaultListModel<>();
                JList<Request> listRequests = new JList<>(listRequestsModel);

                JButton buttonAccept = new JButton("Accept request");
                buttonAccept.setFont(buttonAccept.getFont().deriveFont(20.0f));

                JButton buttonDecline = new JButton("Decline request");
                buttonDecline.setFont(buttonDecline.getFont().deriveFont(20.0f));

                frameManager.add(title);
                frameManager.add(jobRequests);
                frameManager.add(listRequests);
                frameManager.add(buttonAccept);
                frameManager.add(buttonDecline);
                frameManager.setVisible(true);
            }
        });
        JButton buttonUser = new JButton("User");
        buttonUser.setFont(buttonUser.getFont().deriveFont(20.0f));
        buttonUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameFindUser = new JFrame();
                frameFindUser.setSize(500,400);
                frameFindUser.setTitle("User Page");
                frameFindUser.setLayout(new GridLayout(4,1));
                JLabel title = new JLabel("Find user", SwingConstants.CENTER);
                title.setFont(title.getFont().deriveFont(30.0f));
                JLabel labelSearchUser = new JLabel("Search user by full name (last name + first name):");
                labelSearchUser.setFont(labelSearchUser.getFont().deriveFont(20.0f));

                JTextField TextFieldNameUser = new JTextField();
                String nameUser = TextFieldNameUser.getText();

                JButton buttonSearch = new JButton("Search user");
                buttonSearch.setFont(buttonSearch.getFont().deriveFont(20.0f));
                buttonSearch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int indexUsers;
                        for (indexUsers = 0; indexUsers < Application.getInstance().users.size(); indexUsers++) {
                            User user = Application.getInstance().users.get(indexUsers);
                            if (TextFieldNameUser.getText().equals(user.resume.getInformation().getLast_name())) {
                                JFrame frameUserProfile = new JFrame();
                                frameUserProfile.setSize(700, 700);
                                frameUserProfile.setTitle("User Profile");
                                frameUserProfile.setLayout(new GridLayout(11, 2));

                                JLabel titleProfile = new JLabel("User profile", SwingConstants.CENTER);
                                titleProfile.setFont(titleProfile.getFont().deriveFont(30.0f));

                                JLabel labelLastName = new JLabel("Last name:");
                                labelLastName.setFont(labelLastName.getFont().deriveFont(20.0f));

                                JLabel labelFirstName = new JLabel("First name:");
                                labelFirstName.setFont(labelFirstName.getFont().deriveFont(20.0f));

                                JLabel labelEmail = new JLabel("Email:");
                                labelEmail.setFont(labelEmail.getFont().deriveFont(20.0f));

                                JLabel labelPhoneNumber = new JLabel("Phone number:");
                                labelPhoneNumber.setFont(labelPhoneNumber.getFont().deriveFont(20.0f));

                                JLabel labelBirthDate = new JLabel("Birth date:");
                                labelBirthDate.setFont(labelBirthDate.getFont().deriveFont(20.0f));

                                JLabel labelSex = new JLabel("Sex:");
                                labelSex.setFont(labelSex.getFont().deriveFont(20.0f));

                                JLabel titleProfile2 = new JLabel("");
                                titleProfile2.setFont(titleProfile2.getFont().deriveFont(30.0f));

                                String[] name = TextFieldNameUser.getText().split("\\s");
                                String lastName = name[0];
                                String firstName = name[1];

                                JLabel labelLastName2 = new JLabel(lastName);
                                labelLastName2.setFont(labelLastName2.getFont().deriveFont(20.0f));

                                JLabel labelFirstName2 = new JLabel(firstName);
                                labelFirstName2.setFont(labelFirstName2.getFont().deriveFont(20.0f));

                                JLabel labelEmail2 = new JLabel(user.resume.getInformation().getEmail());
                                labelEmail2.setFont(labelEmail2.getFont().deriveFont(20.0f));

                                JLabel labelPhoneNumber2 = new JLabel(user.resume.getInformation().getPhone_number());
                                labelPhoneNumber2.setFont(labelPhoneNumber2.getFont().deriveFont(20.0f));

                                JLabel labelBirthDate2 = new JLabel(String.valueOf(user.resume.getInformation().getBirth_date()));
                                labelBirthDate2.setFont(labelBirthDate2.getFont().deriveFont(20.0f));

                                JLabel labelSex2 = new JLabel(user.resume.getInformation().getSex());
                                labelSex2.setFont(labelSex2.getFont().deriveFont(20.0f));

                                JLabel labelLanguages = new JLabel("Languages:");
                                labelLanguages.setFont(labelLanguages.getFont().deriveFont(20.0f));

                                DefaultListModel<Language> listLanguagesModel = new DefaultListModel<>();
                                DefaultListModel<String> listLanguagesNameModel = new DefaultListModel<>();

                                int indexLanguages;
                                for (indexLanguages = 0; indexLanguages < user.resume.getInformation().getLanguages().size(); indexLanguages++) {
                                    Language language = user.resume.getInformation().getLanguages().get(indexLanguages);
                                    listLanguagesModel.addElement(language);
                                    listLanguagesNameModel.addElement(language.languageName);
                                }
                                JList<Language> listLanguages = new JList<>(listLanguagesModel);
                                JList<String> listLanguagesName = new JList<>(listLanguagesNameModel);

                                listLanguagesName.setFont(listLanguagesName.getFont().deriveFont(20.0f));

                                JLabel labelLanguagesLevel = new JLabel("Languages level:");
                                labelLanguagesLevel.setFont(labelLanguagesLevel.getFont().deriveFont(20.0f));

                                DefaultListModel<String> listLanguagesLevelModel = new DefaultListModel<>();

                                for (indexLanguages = 0; indexLanguages < user.resume.getInformation().getLanguages().size(); indexLanguages++) {
                                    Language language = user.resume.getInformation().getLanguages().get(indexLanguages);
                                    String level = language.level;
                                    listLanguagesLevelModel.addElement(level);
                                }
                                JList<String> listLanguagesLevel = new JList<>(listLanguagesLevelModel);
                                listLanguagesLevel.setFont(listLanguagesLevel.getFont().deriveFont(20.0f));


                                JLabel labelEducation = new JLabel("Education:");
                                labelEducation.setFont(labelEducation.getFont().deriveFont(20.0f));

                                DefaultListModel<Education> listEducationModel = new DefaultListModel<>();
                                JList<Education> listEducation = new JList<>(listEducationModel);

                                JLabel labelExperience = new JLabel("Experience:");
                                labelExperience.setFont(labelExperience.getFont().deriveFont(20.0f));

                                DefaultListModel<Experience> listExperienceModel = new DefaultListModel<>();
                                JList<Experience> listExperience = new JList<>(listExperienceModel);


                                frameUserProfile.add(titleProfile);
                                frameUserProfile.add(titleProfile2);
                                frameUserProfile.add(labelLastName);
                                frameUserProfile.add(labelLastName2);
                                frameUserProfile.add(labelFirstName);
                                frameUserProfile.add(labelFirstName2);
                                frameUserProfile.add(labelEmail);
                                frameUserProfile.add(labelEmail2);
                                frameUserProfile.add(labelPhoneNumber);
                                frameUserProfile.add(labelPhoneNumber2);
                                frameUserProfile.add(labelBirthDate);
                                frameUserProfile.add(labelBirthDate2);
                                frameUserProfile.add(labelSex);
                                frameUserProfile.add(labelSex2);
                                frameUserProfile.add(labelLanguages);
                                frameUserProfile.add(listLanguagesName);
                                frameUserProfile.add(labelLanguagesLevel);
                                frameUserProfile.add(listLanguagesLevel);
                                frameUserProfile.add(labelEducation);
                                frameUserProfile.add(listEducation);
                                frameUserProfile.add(labelExperience);
                                frameUserProfile.add(listExperience);

                                frameUserProfile.setVisible(true);
                            }

                        }

                         if (TextFieldNameUser.getText() == null || TextFieldNameUser.getText().trim().isEmpty()){
                            JFrame frameError = new JFrame();
                            frameError.setSize(400, 200);
                            frameError.setTitle("Error");
                            frameError.setLayout(new GridLayout(2, 1));
                            JLabel titleError = new JLabel("Please fill in the name!", SwingConstants.CENTER);
                            titleError.setFont(titleError.getFont().deriveFont(30.0f));
                            JButton buttonOK = new JButton("OK");
                            buttonOK.setFont(buttonOK.getFont().deriveFont(20.0f));
                            buttonOK.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frameError.dispose();
                                }
                            });

                            frameError.add(titleError);
                            frameError.add(buttonOK);
                            frameError.setVisible(true);
                        }
                    }
                });

                frameFindUser.add(title);
                frameFindUser.add(labelSearchUser);
                frameFindUser.add(TextFieldNameUser);
                frameFindUser.add(buttonSearch);
                frameFindUser.setVisible(true);
            }
        });

        frame.add(title);
        frame.add(login);
        frame.add(buttonAdmin);
        frame.add(buttonManager);
        frame.add(buttonUser);


        frame.setVisible(true);
    }
}
