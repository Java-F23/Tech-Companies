import java.io.Serializable;
import java.util.ArrayList;

public class JobListing implements Serializable {
    private String Name;
    private String jobDescription;
    private ArrayList<User> applicants;

    //Initializes the above fields
    public JobListing(String Name, String jobDescription) {
        this.Name = Name;
        this.jobDescription = jobDescription;
        this.applicants = new ArrayList<>();
    }

    // Getters and Setters for the attributes

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public ArrayList<User> getApplicants() {
        return applicants;
    }

    public void addApplicant(User applicant) {
        this.applicants.add(applicant);
    }

    public void removeApplicant(User applicant) {
        this.applicants.remove(applicant);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}