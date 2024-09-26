//Problem 83 :  Beautiful Arrangement
//TC: O(number of valid permutaions)
//SC: O(N) for Set of size N; In case of Recursive call O(H) of tree, here H is N

/*
Bruteforce : TC:(O(n!)) | SC:O(n!) Create All permutations and then add it to the list. Iterate over that list and check whether it is valid or not that is current element is divisible by i+1 or i+1 is divisible by current element an return the count 

Optimized : TC:O(number of valid permutaions) | SC: O(N) for Set of size N. Find permutations of number, however while finding further permurtations check whether the elements in the set are valid or not. If they are valid, further explore that path otherwise skip exploring that path. Once set size is equal to the "n" increment the count.

Note : U can use LinkedHashSet or Set for keepig an eye on visited. However here we are not storing the permutations so insertion order of numbers in permutations doesnt matter, so we dont need LinkedHashSet. If we have to return all the valid permutations then use LinkedHashSet because in that case insertion order will matter.

Note for finding permutations of N=3. Each call will have 3 options and we will be using a visted set so that we dont add the earlier element again and again

*/

import java.util.*;
class Solution {
    private int count;
    public int countArrangement(int N) {
        //TC: O(number of valid permutaions)
        //SC: O(N) for Set of size N;
        if(N<0){
            return count;
        }
        
        helper(N,new LinkedHashSet());
        return count;
    }
    
    private void helper(int n, Set<Integer> visited){
        
        if(visited.size()==n){
            count++;
        }
        
        for(int i=1;i<=n;i++){
            
            if(visited.contains(i)) continue;
            
            if((visited.size()+1)%i!=0 && i%(visited.size()+1)!=0) continue;//if perm[i] not divisble by i or vice versa don't explore the further permutaion. Here visited.size()+1 because starting index is 1
                
               visited.add(i);
               helper(n,visited);
               visited.remove(i);
            
        }
        
    }
    
    
}