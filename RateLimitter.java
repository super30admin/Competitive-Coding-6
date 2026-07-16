// Time complexity: O(1)
// space complexity: O(n)
class Logger {

        Map<String, Integer> map ;
        public Logger() {

            map = new HashMap<>();
        }


        public boolean shouldPrintMessage(int timestamp, String message) {
            // log message hasnt arrived
            map.put(message, timestamp);
            if(map.get(message)==null) {

                return  true;
            }
            else {

                 Integer existingTimestamp = map.get(message);
                if(timestamp - existingTimestamp > 10) {

                    return  true;
                } else {
                    return  false;
                }
            }  // existing
        }
}