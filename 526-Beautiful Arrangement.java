//Time Complexity=O(N!)
//Space Complexity=O(N)


class Solution {
    int count;
    public int countArrangement(int N) {
        int []arr=new int[N+1];
        if(N==0) return 0;
        for(int i=1;i<=N;i++)
        {
            arr[i]=i;
        }
        count=0;
        helper(arr,1);
        return count;
    }
    private void helper(int []arr,int index)
    {
        if(index==arr.length)
        {
            count++;
            return;
        }
        for(int i=index;i<arr.length;i++)
        {
            if(index%arr[i]==0 || arr[i]%index==0)//Initially we are checking the conditions whether the digit is divisible by index or vice-versa
            {
                //Action
                swap(arr,index,i);//Here we are swapping the value and incrementing the index
                //Recurse
                helper(arr,index+1);
                //Backtrack
                swap(arr,index,i);
            }
        }
    }
    private void swap(int []arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}