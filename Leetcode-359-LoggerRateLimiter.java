class Logger {

    Map<String, Integer> map;

    public logger()  {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timeStamp, String message) {
        // check if the string exists
        if (!map.containsKey(message)) {
            map.put(message, timeStamp); // appearing for the first time, so printable
            return true;
        } else {
            int oldStamp = map.get(message);
            if (timeStamp - 10 >= oldStamp) {
                map.put(message, timeStamp);
                return true;
            }
        }
        return false;
    }
}

// sc: O(n) - available inputs
// tc for update/add operatioon - same O(1) // behind the scene hashing takes
// place which is O(avg L of string)