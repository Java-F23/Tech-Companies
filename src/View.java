import javax.swing.*;
import java.util.ArrayList;

public class View {
    private Controller controller;
    private Welcome_Screen welcome;
    private LoginScreen login;
    private RegistrationScreen register;
    private User currentUser;
    private AdminBoard_UI adminBoardUi;
    private UserBoard_UI userBoardUi;
    public View(Controller control){
        controller = control;
    }

    public void initiate(){
        welcome = new Welcome_Screen(this);
        welcome.initiate();
        currentUser = null;
    }
    public void Login(){
        login = new LoginScreen(this);
        login.setVisible(true);
    }
    public void Register(){
        register = new RegistrationScreen(this);
        register.setVisible(true);
    }
    public User getUser(String username, String password){
        return controller.getUser(username, password);
    }
    public void setUser(User user){
        currentUser = user;
    }
    public void adminBoardInitiate(){
        adminBoardUi = new AdminBoard_UI(this);
    }
    public void userBoardInitiate(){
        userBoardUi = new UserBoard_UI(this);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Company> getCompanies(){
        return controller.getCompanies();
    }

    public ArrayList<Company> getCompaniesByIndustry(String ind){
        return controller.getCompaniesByIndustry(ind);
    }

    public ArrayList<Company> getCompaniesByLocation(String loc){
        return controller.getCompaniesByLocation(loc);
    }

    public ArrayList<Company> getCompaniesByName(String name){
        return controller.getCompaniesByName(name);
    }
    public void addCompany(Company company){
        if(controller.addCompany(company)){
            JOptionPane.showMessageDialog(null, "Company Added");
        }
        else{
            ErrorMessage.show("Can't Add Company. One Already exists with this name");
        }
    }
    public void updateDB(){
        controller.updateDB();
    }
    public boolean checkUsername(String username){
        return controller.checkUsername(username);
    }
    public boolean checkPassword(String password){ return controller.checkPassword(password);}
    public Boolean addUser(User user){
        if(controller.addUser(user)){
            JOptionPane.showMessageDialog(null, "User Registered");
            return true;
        }
        else{
            ErrorMessage.show("An Error Occurred while registering user please try again.");
            return false;
        }
    }
}
