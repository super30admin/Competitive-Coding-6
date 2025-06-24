class Logger {
    constructor() {
        //TC : O(1)
        //SC : O(1) O(N) auxialiry
        this.messageTimestamps = new Map(); // maps message -> next allowed timestamp
    }
    shouldPrintMessage(timestamp, message) {
        if (!this.messageTimestamps.has(message) || timestamp >= this.messageTimestamps.get(message)) {
            this.messageTimestamps.set(message, timestamp + 10);
            return true;
        }
        return false;
    }
}
