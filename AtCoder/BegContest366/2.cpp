#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    int N;
    cin >> N;

    vector<string> S(N);
    int M = 0;

    // Reading the strings and determining the maximum length M
    for (int i = 0; i < N; ++i) {
        cin >> S[i];
        M = max(M, (int)S[i].length());
    }

    // Initializing T array with '*'
    vector<string> T(M, string(N, '*'));

    // Filling the T strings according to the problem's constraints
    for (int i = 0; i < N; ++i) {
        int row = N - i - 1;  // Corresponding row in the grid
        for (int j = 0; j < S[i].length(); ++j) {
            T[j][row] = S[i][j];
        }
    }

    // Outputting the T strings
    for (int i = 0; i < M; ++i) {
        // Remove trailing '*' characters
        while (!T[i].empty() && T[i].back() == '*') {
            T[i].pop_back();
        }
        cout << T[i] << endl;
    }

    return 0;
}
