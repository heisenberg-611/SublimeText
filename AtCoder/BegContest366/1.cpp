#include <iostream>
using namespace std;

int main() {
    int N, T, A;
    cin >> N >> T >> A;

    // Calculate the remaining votes
    int remainingVotes = N - (T + A);

    // Check if Takahashi has already won
    if (T > A + remainingVotes) {
        cout << "Yes" << endl;
    }
    // Check if Aoki has already won
    else if (A > T + remainingVotes) {
        cout << "Yes" << endl;
    }
    // Otherwise, the outcome is not yet decided
    else {
        cout << "No" << endl;
    }

    return 0;
}
