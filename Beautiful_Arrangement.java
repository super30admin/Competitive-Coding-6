//TimeComplexity : O(n!)
//SpaceComplexity: O(n)

class Solution {
    int count =0;
    void swap(int []a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void recursiveFunction(int []a, int index,int n) {
        //base condition

           if(index == a.length) {
               count++;
               return;
           }
        // logic
        for(int i = index;i<a.length;i++) {
            if(a[i]%(index+1)== 0 || (index+1) % a[i] == 0) {
            swap(a,index,i);
            recursiveFunction(a,index+1,n);
            swap(a,index,i);
        }
        }
    }
    public int countArrangement(int n) {
        int []a = new int[n];
        for(int i =0; i<n;i++) {
            a[i] = i+1;
        }
        recursiveFunction(a,0,n);
        return count;
    }
}