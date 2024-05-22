#include <iostream>
#include <cmath>

using namespace std;

// Function to count the number of lattice points inside or on the circle with radius r
int count_lattice_points(int r) {
    int count = 0;
    // Iterate over x from -r to r
    for (int x = -r; x <= r; x++) {
        // Calculate the maximum value of y such that x^2 + y^2 <= r^2
        int max_y = sqrt(r*r + x*x);
        // Update the count by adding the number of lattice points in the range [0, max_y]
        count += max_y + 1;
    }
    return count;
}

int main() {
    int t;
    cin >> t; // Read number of test cases
    
    // Iterate over test cases
    while (t--) {
        int r;
        cin >> r; // Read input radius
        // Calculate and output the number of lattice points
        cout << count_lattice_points(r) << endl;
    }
    
    return 0;
}
