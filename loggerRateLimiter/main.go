type Logger struct {
    index map[string]int
}


func Constructor() Logger {
    return Logger{index: map[string]int{}}
}


// time: o(1)
// space: o(1)
func (this *Logger) ShouldPrintMessage(timestamp int, message string) bool {
    allowedAtTime, found := this.index[message]
    if !found {
        this.index[message] = timestamp+10
        return true
    } else if timestamp >= allowedAtTime {
        this.index[message] = timestamp+10
        return true
    }
    return false
}


/**
 * Your Logger object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.ShouldPrintMessage(timestamp,message);
 */
