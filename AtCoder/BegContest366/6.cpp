#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, Q;
    cin >> N >> Q;

    // 3D Array A
    vector<vector<vector<int> > > A(N + 1, vector<vector<int> >(N + 1, vector<int>(N + 1, 0)));
    
    // Read input into A
    for (int x = 1; x <= N; ++x) {
        for (int y = 1; y <= N; ++y) {
            for (int z = 1; z <= N; ++z) {
                cin >> A[x][y][z];
            }
        }
    }

    // Create a prefix sum array P
    vector<vector<vector<int> > > P(N + 1, vector<vector<int> >(N + 1, vector<int>(N + 1, 0)));

    // Calculate the prefix sums
    for (int x = 1; x <= N; ++x) {
        for (int y = 1; y <= N; ++y) {
            for (int z = 1; z <= N; ++z) {
                P[x][y][z] = A[x][y][z] 
                           + P[x-1][y][z] + P[x][y-1][z] + P[x][y][z-1]
                           - P[x-1][y-1][z] - P[x-1][y][z-1] - P[x][y-1][z-1]
                           + P[x-1][y-1][z-1];
            }
        }
    }

    // Process each query
    for (int i = 0; i < Q; ++i) {
        int Lx, Rx, Ly, Ry, Lz, Rz;
        cin >> Lx >> Rx >> Ly >> Ry >> Lz >> Rz;

        int result = P[Rx][Ry][Rz];

        if (Lx > 1) result -= P[Lx-1][Ry][Rz];
        if (Ly > 1) result -= P[Rx][Ly-1][Rz];
        if (Lz > 1) result -= P[Rx][Ry][Lz-1];

        if (Lx > 1 && Ly > 1) result += P[Lx-1][Ly-1][Rz];
        if (Lx > 1 && Lz > 1) result += P[Lx-1][Ry][Lz-1];
        if (Ly > 1 && Lz > 1) result += P[Rx][Ly-1][Lz-1];

        if (Lx > 1 && Ly > 1 && Lz > 1) result -= P[Lx-1][Ly-1][Lz-1];

        cout << result << endl;
    }

    return 0;
}
