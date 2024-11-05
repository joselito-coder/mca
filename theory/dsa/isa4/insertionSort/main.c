#include "algo.c"

int main()
{

    int arr[] = {8, 33, 37, -1, 9, 6, 1};

    printf("The array before sorting: ");
    arrayPrinter(arr, ARRAY_SIZE);

    insertionSort(arr, ARRAY_SIZE);

    printf("The array after sorting: ");
    arrayPrinter(arr, ARRAY_SIZE);

    return 0;
}
