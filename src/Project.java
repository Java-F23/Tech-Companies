import java.math.BigDecimal;
import java.util.ArrayList;

public class Project {
    private ArrayList<Integer> Assigned;
    private String name;
    private float Progress;
    private BigDecimal Revenue;
    private String Description;
    private final int ID;
    public Project(int ID,String name, String description, BigDecimal Revenue){
        this.Assigned = new ArrayList<>();
        this.Progress = 0;
        this.Revenue = Revenue;
        this.Description = description;
        this.ID = ID;
        this.name = name;
    }
    public ArrayList<Integer> getAssigned() {
        return Assigned;
    }

    public void addAssigned(int assigned) {
        Assigned.add(assigned);
    }
    public void removeAssigned(int assigned) {
        Assigned.remove(assigned);
    }

    public float getProgress() {
        return Progress;
    }

    public void setProgress(float progress) {
        Progress = progress;
    }

    public BigDecimal getRevenue() {
        return Revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        Revenue = revenue;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void printProject(){
        System.out.println("Project Name: " + this.getName());
        System.out.println("Project Progress: " + this.getProgress());
        System.out.println("Project Revenue: " + this.getRevenue());
        System.out.println("Project Description: " + this.getDescription());
        printAssigned();
    }
    public void printAssigned(){
        if (this.getAssigned().isEmpty()){
            System.out.println("Project Assigned Employees: None");
        }
        else{
            int i =1;
            System.out.println("Project Assigned Employees: ");
            for (int U : Assigned){
                System.out.println(i + ") " + U);
                i++;
            }
        }
    }
}
