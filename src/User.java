import java.util.ArrayList;

public class User {
    private static int users = 0;
    private String username;
    private String password;
    private ArrayList<Company> favoriteCompanies;

    private final Boolean admin;

    private int ID;

    public User(String username, String password, Boolean ad) {
        this.username = username;
        this.password = password;
        this.favoriteCompanies = new ArrayList<>();
        this.admin = ad;
        users++;
        this.ID = users;
    }

    // Getters and Setters for the attributes

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Company> getFavoriteCompanies() {
        return favoriteCompanies;
    }

    public void addFavoriteCompany(Company company) {
        this.favoriteCompanies.add(company);
    }

    public void removeFavoriteCompany(Company company) {
        this.favoriteCompanies.remove(company);
    }
    public Boolean getAdmin() {
        return admin;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public static int getUserCount() {
        return users;
    }
}