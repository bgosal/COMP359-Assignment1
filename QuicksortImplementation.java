import java.util.Arrays;
import java.util.Random;

public class QuicksortImplementation{


    public static void quicksort(int[] array, int starting_index, int ending_index){
        //System.out.println("Quicksort called on: " + Arrays.toString(array) + " from index " + starting_index + " to " + ending_index);
        if(starting_index < ending_index){
            
            int pivot_index = partition(array, starting_index, ending_index);

            quicksort(array, starting_index, pivot_index-1);
            quicksort(array, pivot_index+1, ending_index);

        }

        
        
    }  


    public static int partition(int []array, int starting_index, int ending_index){
        
        int pivot_Index = choosePivot(array, starting_index, ending_index);
        int pivot_Value = array[pivot_Index];

        swap(array, pivot_Index, ending_index);


        pivot_Index = ending_index;

        int i = starting_index;
        int j = ending_index-1;

        //System.out.println("Partitioning: " + Arrays.toString(array) + " with pivot value " + pivot_Value);

        while (i<=j){
            while (i<=j && array[i]<=pivot_Value){
                i++;
            }

            while (i<=j && array[j]>=pivot_Value){
                j--;
            }   

            if (i<j){
                swap(array, i, j);
                i++;
                j--;
            }

        }

        swap(array,i, ending_index);
       // System.out.println("Partitioned: " + Arrays.toString(array) + " with pivot index " + i);
        return i;
        
    }

    public static int choosePivot(int [] array, int starting_index, int ending_index){ //only choose the middle pivot for now 
        int middle_pivot = ((starting_index+ending_index )/2);
        return middle_pivot;
        
     // int first_pivot = starting_index;
     // return first_pivot;
        		
     // int last_pivot = ending_index;
     // return last_pivot;
        
     
        
    }

    public static void swap(int []array, int index1, int index2){

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }




    public static void main(String[] args){

    

		int[] array1 = {8, 1, 6, 9, 6, 3, 5, 2, 7, 0};
        System.out.println("Original Array 1: " + Arrays.toString(array1));
        quicksort(array1, 0, array1.length - 1);
        System.out.println("Sorted Array 1: " + Arrays.toString(array1));

        int[] array2 = {9, 5, 9, 4, 2, 3, 1, 0};
        System.out.println("Original Array 2: " + Arrays.toString(array2));
        quicksort(array2, 0, array2.length - 1);
        System.out.println("Sorted Array 2: " + Arrays.toString(array2));

        int[] array3 = {12, 99, 50, 49, 36, 0, 5, 5, 5, 79, 101};
        System.out.println("Original Array 3: " + Arrays.toString(array3));
        quicksort(array3, 0, array3.length - 1);
        System.out.println("Sorted Array 3: " + Arrays.toString(array3));

	}




}