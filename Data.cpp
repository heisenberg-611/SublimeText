#include <iostream>
#include <vector>
using namespace std;

#define len(x) int((x).size())
#define ll long long
#define ld long double
#define pi pair<int,int>
#define nl '\n';
#define vi vector<int>

int binary_search(int arr[], int n, int x) {
    int left, right, mid;
    left = 0;
    right = n - 1;

    while (left <= right) {
        mid = left + (right - left) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[mid] < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int x, n;
    cin >> n >> x;
    int arr[n];
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    int result = binary_search(arr, n, x);
    cout << result << nl;
    return 0;
}
