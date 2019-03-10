package webubb.domain;

public class Tuple
{
    private Integer X;
    private Integer Y;

    public Tuple(Integer X,Integer Y)
    {
        this.X = X;
        this.Y = Y;
    }

    public Integer getX() {return X;}
    public Integer getY() {return Y;}
    public String toString(){
        return X + " " + Y;
    }
}
