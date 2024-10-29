// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * @param {number} n
 * @return {number}
 */
var countArrangement = function(n) {
    let result = 0;
    
    const backtrack = (position, visited) => {
        if (position > n) {
            result++;
            return;
        }
        
        for (let i = 1; i <= n; i++) {
            if (!visited[i] && (i % position === 0 || position % i === 0)) {
                visited[i] = true;
                backtrack(position + 1, visited);
                visited[i] = false;
            }
        }
    };
    
    backtrack(1, Array(n + 1).fill(false));
    return result;
};