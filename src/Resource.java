public class Resource {
    private String name;
    private String Description;
    private String link;

    public Resource(String name, String description, String link) {
        this.name = name;
        this.Description = description;
        this.link = link;
    }

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
