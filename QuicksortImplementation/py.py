import random
import time
import copy
import sys
sys.setrecursionlimit(2000)


def quicksort(arr, starting_index, ending_index, pivot_position):
    if (starting_index < ending_index):
        pivot_index = partition(arr, starting_index, ending_index, pivot_position)

        quicksort(arr, starting_index, pivot_index-1, pivot_position)
        quicksort(arr, pivot_index+1, ending_index, pivot_position)



def partition(arr, starting_index, ending_index, pivot_position):
    pivot_index = choosePivot(arr, starting_index, ending_index, pivot_position)
    pivot_Value = arr[pivot_index]

    swap(arr, pivot_index, ending_index)
    pivot_index = ending_index

    i = starting_index
    j = ending_index-1

    while (i<=j):
        while (i<=j and arr[i]<=pivot_Value):
            i+= 1

        while (i<=j and arr[j]>=pivot_Value):
            j-= 1

        if  (i<j):
            swap(arr, i ,j)
            i+= 1
            j-= 1


    swap(arr, i, ending_index)
    return i

def choosePivot(arr, starting_index, ending_index, pivot_position):
    if (pivot_position == 'first'):
        return  starting_index
    elif (pivot_position == 'last'):
        return ending_index
    elif (pivot_position == 'middle'):
        return (starting_index+ending_index)//2
    elif (pivot_position == 'random'):
        return random.randint(starting_index, ending_index)
    else:
        raise ValueError("Invalid pivot position specified.")
    

def swap(arr, index1, index2):
    temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
    

def generateRandomArray(size, mins, maxs):
    arr = [0] * size
    for i in range (size):
        arr[i] = random.randint(mins, maxs)
    return arr

def generateSortedArray(size, mins, maxs):
    arr = [0] * size
    step = max((maxs - mins)//size, 1)
    arr[0] = mins + random.randint(0,step+1) 
    for i in range (1, size):
        arr[i] = arr[i-1] + random.randint(0,step)
        if (arr[i] > maxs):
            arr[i] = maxs
    return arr

def generateReverseSortedArray(size, mins, maxs):
    arr = [0] * size
    step = max((maxs - mins)//size, 3)
    arr[0] = maxs - random.randint(0,step+1) 
    for i in range (1, size):
        arr[i] = arr[i-1] - random.randint(0,step)
        if (arr[i] < mins):
            arr[i] = mins
    return arr

def formatArray(arr):
    length = len(arr)
    if (length > 10):
        return str(arr[:5])+ ". . ." + str(arr[length-5:length])
    else:
        return str(arr)

def main():
    a1 = generateSortedArray(10, 0, 100)
    a2 = generateRandomArray(10, 0, 100)
    a3 = generateReverseSortedArray(10, 0, 100) 
        
    a4 = generateSortedArray(100, 0, 500)
    a5 = generateRandomArray(100, 0, 500)
    a6 = generateReverseSortedArray(100, 0, 500)
        
    a7 = generateSortedArray(1000, 0, 1500)
    a8 = generateRandomArray(1000, 0, 1500)
    a9 = generateReverseSortedArray(1000, 0, 1500)
        
    arrays = [a1, a2, a3, a4, a5, a6, a7, a8, a9]
    arrayTypes = ['Sorted', 'Randomized', 'Reversed']
    positions = ['first', 'last', 'middle', 'random']

    for i in range(len(arrays)):
        originalArray = arrays[i]
        arrayType = arrayTypes[i%3]
        arraySize = len(originalArray)
        print('****************************************************************************')
        print(arrayType, ' Original Array ',(i + 1),' with ',arraySize,' numbers: ',formatArray(originalArray))
        print('****************************************************************************')

        for pivots in positions:
            pivotIndex = choosePivot(originalArray, 0, len(originalArray) - 1, pivots)
            pivotValue = originalArray[pivotIndex]
            print('Initial Chosen Pivot Position: ', pivots ,' | Pivot Value: ', pivotValue)
            averageTime = 10
            arrayCopy = [0]*arraySize
            
            j = 0
            while (j<5): 
                arrayCopy = copy.deepcopy(originalArray)
                startTime = time.perf_counter_ns()
                quicksort(arrayCopy, 0, len(arrayCopy) - 1, pivots)                                     
                endTime = time.perf_counter_ns()
                elapsedTime = endTime - startTime
                averageTime += elapsedTime
                j +=1

            averageTime = float(averageTime/5)
            averageTime = float(averageTime/1_000_000)
            print(arrayType, ' Sorted Array with ' ,pivots, ' pivot: ' ,formatArray(arrayCopy))
            print(f'Average Elapsed Time: {averageTime:.4f} ms')    
            print('----------------------------------------------')
 
        print('')
            
main()  

                
            
           
    

    
