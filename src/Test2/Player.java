package Test2;

public class Player
{
    public String name;
    public int age;

    public Player(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    //<editor-fold desc=" Getter And Setter ">
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    //</editor-fold>

    public void method(Swim s)
    {
        s.swim();
    }

}


