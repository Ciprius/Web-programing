package webubb.domain;

public class Link {
    private String Name1;
    private String Name2;
    private String Duration;
    private String Direction;

    public Link(String Name1,String Name2,String Duration,String Direction){
        this.Name1 = Name1;
        this.Name2 = Name2;
        this.Direction = Direction;
        this.Duration = Duration;
    }

    public String getDirection() {
        return Direction;
    }

    public String getDuration() {
        return Duration;
    }

    public String getName1() {
        return Name1;
    }

    public String getName2() {
        return Name2;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }
}
