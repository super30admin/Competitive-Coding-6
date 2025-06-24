// Time Complexity O(1)
// Space Complexity O(N)
// Runs on LeetCode YES

// "static void main" must be defined in a public class.
public class Main {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private boolean shouldPrint(int sec, String msg){
        if(map.containsKey(msg)){

            int lastSec = map.get(msg);
            if(sec - lastSec > 9){
                map.put(msg, sec);
                return true;
            }
        }else{
            map.put(msg, sec);
        }
        return false;
    }
}

