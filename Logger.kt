// In this problem, we have to tell if we should print a message or not. shouldPrintMessage is implemented by keeping a map of message and timestamp. If the message is not present in the map, we add it to the map and return true,
//if it is present, we check if the timestamp is greater than or equal to the current timestamp + 10. If it is, we update the timestamp in the map and return true, otherwise we return false.
// Time complexity is O(1) and space complexity is O(n) where n is the number of unique messages.

class Logger() {

    private val map = HashMap<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if(!map.containsKey(message)) {
            map[message]  = timestamp
            return true
        }
        var currTimeStamp = map.getOrDefault(message, -1)
        if(timestamp >= currTimeStamp + 10) {
            map[message] = timestamp
            return true
        }

        return false
    }
}