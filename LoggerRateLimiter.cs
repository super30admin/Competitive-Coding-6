// Time Complexity: O(1)
// Space Complexity: O(M)

// Store last printed time: Maintain a dictionary dict mapping each message to the last timestamp it was printed.

// Check 10-second rule: For a new message, return true if it’s not in the dictionary or at least 10 seconds have passed since it was last printed, updating the timestamp.

// Reject otherwise: If less than 10 seconds have passed, return false without updating the dictionary.
public class Logger
{

    Dictionary<string, int> dict = new();
    public Logger()
    {

    }

    public bool ShouldPrintMessage(int timestamp, string message)
    {
        if (message == null)
            return false;
        if (dict.ContainsKey(message))
        {
            int totalTime = dict[message] + 10;
            if (timestamp >= totalTime)
            {
                dict[message] = timestamp;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            dict.TryAdd(message, timestamp);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * bool param_1 = obj.ShouldPrintMessage(timestamp,message);
 */