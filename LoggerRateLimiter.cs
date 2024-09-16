
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Logger{
    Dictionary<string, int> dict;
    public Logger()
    {
        dict = new Dictionary<string, int>();
    }

    public bool shouldPrintMessage(int timestamp, string message)
    {
        if(dict.ContainsKey(message))
        {
            if(timestamp - dict[message] > 10)
            {
                dict[message] = timestamp;
                return true;
            }
        }
        else
        {
            dict.Add(message, timestamp);
            return true;
        }
        return false;
    }
}