// Time Complexity: O(2^n)
// Space Complexity: O(1)

class Solution {
    int count;

    public int countArrangement(int n) {
        permutations(n, new ArrayList<>());
        return count;
    }

    private void permutations(int n, List<Integer> path) {
        // base
        if (path.size() != 0
                && !(path.get(path.size() - 1) % path.size() == 0 || path.size() % path.get(path.size() - 1) == 0)) {
            return;
        }
        if (n == path.size()) {
            count++;
            return;
        }

        // logic
        for (int i = 0; i < n; i++) {
            if (!path.contains(i + 1)) {
                path.add(i + 1);
                permutations(n, path);
                path.remove(path.size() - 1);
            }
        }
    }
}