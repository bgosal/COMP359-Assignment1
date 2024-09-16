import java.util.Arrays;
import java.util.Random;

public class QuicksortImplementation{


    public static void quicksort(int[] array, int starting_index, int ending_index, String pivot_position){
        //System.out.println("Quicksort called on: " + Arrays.toString(array) + " from index " + starting_index + " to " + ending_index);
        if(starting_index < ending_index){
            
            int pivot_index = partition(array, starting_index, ending_index, pivot_position);

            quicksort(array, starting_index, pivot_index-1, pivot_position);
            quicksort(array, pivot_index+1, ending_index, pivot_position);

        }

        
        
    }  


    public static int partition(int []array, int starting_index, int ending_index, String pivot_position){
        
        int pivot_Index = choosePivot(array, starting_index, ending_index, pivot_position);
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

    public static int choosePivot(int [] array, int starting_index, int ending_index, String pivot_position){ //only choose the middle pivot for now 
        
        Random random = new Random();


        if (pivot_position.equals("first")){
            return starting_index;
        }

        else if (pivot_position.equals("last")){
            return ending_index;
        }

        else if (pivot_position.equals("middle")){
            return (starting_index + ending_index) / 2;
        }


        else if (pivot_position.equals("random")){
            return random.nextInt(ending_index - starting_index + 1) + starting_index;
        }

        else{
            
            return random.nextInt(ending_index - starting_index + 1) + starting_index;
        }

        
     
        
    }

    public static void swap(int []array, int index1, int index2){

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }


    public static int[] generateRandomArray(int size, int min, int max){
        int[] array = new int[size];
        Random random = new Random();

        for(int i =0; i<size; i++){
            array[i] = random.nextInt(max -min +1) + min;
        }
        return array;

    }

    public static int[] generateSortedArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
    
        int step = Math.max((max - min) / size, 1);
    
        array[0] = min + random.nextInt(step);
    
        for (int i = 1; i < size; i++) {
            array[i] = array[i - 1] + random.nextInt(step + 1);
            if (array[i] > max) {
                array[i] = max;
            }
        }
    
        return array;
    }
    
    public static int[] generateReverseSortedArray(int size, int min, int max){
        int[] array = new int[size];
        Random random = new Random();

        int step = Math.max((max-min)/size,3);  //adjusted the step slightly to better accommodate the range for the larger arrays
        
        array[0] = max- random.nextInt(step);   

        for (int i = 1; i < size; i++) {
            array[i] = array[i - 1] - random.nextInt(step + 1);
            if (array[i] < min) {
                array[i] = min;
            }
        }
        return array;

    }


    public static void main(String args[]){


        //int[] array1= generateRandomArray(10, -100, 100);
        //int[] array1 = {8, 1, 6, 9, 6, 3, 5, 2, 7, 0};
        //int[] array1= generateSortedArray(5, 0, 10);
    	//int[] array1= generateReverseSortedArray(10, 0, 99);
        //System.out.println("Original Array 1: " + Arrays.toString(a1));
        
        int[] a1 = generateSortedArray(10, 0, 100);
        int[] a2 = generateRandomArray(10, 0, 100);
        int[] a3 = generateReverseSortedArray(10, 0, 100);    
        
        int[] a4 = generateSortedArray(100, 0, 500);
        int[] a5 = generateRandomArray(100, 0, 500);
        int[] a6 = generateReverseSortedArray(100, 0, 500);
        
        int[] a7 = generateSortedArray(1000, 0, 1500);
        int[] a8 = generateRandomArray(1000, 0, 1500);
        int[] a9 = generateReverseSortedArray(1000, 0, 1500);
        
        int [][] arrays = {a1, a2, a3, a4, a5, a6, a7, a8, a9};
        
        String[] positions ={"First", "Last", "Middle", "Random"};
        
        for (int i = 0; i<9; i++) {   	
        	int[] arrayCopy = arrays[i].clone();
        	
        	for (String pivots : positions){ 
        		double averageTime = 0;
        		
    			for (int j = 0; j<6; j++) {     
    				long startTime = System.nanoTime();
    				quicksort(arrayCopy, 0, arrayCopy.length - 1, pivots);        			        			
    				long endTime = System.nanoTime();
    				long elapsedTime = endTime - startTime;
    				averageTime += elapsedTime;
    			}
            
    		averageTime = averageTime/5;	
        	System.out.println("Array " + (i+1) + " with: " + pivots + " pivot: " + Arrays.toString(arrayCopy));
        	System.out.println("AVERAGE Elapsed Time: " + (averageTime/1_000_000.0) + "ms"); 
        	
            }

        }
        

        //Added new array creation functions (random, sorted, unsorted) to create even more arrays for testing purposes
        //Random

		// int[] array1 = {8, 1, 6, 9, 6, 3, 5, 2, 7, 0};
        // System.out.println("Original Array 1: " + Arrays.toString(array1));
        // quicksort(array1, 0, array1.length - 1);
        // System.out.println("Sorted Array 1: " + Arrays.toString(array1));

        // int[] array2 = {9, 5, 9, 4, 2, 3, 1, 0};
        // System.out.println("Original Array 2: " + Arrays.toString(array2));
        // quicksort(array2, 0, array2.length - 1);
        // System.out.println("Sorted Array 2: " + Arrays.toString(array2));

        // int[] array3 = {12, 99, 50, 49, 36, 0, 5, 5, 5, 79, 101};
        // System.out.println("Original Array 3: " + Arrays.toString(array3));
        // quicksort(array3, 0, array3.length - 1);
        // System.out.println("Sorted Array 3: " + Arrays.toString(array3));
    }
	
}
