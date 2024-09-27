//TC : O(n!)
// SC: O(N)
public class beautiful_Arrangements {

	int cnt;
	public int beautifulArrangements(int n) {
		if(n == 0)
			return 0;
		cnt = 0;
		boolean[] visited = new boolean[n+1];
		backtrack(n, visited, 1);
		return cnt;
	}
	
	public void backtrack(int n, boolean[] visited, int pos) {
		
		if(pos > n)
			cnt++;
		for(int i = 1; i <= n;i++) {
			if(!visited[i] && (i%pos ==0 || pos%i == 0)) {
				visited[i] = true;
				backtrack(n, visited, pos+1);
				visited[i] = false;
			}
				
		}
	}
	
	public static void main(String[] args) {
		
		beautiful_Arrangements ba = new beautiful_Arrangements();
		System.out.println(ba.beautifulArrangements(5));
	}
}
