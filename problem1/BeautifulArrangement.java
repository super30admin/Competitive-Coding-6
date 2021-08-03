//Time Complexity : O(k), k -> Number of valid permutations
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package problem1;

public class BeautifulArrangement {
	int cnt = 0;

	public int countArrangement(int n) {
		if (n == 0) {
			return 0;
		}

		checkArrangement(n, 1, new boolean[n + 1]);
		return cnt;
	}

	private void checkArrangement(int n, int index, boolean[] visited) {
		// Base
		if (index > n) {
			cnt++;
		}
		// Logic
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && (index % i == 0 || i % index == 0)) {
				visited[i] = true;
				checkArrangement(n, index + 1, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		BeautifulArrangement obj = new BeautifulArrangement();
		int n = 5;
		System.out.println("Number of beautiful arrangements for n = \'" + n + "\': " + obj.countArrangement(n));
	}

}
