//Time n * n!
//Space n * n!
//Leetcode: yes
//Issue seen: none
class Solution {
public:
    int count = 0;
    void helper(int n, int i, vector<int>& perm) {

        // base
        if (i == perm.size()) {
            count++;
            return;
        }

        for (int pick = i; pick < perm.size(); pick++) {
            swap(perm[i], perm[pick]);
            if ((perm[i] % i) == 0 || (i % perm[i] == 0)) {
                helper(n, i + 1, perm);
            }
            swap(perm[i], perm[pick]);
        }
    }
    int countArrangement(int n) {
        vector<int> perm;
        for (int i = 0; i <= n; i++) {
            perm.push_back(i);
        }
        helper(n, 1, perm);
        return count;
    }
};
