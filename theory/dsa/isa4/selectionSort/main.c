#include "algo.c"


int main(){

    // int arr[] = {1,6,3,5,3,9,6};
    int arr[] = {1,6,3,5,3,9,-6};
    

    printf("The array before sorting: ");
    arrayPrinter(arr, ARRAY_SIZE);

    selectionSort(arr, ARRAY_SIZE);

    printf("The array after sorting: ");
    arrayPrinter(arr, ARRAY_SIZE);




    return 0;

}