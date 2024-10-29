// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



var Logger = function() {
    this.messageMap = new Map();
};

/** 
 * @param {number} timestamp 
 * @param {string} message
 * @return {boolean}
 */
Logger.prototype.shouldPrintMessage = function(timestamp, message) {
    if(this.messageMap.has(message)) {
        let existingTimeStamp = this.messageMap.get(message);
        if(timestamp - existingTimeStamp < 10) {
            return false;
        }
        else{
            this.messageMap.set(message, timestamp);
            return true;
        }
    }
    else {
        this.messageMap.set(message, timestamp);
        return true;
    }
};

/** 
 * Your Logger object will be instantiated and called as such:
 * var obj = new Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */