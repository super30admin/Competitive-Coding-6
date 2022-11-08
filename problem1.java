package s30.Competitive-Coding-6;

public class problem1 {
    //TC:- O(1)
    //SC:- O(n)
    class Logger {
        public boolean shouldPrintMessage(int timestamp, String message) {
          // Remove messages that are 10 secs from the current timestamp
          while (!messageQueue.isEmpty()) {
            Pair<Integer, String> head = messageQueue.peekFirst();
            if (timestamp - head.getKey() < 10)
              break;
            messageQueue.pollFirst();
            messageSet.remove(head.getValue());
          }
      
          if (messageSet.contains(message))
            return false;
      
          messageQueue.offerLast(new Pair<>(timestamp, message));
          messageSet.add(message);
          return true;
        }
      
        // [(timestamp, message)]
        private Deque<Pair<Integer, String>> messageQueue = new ArrayDeque<>();
        private Set<String> messageSet = new HashSet<>();
      }
      
}
