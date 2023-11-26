import java.io.Serializable;

public abstract class Resource implements Serializable {
    protected String name;
    protected String Description;
    protected String link;

    //Setters and getters for the above fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
