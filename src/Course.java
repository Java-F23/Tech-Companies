public class Course extends Resource{
    private int number_of_lectures;
    public Course(String name, String description, String link, int lectures) {
        this.name = name;
        this.Description = description;
        this.link = link;
        this.number_of_lectures = lectures;
    }
    //Setters and getters for its specific fields
    public void setLectureNumber(int lectures){
        number_of_lectures = lectures;
    }
    public int getNumber_of_lectures(){
        return number_of_lectures;
    }
}
