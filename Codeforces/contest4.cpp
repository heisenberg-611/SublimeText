#include <iostream>
#include <string>

using namespace std;

// Function to find the minimum number of pieces needed to cut the binary string
int min_pieces_to_sort(string binary_string) {
    // Initialize count and prev_char
    int count = 0;
    char prev_char = binary_string[0];

    // Iterate through the binary string
    for (char &c : binary_string) {
        // If the current character is different from the previous character, increment count
        if (c != prev_char) {
            count++;
            prev_char = c;
        }
    }

    // Return count
    return max(0, count - 1);
}

int main() {
    int t;
    cin >> t; // Read number of test cases
    
    // Iterate over test cases
    while (t--) {
        string binary_string;
        cin >> binary_string; // Read input binary string

        // Output the minimum number of pieces needed
        cout << min_pieces_to_sort(binary_string) << endl;
    }

    return 0;
}
