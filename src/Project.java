import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Project implements Serializable {
    private ArrayList<Integer> Assigned;
    private String name;
    private float Progress;
    private BigDecimal Revenue;
    private String Description;
    private final int ID;
    //Initializes the above fields
    public Project(int ID,String name, String description, BigDecimal Revenue){
        this.Assigned = new ArrayList<>();
        this.Progress = 0;
        this.Revenue = Revenue;
        this.Description = description;
        this.ID = ID;
        this.name = name;
    }
    //Setters and getters for the fields
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
}
