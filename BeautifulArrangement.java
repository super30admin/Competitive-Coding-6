//TC = O(N!)
//SC = O(N)

public class BeautifulArrangement
{
    public static int total =0;
    public static int countArrangement(int n) {
        
        
        helper(n,0,new boolean[n]);
        
        return total;
    }
    
    private static void helper(int n, int index, boolean[] visited)
    {
        //base
        if(index == n)
        {
            total++;
            return;
        }
        
        //logic
        for(int i = 1;i<=n;i++)
        {
            if(visited[i-1] == true)
            {
                continue;
            }
            int number = i;
            index = index+1;
            
            if(number%index == 0 || index%number == 0)
            {
                //action
                visited[i-1]=true;
                
                
                //recursive
                helper(n,index,visited);
                
                //backtrack
                visited[i-1] = false;
            }
            
            index = index - 1;
        }
    }


    public static void main(String args[])
    {
        System.out.println(countArrangement(6));
    }
}