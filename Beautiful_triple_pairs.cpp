#include <iostream>
#include <unordered_map>
#include <vector>
#include <tuple>

using namespace std;

struct VectorHash {
    size_t operator()(const vector<int>& v) const {
        size_t seed = v.size();
        for (auto& i : v) {
            seed ^= i + 0x9e3779b9 + (seed << 6) + (seed >> 2);
        }
        return seed;
    }
};

void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    unordered_map<vector<int>, int, VectorHash> cnt; // Use vector for triplet key with custom hash function

    int ans = 0;
    for (int i = 0; i < n - 2; ++i) {
        vector<int> triplet = {a[i], a[i + 1], a[i + 2]};
        vector<vector<int>> mist = {
            {0, a[i + 1], a[i + 2]},
            {a[i], 0, a[i + 2]},
            {a[i], a[i + 1], 0}
        };

        for (const vector<int>& trip : mist) {
            ans += cnt[trip] - cnt[triplet];
            cnt[trip]++;
        }
        cnt[triplet]++;
    }

    cout << ans << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        solve();
    }

    return 0;
}
