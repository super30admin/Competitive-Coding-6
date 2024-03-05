// Time Complexity :  O(1)
// Space Complexity : O(k) [k: number of unique messages]
// Did this code successfully run on Leetcode : No, Premium problem
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// import java.util.ArrayList;
import java.util.HashMap;
// import java.util.List;
import java.util.Map;

public class LoggerRateLimiter {
    static Logger logger;

    public static void main(String args[]) {
        logger = new Logger();

        print(1, "foo");
        print(2, "bar");
        print(3, "foo");
        print(8, "bar");
        print(10, "foo");
        print(11, "foo");
        print(18, "bar");
    }

    private static void print(int timeStamp, String message) {

        if (logger == null) {
            return;
        }
        boolean isPrint = logger.shouldPrintMessage(timeStamp, message);
        System.out.println(isPrint + "   msg:" + message + "  tmpStmp: " + timeStamp);
        // System.out.println(logger.getLogPairList());
        System.out.println(logger.getLogMap());
    }
}

// class Pair {
//     private int timeStamp;
//     private String message;

//     public Pair(int timeStamp, String message) {
//         this.timeStamp = timeStamp;
//         this.message = message;
//     }

//     public int getTimeStamp() {
//         return this.timeStamp;
//     }

//     public String getMessage() {
//         return this.message;
//     }

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + timeStamp;
//         result = prime * result + ((message == null) ? 0 : message.hashCode());
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Pair other = (Pair) obj;
//         if (timeStamp != other.timeStamp)
//             return false;
//         if (message == null) {
//             if (other.message != null)
//                 return false;
//         } else if (!message.equals(other.message))
//             return false;
//         return true;
//     }

//     @Override
//     public String toString() {
//         return "Pair [timeStamp=" + timeStamp + ", message=" + message + "]";
//     }

// }

class Logger {
    // private List<Pair> logPairList;
    // public Logger() {
    //     this.logPairList = new ArrayList<>();
    // }

    private Map<String, Integer> logMap;
    public Logger() {
    this.logMap = new HashMap<>();
    }

    // public boolean shouldPrintMessage(int timeStamp, String message) {
    //     Pair pair = getPairWithMessageFromLogList(message);
    //     if (null != pair) {
    //         int currTmStmp = pair.getTimeStamp();
    //         if (currTmStmp > timeStamp) {
    //             return false;
    //         } else {
    //             int idx = logPairList.indexOf(pair);
    //             Pair pairU = new Pair(timeStamp + 10, message);
    //             logPairList.set(idx, pairU);
    //             return true;
    //         }
    //     } else {
    //         pair = new Pair(timeStamp + 10, message);
    //         this.logPairList.add(pair);
    //         return true;
    //     }
    // }

    // private Pair getPairWithMessageFromLogList(String msg) {
    //     for (Pair pair : this.logPairList) {
    //         if (pair.getMessage().equals(msg)) {
    //             return pair;
    //         }
    //     }
    //     return null;
    // }

    
    public boolean shouldPrintMessage(int timeStamp, String message) {
        int existingTime = logMap.getOrDefault(message, 0);
        
        if(timeStamp >= existingTime) {
            logMap.put(message, timeStamp + 10);
            return true;
        }
        return false;
    }

    // public List<Pair> getLogPairList() {
    //     return logPairList;
    // }
    
    public Map<String, Integer> getLogMap() {
        return logMap;
    }
}

