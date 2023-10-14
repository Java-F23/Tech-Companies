import java.util.ArrayList;

public class Database {
    private ArrayList<Company> Companies;
    private ArrayList<User> Users;

    public Database() {
        this.Companies = new ArrayList<>();
        this.Users = new ArrayList<>();
    }

    public ArrayList<Company> getCompanies() {
        return Companies;
    }

    public void addCompany(Company company) {
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
            System.out.println("Company Added Successfuly");
        }
        else{
            System.out.println("Can't Add Company. One Already exists with this name");
        }
    }

    public void removeCompany(int company_index) {
        if(company_index >=0 && company_index < Companies.size()){
            Companies.remove(company_index);
        }
    }
    public ArrayList<Company> getCompaniesByName(String name) {
        ArrayList<Company> results = new ArrayList<>();
        for(Company C: Companies){
            if(C.getName().equals(name)){
                results.add(C);
            }
        }
        return results;
    }
    public ArrayList<Company> getCompaniesByIndustry(String industry) {
        ArrayList<Company> results = new ArrayList<>();
        for(Company C: Companies){
            if(C.getIndustry().equals(industry)){
                results.add(C);
            }
        }
        return results;
    }
    public ArrayList<Company> getCompaniesByLocation(String Location) {
        ArrayList<Company> results = new ArrayList<>();
        for(Company C: Companies){
            if(C.getLocation().equals(Location)){
                results.add(C);
            }
        }
        return results;
    }
    public ArrayList<User> getUsers() {
        return Users;
    }

    public void addUsers(User users) {
        Users.add(users);
    }
}
