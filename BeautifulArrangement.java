//TC = O(2*n^2)
//SC = O(N)
class Solution {
    int count;
    public int countArrangement(int n) {
        count = 0;

        List<Integer> originalPool = new ArrayList<>();
        List<Integer> currentPool = new ArrayList<>();

        for(int i=1; i<=n; i++){
            originalPool.add(i);
        }
        
        recurse(n, originalPool, currentPool);

        return count;
        
    }

    public void recurse(int n, List<Integer> originalPool, List<Integer> currentPool) {
        //base
        if(originalPool.size() == 0){
            count++;
        }

        for(int i=0; i<originalPool.size(); i++){
            int currentNumber = originalPool.get(i);
            int index = currentPool.size();
            if(currentNumber%(index+1) == 0 || (index+1)% currentNumber == 0){

                currentPool.add(currentNumber);
                originalPool.remove(i);

                recurse(n, originalPool, currentPool);

                originalPool.add(i, currentNumber);
                currentPool.remove(currentPool.size() -  1);
            }

        }



    }
}