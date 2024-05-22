#include <iostream>
#include <cmath>

int main() {
    int nt;
    std::cin >> nt; // Read the number of test cases
    
    for (int t = 0; t < nt; ++t) {
        int x, y;
        std::cin >> x >> y; // Read the number of 1x1 and 2x2 icons
        
        int mm = (y + 1) / 2; // Calculate the number of screens needed for 2x2 icons
        x -= (mm * 15 - y * 2 * 2); // Adjust the remaining number of 1x1 icons
        x = std::max(x, 0); // Ensure non-negative number of 1x1 icons remaining
        mm += (x + 15 - 1) / (15); // Calculate additional screens needed for remaining 1x1 icons
        
        std::cout << mm << std::endl; // Output the total number of screens needed
    }
    
    return 0;
}
