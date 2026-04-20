package Test2;

import java.util.ArrayList;

public class Main
{
    static void main()
    {
        Player p = new Player(12,"王");
        Player p2 = p;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(5);
        list.add(2);

        list.sort((s1,s2)->
        {
            return s1 - s2;
        });

        for( Integer i : list)
        {
            System.out.println(i);
        }
//
//        p.method(
//                new Swim()
//                {
//                    @Override
//                    public void swim()
//                    {
//                        System.out.println("我正在游泳");
//                    }
//                }
//        );
//
//        p2.method(()->{
//            System.out.println("我也正在游泳");
//        });
    }
}

