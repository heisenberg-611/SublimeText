#include <iostream>
#include <algorithm>

using namespace std;


string intersect(int a, int b, int c, int d) {
    
    if (min(a, b) < min(c, d) && min(c, d) < max(a, b) && max(a, b) < max(c, d)) {
        return "YES";
    } else if (min(c, d) < min(a, b) && min(a, b) < max(c, d) && max(c, d) < max(a, b)) {
        return "YES";
    } else {
        return "NO";
    }
}

int main() {
    int t;
    cin >> t; 
   
    while (t--) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        cout << intersect(a, b, c, d) << endl;
    }
    
    return 0;
}
