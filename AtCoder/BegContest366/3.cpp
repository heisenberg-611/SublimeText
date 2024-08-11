#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    int Q;
    cin >> Q;

    unordered_map<int, int> bag;

    while (Q--) {
        int type, x;
        cin >> type;

        if (type == 1) {
            cin >> x;
            // Put one ball with the integer x into the bag
            bag[x]++;
        } 
        else if (type == 2) {
            cin >> x;
            // Remove one ball with the integer x from the bag
            if (--bag[x] == 0) {
                bag.erase(x);  // Remove the entry if count becomes zero
            }
        } 
        else if (type == 3) {
            // Print the number of different integers in the bag
            cout << bag.size() << endl;
        }
    }

    return 0;
}
