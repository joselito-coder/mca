#include "algo.c"

int main()
{

    // int arr[] = {64, 34, 25, 12, 22, 11, 90};
    // int arr[] = {1, 2, 3, 4, 5, 6, 7};
    int arr[] = {8, 3, 7, -1, 9, 6, 1};

    printf("The array before sorting: ");
    arrayPrinter(arr, ARRAY_SIZE);

    bubbleSort(arr, ARRAY_SIZE);

    printf("The array after sorting: ");
    arrayPrinter(arr, ARRAY_SIZE);

    return 0;
}
