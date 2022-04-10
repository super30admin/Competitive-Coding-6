type Logger struct {
    msgs map[string]int
}


func Constructor() Logger {
    return Logger{msgs: map[string]int{}}
}

// time : o(1) if we do not count hashing the message string into a hashIdx
// time: o(k) if we do count hashing the message string into a hashIdx
// space: o(1) for this function to compute an answer
// overall space: o(n) - where n is the number of uniq msgs in map.
func (this *Logger) ShouldPrintMessage(timestamp int, message string) bool {
    t, ok := this.msgs[message]
    if ok {
        if timestamp >= t {
            this.msgs[message] = timestamp+10 
            return true
        }
        return false
    }
    this.msgs[message] = timestamp+10
    return true
}
