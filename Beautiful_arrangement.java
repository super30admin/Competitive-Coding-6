// Time Complexity : O(N!)
// Space Complexity : O(depth of tree)
// Method used : Backtracking

class Solution {
    public int countArrangement(int n) {
        
        int[] a = new int[n + 1];

        for(int i = 1; i <= n; i++) a[i] = i;

        return helper(1, a, n);
    }

    private void swap(int[] a, int x, int y)
    {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp; 
    }

    private int helper(int index, int[] a, int n)
    {
        if(index == n + 1) return 1;

        int count = 0;

        for(int i = index; i <= n; i++)
        {
            swap(a, index, i);

            if(a[index] % index == 0 || index % a[index] == 0)
            {
                count += helper(index + 1, a, n);
            }

            swap(a, index, i);
        }

        return count;
    }
}