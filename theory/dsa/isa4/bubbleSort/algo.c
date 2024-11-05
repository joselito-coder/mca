#include "header.h"

// perform the bubble sort
void bubbleSort(int array[], int size) {

  // loop to access each array element
  for (int step = 0; step < size - 1; ++step) {
      

    for (int i = 0; i < size - step - 1; ++i) {
      
 
      if (array[i] > array[i + 1]) {
   
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;

      }
    }
  }
}

