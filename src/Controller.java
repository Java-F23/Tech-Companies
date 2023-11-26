import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private View view;
    private CsvSerializer<Company> companySerializer;
    private CsvSerializer<User> userSerializer;
    private ArrayList<Company> Companies;
    private ArrayList<User> Users;
    private String companyDB; //File location and name
    private String userDB; //File location and name
    //Initialize values of the above fields and starts the view
    public void initiate(){
        companySerializer = new CsvSerializer<Company>();
        userSerializer = new CsvSerializer<User>();
        companyDB = "Companies.csv";
        userDB = "Users.csv";
        Companies = companySerializer.readCsv(companyDB);
        Users = userSerializer.readCsv(userDB);
        view = new View(this);
        view.initiate();
    }

    //Returns a user to the view, returns null if non-exist
    public User getUser(String username, String password){
        for (User user : Users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    //Checks if a username exist in the database
    public Boolean checkUsername(String username){
        for (User user : Users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    //Checks if a password has a correct form
    public Boolean checkPassword(String password) {
        // Define the password pattern using regular expressions
        // Minimum length of 8 characters, at least one uppercase letter, and at least one digit
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(passwordPattern);

        // Match the input string with the pattern
        Matcher matcher = pattern.matcher(password);

        // Return true if the password matches the pattern, indicating it's valid
        return matcher.matches();
    }

    //Returns all companies
    public ArrayList<Company> getCompanies(){
        return Companies;
    }

    //Filters Companies by the given industry
    public ArrayList<Company> getCompaniesByIndustry(String ind){
        ArrayList<Company> results = new ArrayList<>();
        for(Company C: Companies){
            if(C.getIndustry().equals(ind)){
                results.add(C);
            }
        }
        return results;
    }

    //Filters Companies by the given location
    public ArrayList<Company> getCompaniesByLocation(String loc){
        ArrayList<Company> results = new ArrayList<>();
        for(Company C: Companies){
            if(C.getLocation().equals(loc)){
                results.add(C);
            }
        }
        return results;
    }

    //Filters Companies by the given name
    public ArrayList<Company> getCompaniesByName(String name){
        ArrayList<Company> results = new ArrayList<>();
        for(Company C: Companies){
            if(C.getName().equals(name)){
                results.add(C);
            }
        }
        return results;
    }

    //Adds a company to the database
    public Boolean addCompany(Company company){
        boolean unique = true;
        for(Company C : Companies){
            if(C.getName().equals(company.getName())){
                if(C.getLocation().equals(company.getLocation()) && C.getIndustry().equals(company.getIndustry())){
                    unique = false;
                    break;
                }
            }
        }
        if (unique) {
            Companies.add(company);
            updateDB();
            return true;
        }
        else{
            return false;
        }
    }

    //Updates the files of the database, is called whenever the view changes a value and wants to submit it
    public void updateDB(){
        companySerializer.writeCsv(Companies,companyDB);
        userSerializer.writeCsv(Users,userDB);
    }

    //Adds a user to the database, returns true if successful
    public Boolean addUser(User user) {
        if (!checkUsername(user.getUsername())){
            Users.add(user);
            updateDB();
            return true;
        }
        else{
            return false;
        }

    }
}
