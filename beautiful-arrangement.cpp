/*The code uses backtracking to explore all possible arrangements of numbers from 1 to N.
The 'visited' array is employed to keep track of numbers used at each position during the recursive exploration.
The count is incremented whenever a valid arrangement satisfying the conditions is found.
Time Complexity: O(N!) - The algorithm explores all possible permutations of numbers from 1 to N, resulting in a factorial time complexity.

Space Complexity: O(N) - The space is used to store the boolean array 'visited' and the recursive call stack, both of which have a maximum depth of N.
*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
    int count = 0;

public:
    int countArrangement(int N) {
        vector<bool> visited(N + 1, false);
        calculate(N, 1, visited);
        return count;
    }

    void calculate(int N, int pos, vector<bool>& visited) {
        if (pos > N) {
            count++;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
};
