#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

struct Disk {
    int x, y, r;
};

bool canAdjustRadii(const vector<Disk>& disks) {
    int n = disks.size();

    // Check if the sum of radii strictly decreases
    double originalSum = 0.0;
    for (const Disk& disk : disks) {
        originalSum += disk.r;
    }

    // Check if no two disks overlap
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            double distance = hypot(disks[i].x - disks[j].x, disks[i].y - disks[j].y);
            if (disks[i].r + disks[j].r >= distance) {
                return false;
            }
        }
    }

    // All conditions satisfied
    return true;
}

int main() {
    int n;
    cin >> n;

    vector<Disk> disks(n);
    for (int i = 0; i < n; ++i) {
        cin >> disks[i].x >> disks[i].y >> disks[i].r;
    }

    if (canAdjustRadii(disks)) {
        cout << "YES\n";
    } else {
        cout << "NO\n";
    }

    return 0;
}
