#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxMinCharm(const vector<int>& appetizers, const vector<int>& mainDishes) {
  int n = appetizers.size();

  // Sort appetizers and main dishes in descending order
  vector<int> sortedAppetizers = appetizers;
  vector<int> sortedMainDishes = mainDishes;
  sort(sortedAppetizers.rbegin(), sortedAppetizers.rend());
  sort(sortedMainDishes.rbegin(), sortedMainDishes.rend());

  // Calculate the absolute difference (charm) for each possible pairing
  vector<int> charm(n);
  for (int i = 0; i < n; ++i) {
    charm[i] = abs(sortedAppetizers[i] - sortedMainDishes[i]);
  }

  // Find the minimum charm value
  int minCharm = *min_element(charm.begin(), charm.end());

  return minCharm;
}

int main() {
  int t;
  cin >> t;

  while (t--) {
    int n;
    cin >> n;

    vector<int> appetizers(n), mainDishes(n);
    for (int i = 0; i < n; ++i) {
      cin >> appetizers[i];
    }
    for (int i = 0; i < n; ++i) {
      cin >> mainDishes[i];
    }

    int maxMin = maxMinCharm(appetizers, mainDishes);
    cout << maxMin << endl;
  }

  return 0;
}
