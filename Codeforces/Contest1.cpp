#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int t;
    cin >> t; // Read number of test cases
    
    while (t--) {
        int x, y;
        cin >> x >> y; // Read input integers
        
        // Output minimum and maximum of x and y
        cout << min(x, y) << " " << max(x, y) << endl;
    }
    
    return 0;
}
