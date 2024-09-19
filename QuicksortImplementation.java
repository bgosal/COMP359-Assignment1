import java.util.Arrays;
import java.util.Random;

public class QuicksortImplementation{

    public static void quicksort(int[] array, int starting_index, int ending_index, String pivot_position){
       
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
      
        return i;
        
    }

    public static int choosePivot(int [] array, int starting_index, int ending_index, String pivot_position){ 
        
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
            array[i] = random.nextInt(max -min+1) + min;
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

        int step = Math.max((max-min)/size,3);  
        
        array[0] = max- random.nextInt(step);   

        for (int i = 1; i < size; i++) {
            array[i] = array[i - 1] - random.nextInt(step + 1);
            if (array[i] < min) {
                array[i] = min;
            }
        }
        return array;
    }

    public static String formatArray(int[] array) {
        int length = array.length;
        
        
        if (length > 10) {
            return Arrays.toString(Arrays.copyOfRange(array, 0, 5)) + " ... " + Arrays.toString(Arrays.copyOfRange(array, length - 5, length));
        } else {
            
            return Arrays.toString(array);
        }
    }

    public static void main(String args[]){

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
        String[] arrayTypes = {"Sorted", "Randomized", "Reversed"};
        
        String[] positions ={"first", "last", "middle", "random"};
        
        for (int i = 0; i< arrays.length; i++) {   	
        	int[] originalArray = arrays[i];
            String arrayType = arrayTypes[i % 3]; 
            int arraySize = originalArray.length;
            System.out.println("****************************************************************************");
            System.out.println(arrayType + " Original Array " + (i + 1) + " with " +arraySize+ " numbers: " + formatArray(originalArray));
        	System.out.println("****************************************************************************");
        	for (String pivots : positions){ 
            
        		double averageTime = 0;
        		int[] arrayCopy = new int[0];
                int pivotIndex = choosePivot(originalArray, 0, originalArray.length - 1, pivots); 
                int pivotValue = originalArray[pivotIndex];
                System.out.println("Initial Chosen Pivot Position: " + pivots + " | Pivot Value: " + pivotValue); 
    			for (int j = 0; j<5; j++) {  
                    arrayCopy = originalArray.clone();  
    				long startTime = System.nanoTime();
    				quicksort(arrayCopy, 0, arrayCopy.length - 1, pivots);        			        			
    				long endTime = System.nanoTime();
    				long elapsedTime = endTime - startTime;
    				averageTime += elapsedTime;
    			}
            
    		averageTime = averageTime/5;	
        	System.out.println(arrayType + " Sorted Array with " + pivots + " pivot: " + formatArray(arrayCopy));
            System.out.println("Average Elapsed Time: " + (averageTime / 1_000_000.0) + " ms");
            System.out.println("----------------------------------------------");
        }
            System.out.println();
            }

        }
    
    }
	
