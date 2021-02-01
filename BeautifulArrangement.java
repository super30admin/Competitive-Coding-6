//cant find bug
// "static void main" must be defined in a public class.
// # Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
// # The number at the ith position is divisible by i.
// # i is divisible by the number at the ith position.
// # Now given N, how many beautiful arrangements can you construct?
// [[1,2,3,4], [1,4,3,2], [2,1,3,4]]
public class Main {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int n = 4;
        helper(n, new HashSet<>(), 1);
        System.out.println("Count: " +count);
    }
    public static void helper(int n, HashSet<Integer> hset, int index ) {
        //base case
        if(n == hset.size()) {
            count++;
            return;
        }
        //logic
        for(int i = index; i <= n; i++) {
            if(!hset.contains(i) && isDivisble(i,index)) {
                hset.add(i);
                helper(n, hset, i + 1);
                hset.remove(i);
            }
        }
    }
    public static boolean isDivisble(int index, int number) {
        return (index%number == 0 || number%index == 0);
    }
}