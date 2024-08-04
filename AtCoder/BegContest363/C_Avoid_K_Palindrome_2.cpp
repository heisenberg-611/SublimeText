#include <iostream>
#include <string>
#include <algorithm>
#include <unordered_set>

using namespace std;

// Function to check if a string contains a palindromic substring of length K
bool hasPalindromicSubstring(const string& s, int K) {
    int n = s.length();
    for (int i = 0; i <= n - K; i++) {
        bool isPalindrome = true;
        for (int j = 0; j < K / 2; j++) {
            if (s[i + j] != s[i + K - 1 - j]) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            return true;
        }
    }
    return false;
}

int main() {
    int N, K;
    string S;
    cin >> N >> K >> S;

    // Generate all unique permutations of the string S
    sort(S.begin(), S.end());
    unordered_set<string> uniquePermutations;
    
    do {
        uniquePermutations.insert(S);
    } while (next_permutation(S.begin(), S.end()));

    // Count permutations that do not contain a palindromic substring of length K
    int validPermutationsCount = 0;
    for (const string& perm : uniquePermutations) {
        if (!hasPalindromicSubstring(perm, K)) {
            validPermutationsCount++;
        }
    }

    cout << validPermutationsCount << endl;
    return 0;
}