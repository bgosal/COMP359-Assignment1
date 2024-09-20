# COMP359- Assignment 1 
Compare quicksort against itself when implemented with different choices of pivot selection strategies.

## Objective

Our goal is to empirically measure the time efficiency of quicksort on a variety of arrays with different constraints. We account for pivot position, pre-sorting status, and size of the array. We also consider the impact of differing hardware and system environments on the timing results. 

## Work Log 

**Bhupinder:** Pseudocode, Programming, Graphs/Spreadsheets

**Justina:** Outline/Written Document, Graphs/Spreadsheets, References

**Noor:** Programming, Presentation Slides, Video Editing




## Pseudocode

        Function quicksort(array, first_index, last_index, pivotPosition):
  
          If first_index < last_index:  // Check if there are at least 2 values

            pivotIndex = partition(array, first_index, last_index, pivotPosition) // Partition the array and get the pivot’s final index

            quicksort(array, first_index, pivotIndex - 1, pivotPosition) // Sort left subarray

            quicksort(array, pivotIndex + 1, last_index, pivotPosition) // Sort right subarray

          End If

        End Function




        
        Function partition(array, starting_index, ending_index, pivotPosition):
  
          pivotIndex = choosePivot(array, starting_index, ending_index, pivotPosition) // Select the pivot
  
          pivotValue = array[pivotIndex]     // Value of pivot
  
          Swap array[pivotIndex] with array[ending_index]  // Swap the pivot with the last element temporarily
  
          i = starting_index      // Start pointer at the beginning of array
          j = ending_index - 1     // Start pointer one position before the pivot
  
          While i <= j: 
    
            While i <= j and array[i] <= pivotValue:   			
                i = i + 1    // Move pointer `i` to the right until an element greater than the pivot is found
            End While
    
            While i <= j and array[j] >= pivotValue:
                j = j - 1    // Move pointer `j` to the left until an element smaller than the pivot is found
            End While
    
            If i < j:    
                Swap array[i] with array[j]   // Swap the values at positions `i` and `j`
                i = i + 1
                j = j - 1
            End If
    
          End While
  
          Swap array[i] with array[ending_index]  // Swap the pivot back to its correct position
      
          Return i   // Return the index of the pivot after partitioning
  
        End Function




      
        Function swap(array, index1, index2):
  
          Temp = array[index1]  // The value at index1 is stored temporarily
      
          array[index1] = array[index2]  // The value at index2 is assigned to index1
      
          array[index2] = Temp  // The temporarily stored value is assigned to index2
  
        End Function




        
        Function choosePivot(array, starting_index, ending_index, pivotPosition):
    
          If pivotPosition = "first":
              Return starting_index   // The pivot will be the first value of the array
      
          If pivotPosition = "last":
              Return ending_index   // The pivot will be the last value of the array
      
          If pivotPosition = "middle":
              Return (starting_index + ending_index) // 2   // The pivot will be the middle value of the array
      
          If pivotPosition = "random":
              Return random integer between starting_index and ending_index   // The pivot will be a random value between the start and end indices
    
        End Function
    
          

## References
1. M. A. Shaffer, *Data Structures and Algorithm Analysis in Java*, 3rd ed. [Online]. Available: https://people.cs.vt.edu/~shaffer/Book/JAVA3elatest.pdf
2. C. A. R. Hoare, "Quicksort," *The Computer Journal*, vol. 5, no. 1, pp. 10–16, 1962. [Online]. Available: https://doi.org/10.1093/comjnl/5.1.10
