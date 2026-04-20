package Lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Lambda
{

    public Lambda()
    {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = { 12, 24, 42, 2, 23};

        int[] arr2 = Arrays.copyOf(arr,3);
        System.out.println("Arrays的copyof与toString用法");
        System.out.println(Arrays.toString(arr2));


        int[] arr3 = Arrays.copyOfRange(arr,2,3);  // 只包含左边的，不包含右边的，所以是42
        System.out.println("Arrays的copyOfRange的用法");
        System.out.println(Arrays.toString(arr3));
        int[] arr4 = Arrays.copyOfRange(arr,0,10);  // 后面所有的元素改为零
        System.out.println(Arrays.toString(arr4));

        Arrays.sort(arr);
        System.out.println("Arrays的sort方法，应该默认是升序排序");
        System.out.println(Arrays.toString(arr));

        Integer[] arr6 = {12,31,22,2};
        System.out.println("Arrays中的sort方法加上comparator类型");

        Arrays.sort(arr6, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;  // o1 表示的是将要对比的元素 ,o2表示排好序的元素, 感觉好难
                // o1 对比 o2中的元素对比是用二分法来快速确定位置
            }
        });
        System.out.println(Arrays.toString(arr6));

        Integer[] arr7 = {2,3,42,12};
        System.out.println("Lambda的使用");
        Arrays.sort(arr7, (s1, s2) -> s1 - s2);

        method(
                ()->{
                    System.out.println("有用");
                }
        );


    }
    public void method(Swim s){
        s.swim();
    }
}

interface Swim
{
    public abstract void swim();
//    public abstract void swim2();
}

interface SayHello
{
    public abstract void swim();
}