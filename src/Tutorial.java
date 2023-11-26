public class Tutorial extends Resource{
    public int length;
    public Tutorial(String name, String description, String link, int length) {
        this.name = name;
        this.Description = description;
        this.link = link;
        this.length = length;
    }

    //Setters and Getters
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
