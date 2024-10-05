#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

#define SIZE 5

// Global semaphore
sem_t semaphore;

// Function to swap two arrays
void* swap_arrays(void* args) {
    int (*arrays)[SIZE] = (int (*)[SIZE])args; // Cast to array of int
    int* array1 = arrays[0];
    int* array2 = arrays[1];

    // Wait for semaphore
    sem_wait(&semaphore);

    // Swap the arrays by reference
    for (int i = 0; i < SIZE; i++) {
        int temp = array1[i];
        array1[i] = array2[i];
        array2[i] = temp;
    }

    // Signal semaphore
    sem_post(&semaphore);

    return NULL;
}

int main() {
    // Initialize two arrays
    int array1[SIZE] = {1, 2, 3, 4, 5};
    int array2[SIZE] = {6, 7, 8, 9, 10};

    // Initialize the semaphore
    sem_init(&semaphore, 0, 1);

    // Prepare arguments for the thread
    int arrays[2][SIZE] = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10} }; // Store both arrays in one 2D array
    pthread_t thread;

    // Create a thread to perform the swap
    pthread_create(&thread, NULL, swap_arrays, (void*)arrays);

    // Wait for the thread to finish
    pthread_join(thread, NULL);

    // Output the results
    printf("Array 1 after swap: ");
    for (int i = 0; i < SIZE; i++) {
        printf("%d ", arrays[0][i]); // Access the swapped first array
    }
    printf("\n");

    printf("Array 2 after swap: ");
    for (int i = 0; i < SIZE; i++) {
        printf("%d ", arrays[1][i]); // Access the swapped second array
    }
    printf("\n");

    // Destroy the semaphore
    sem_destroy(&semaphore);

    return 0;
}
