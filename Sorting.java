package scratchbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Indra
 */
public class Sorting {
    private static int comparisonCounter = 0;
    private static int variableCounter = 0;
    public static int i;
    public static void quickSort(int array[])
    {
        comparisonCounter = 0;
        variableCounter = 0;
        System.out.println("Process : ");
        quickSort(array, 0, array.length-1);
        printArray(array);
        System.out.println("Comparison(s) : " + comparisonCounter + " Swap(s) : " + variableCounter);
    }
    public static void quickSort(int array[], int start, int end)
    {
        int left = start;
        int right = end;
        int pivot = left;
        if((end-start) < 1)
        {
            return;
        }
        while(left < right)
        {
            if(array[right] < array[left])
            {
                swap(array, left, right);
                variableCounter++;
                printArray(array);
                if(pivot == left)
                {
                    pivot = right;
                }
                else
                {
                    pivot = left;
                }
            }
            else if(pivot == left)
            {
                right--;
            }
            else
            {
                left++;
            }
            comparisonCounter++;
        }
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }
    public static void mergeSort(int arr[], int start, int end)
    {
        int left = start;
        int right = (start+end)/2 + 1;
        int[] tempArray = new int[arr.length];
        if(end - start>0)
        {
            mergeSort(arr, start, right-1);
            mergeSort(arr,right, end);
        }
        int mergeIterator = start;
        while(left < (start+end)/2 + 1 && right <= end)
        {
            if(arr[left] < arr[right])
            {
                tempArray[mergeIterator] = arr[left];
                left++;
            }
            else
            {
                tempArray[mergeIterator] = arr[right];
                right++;
            }
            variableCounter++;
            comparisonCounter++;
            mergeIterator++;
        }
        if(left >= (start+end)/2 + 1)
        {
            while(right <= end)
            {
                variableCounter++;
                tempArray[mergeIterator] = arr[right];
                mergeIterator++;
                right++;
            }
        }
        else
        {
            while(left < (start+end)/2 + 1)
            {
                variableCounter++;
                tempArray[mergeIterator] = arr[left];
                mergeIterator++;
                left++;
            }
        }
        comparisonCounter++;
        for(int j = start; j<=end; j++)
        {
            arr[j] = tempArray[j];
        }
        printArray(arr);
    }
    public static void mergeSort(int arr[])
    {
        comparisonCounter = 0;
        variableCounter = 0;
        System.out.println("Process : ");
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Comparison(s) : " + comparisonCounter + " Variable Assignment(s) : " + variableCounter);
    }
    public static void swap(int array[], int index1, int index2)
    {
        int temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }
    public static void printArray(int array[])
    {
        for(int j: array)
        {
            System.out.print(j + " ");
        }
        System.out.println("");
    }
}
