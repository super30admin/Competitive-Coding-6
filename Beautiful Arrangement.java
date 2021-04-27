//Time Complexity : O(N!). At each level N reduces and the recursion is apllied at each level . hence O(N!)/.
//Space Complexity : O(N) . The recursion stack will take O(N) time and the hash set will also take O(N) time
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english:
/*
This problem requires to use all the combination of N numbers and check if any of these combination are beautiful combination. 
Hence an exhaustive approach is required, thus calling out for recurssion and backtracking.
ACTION: choose the number
RECURSE :  from this number again use n numbers and check for divisibility conditions.
BACKTRACK : If divisibility condition is not satisfied, then go to previous step and choose another combination
*/
class Solution {
    int count=0;
    int N;
    HashSet<Integer> visited = new HashSet<>();//use a hashset to maintain visited numbers
    public int countArrangement(int n) {
        N = n;
        helper(1);
        return count;
    }
    private void helper(int i){
        //Base : Check if the conditions are true or not. If its not divisible for this particular number, just return for backtracking
    if(visited.size()%i!=0 && i % visited.size()!=0){
        return;
    }
        //if the numbers in this particular combination has passed any one of the divisiblity condition ,then its a beautiful arrangement. i.e the set will have all the numbers in this combination. hence increeement the count
    if(visited.size()==N){
        count++;
        return;
    }
    for(int j=1;j<=N;j++){
        if(!visited.contains(j)){
            //ACTION: choose the number
            visited.add(j);
            //RECURSE :  from this number again use n numbers and check for divisibility conditions
            helper(j);
            //BACKTRACK : If divisibility condition is not satisfied, then go to previous step and choose another combination
            visited.remove(j);
        }
    }
    } 
}