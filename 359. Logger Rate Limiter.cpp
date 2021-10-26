// Time Complexity :
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass Node{
    public:
    string message;
    int timestamp;
    Node* next;
    Node* prev;
    Node(string message, int timestamp){
        this->message = message;
        this->timestamp = timestamp;
    }
};
class Logger {
public:
    /** Initialize your data structure here. */
    map<string,Node*> m;
    Node* head;
    Node* tail;
    Logger() {
        head = new Node("", 0);
        tail = new Node("", 0);
        head->next = tail;
        tail->next = NULL;
        head->prev = NULL;
        tail->prev = head;
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    bool shouldPrintMessage(int timestamp, string message) {
        if(m.find(message)!=m.end()){
            Node* temp = m[message];
            if(timestamp-temp->timestamp < 10) return false;
            movetohead(temp,timestamp);
        }
        else{
            if(m.size()>=10)             
                removetail(tail);
            addtohead(timestamp,message);
        }
        return true;   
    }
    void addtohead(int timestamp, string message){
        Node* newnode = new Node(message,timestamp);
        head->next->prev = newnode;
        newnode->next = head->next;
        newnode->prev = head;
        head->next = newnode;
        m.insert({message, newnode});
    }
    void removetail(Node* tail){                      
        tail->prev = tail->prev->prev;
        tail->prev->prev->next = tail;
        m.erase(tail->message);
    }
    
    void movetohead(Node* temp, int timestamp){
        temp->timestamp = timestamp;
        temp->next->prev = temp->prev;
        temp->prev->next = temp->next;
        temp->next = head->next;
        temp->prev = head;
        head->next->prev = temp;
        head->next = temp;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */

// Time Complexity : O(N)
// Space Complexity : O(N)
// Where N is the number of blocks provided. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Logger {
public:
    /** Initialize your data structure here. */
    map <string, int> m;
    int time;
    Logger() {
        time=10;
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    bool shouldPrintMessage(int timestamp, string message) {
        if(m.find(message)==m.end()){
            m.insert({message,timestamp});
            return true;
        }
        else{
            if(m.find(message)!=m.end()){
                if(timestamp - m[message]>=time){
                    m[message] = timestamp;
                    return true;   
                }
            }
        }
        return false;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */
