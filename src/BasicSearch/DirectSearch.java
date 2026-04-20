package BasicSearch;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectSearch
{

    public DirectSearch()
    {
        int[] arr = {0,24,31,324,6644};
        System.out.println(searchDemo(arr));
        System.out.println(binarySearch(arr));
        System.out.println(binarySearchDif(arr));

    }

    private static int searchDemo(int[] arr)
    {
        int search = 31;
        for (int i = 0; i < arr.length; i++)
        {
            if(search == arr[i])
                return i;
        }
        return -1;
    }

    private static ArrayList<Integer> search2(int[] arr)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        int search = 31;
        for (int i = 0; i < arr.length; i++)
        {
            if ( search == i )
                list.add((i));
        }

        return list;
    }

    public static int binarySearch (int[] arr)
    {
        int i = 31;
        int left = 0;
        int right = arr.length - 1;

        while ( left <= right )
        {
            int mid = left + (right-left)/2;

            if ( arr[mid] < i )
            {
                left = mid + 1;
            }else if ( arr[mid] > i)
            {
                right = mid - 1;
            }else
            {
                return mid;
            }

        }
        return -1;
    }
    public static int binarySearchDif(int[] arr) {
        int target = 31;  // 要查找的值
        int left = 0;
        int right = arr.length - 1;

        while (left <= right && target >= arr[left] && target <= arr[right]) {
            // 插值查找公式（正确！）
            int mid = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left]);

            if (arr[mid] == target) {
                return mid;  // 找到了
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // 没找到
    }
}
