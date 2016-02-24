
import java.util.*;

 
 
class Mergesort {
 
      static public void Merge(int [] numbers, int left, int mid, int right)
      {
        int [] recc = new int[100];
        int i, left_end, num_elements, number;
    
        left_end = (mid - 1);
        number = left;
        num_elements = (right - left + 1);
    
        while ((left <= left_end) && (mid <= right))
        {
            if (numbers[left] <= numbers[mid])
                recc[number++] = numbers[left++];
            else
                recc[number++] = numbers[mid++];
        }
    
        while (left <= left_end)
            recc[number++] = numbers[left++];
 
        while (mid <= right)
            recc[number++] = numbers[mid++];
 
        for (i = 0; i < num_elements; i++)
        {
            numbers[right] = recc[right];
            right--;
        }
    }
 
    static public void MergeSort_Recursive(int [] numbers, int left, int right)
    {
      int mid;
    
      if (right > left)
      {
        mid = (right + left) / 2;
        MergeSort_Recursive(numbers, left, mid);
        MergeSort_Recursive(numbers, (mid + 1), right);
    
        Merge(numbers, left, (mid+1), right);
      }
    }
 
     public static void main(String[] args)
      {
        int[] numbers = {1,3,6,9,3,5,4,3,7,8 };
        int length = 9;
        MergeSort_Recursive(numbers, 0, length - 1);
        for (int i = 0; i < 9; i++)
            System.out.println(numbers[i]);
       
    }
}