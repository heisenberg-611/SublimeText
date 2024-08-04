// /*In AtCoder, a user's rating is given as a positive integer, and based on this value, a certain number of ^ is displayed. Specifically, when the rating is between 
// 1 and 
// 399, inclusive, the display rules are as follows:

// When the rating is between 
// 1 and 
// 99, inclusive, ^ is displayed once.
// When the rating is between 
// 100 and 
// 199, inclusive, ^ is displayed twice.
// When the rating is between 
// 200 and 
// 299, inclusive, ^ is displayed three times.
// When the rating is between 
// 300 and 
// 399, inclusive, ^ is displayed four times.
// Currently, Takahashi's rating is 
// R. Here, it is guaranteed that 
// R is an integer between 
// 1 and 
// 299, inclusive.
// Find the minimum increase in rating required for him to increase the number of displayed ^.
// It can be proved that under the constraints of this problem, he can increase the number of ^ without raising his rating to 
// 400 or above.

// Constraints
// 1≤R≤299
// R is an integer.*/
// #include <bits/stdc++.h>
// #include <iostream>
// using namespace std;
// #define nl endl;
// int main()
// {
//     int count = 0;
//     int n;
//     int add;
//     cin >> n;
//     i  f (n >= 1 && n <= 299)
//     {
//         if (n >= 1 && n <= 99)
//         {
//             count = 1;
//         }
//         if (n >= 100 && n <= 199)
//         {
//             count = 2;
//         }
//         if (n >= 200 && n <= 299)
//         {
//             count = 3;
//         }
//         if (n >= 300 && n <= 399)
//         {
//             count = 4;
//         }
//         if (count == 1)
//         {
//             add = 99 - n;
//             cout << add << nl;
//         }
//         else if (count == 2)
//         {
//             add = 200 - n;
//             cout << add << nl;
//         }
//         else if (count == 3)
//         {
//             add = 300 - n;
//             cout << add << nl;
//         }
//         else if (count == 4){
//             add = 0;
//             cout << add << nl;
//         }
//     }
//     return 0;
// }
#include <iostream>

using namespace std;

int main() {
    int rating;
    cin >> rating;

    int next_rating_for_more_stars = 100;
    if (rating >= 100) {
        next_rating_for_more_stars = 200;
    }
    if (rating >= 200) {
        next_rating_for_more_stars = 300;
    }

    int increase = next_rating_for_more_stars - rating;
    cout << increase << endl;

    return 0;
}