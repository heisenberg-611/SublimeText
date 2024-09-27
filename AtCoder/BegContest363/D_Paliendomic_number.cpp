#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// Function to check if a number is a palindrome
bool isPalindrome(int num) {
    string s = to_string(num);
    string rev = s;
    reverse(rev.begin(), rev.end());
    return s == rev;
}

// Function to find the N-th smallest palindrome
int nthSmallestPalindrome(int N) {
    if (N <= 0) return -1;  // Invalid input
    int count = 1;
    int num = 0;
    while (count < N) {
        num++;
        if (isPalindrome(num)) {
            count++;
        }
    }
    return num;
}

int main() {
    int N;
    cin >> N;
    int result = nthSmallestPalindrome(N);
    if (result != -1) {
        cout << result << endl;
    }
    return 0;
}