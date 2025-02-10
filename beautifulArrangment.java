//526. Beautiful Arrangement
//for loop based recursion using BT
class beautifulArrangment {
    public static void main(String[] args) {
        beautifulArrangment obj = new beautifulArrangment();
        System.out.println(obj.countArrangement(3));
    }
    int cnt = 0;
    public int countArrangement(int n) {
        boolean[] arr = new boolean[n+1];
        recurse(n,1,arr);
        return cnt;

    }
    private void recurse(int n, int index,boolean[] arr){
        //base
        if(index > n){
            cnt++;
            return;
        }
        //logic
        for(int i = 1;i<=n;i++){
            if(!arr[i] && (index % i == 0 || i % index == 0)){
                //action
                arr[i] = true;
                //recurse
                recurse(n,index+1,arr);
                //Backtrack
                arr[i] = false;
            }
        }
    }
}

