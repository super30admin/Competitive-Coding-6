// Used backtracking to build arrangements of numbers from 1 to n, 
// adding a number only if it hasn’t been used and satisfies (i % pivot == 0 || pivot % i == 0).
// Recurse by increasing the pivot and try all valid numbers, counting arrangements when the list size reaches n.

// Backtrack by removing the last number after each recursive call to explore other possibilities.
// Time Complexity: Roughly O(N)
// Space Complexity: O(N)
public class Solution
{
    int count = 0;
    public int CountArrangement(int n)
    {
        backtrack(n, 1, new List<int>());
        return count;
    }
    public void backtrack(int n, int pivot, List<int> list)
    {
        if (n == list.Count)
        {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++)
        {
            if (!list.Contains(i) && (i % pivot == 0 || pivot % i == 0))
            {
                list.Add(i);
                backtrack(n, pivot + 1, list);
                list.Remove(i);
            }

        }
    }
}