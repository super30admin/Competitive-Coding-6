using System;
namespace Algorithms
{
    /// Time Complexity : O(k) -- k --> valid permutations
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class BeautifulArrangement
    {
        int result = 0;
        public int CountArrangement(int n)
        {

            bool[] visited = new bool[n + 1];
            BackTrack(n, 1, visited);
            return result;
        }

        private void BackTrack(int n, int start, bool[] visited)
        {
            if (start > n) result++;
            for (int i = 1; i <= n; i++)
            {
                if (!visited[i] && (start % i == 0 || i % start == 0))
                {
                    visited[i] = true;
                    BackTrack(n, start + 1, visited);
                    visited[i] = false;
                }

            }
        }
    }
}
