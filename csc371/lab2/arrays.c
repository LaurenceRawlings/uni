double mean(int length, int *arr) {
    int total = 0;
    
    int i;
    for (i = 0; i < length; i++) {
        total += arr[i];
    }

    return total / length;
}