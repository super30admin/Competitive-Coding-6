// Time Complexity : O(1)
// Space Complexity : O(n) space for the hashmap where n is unique messages
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning



#include<iostream>
#include<map>
#include<vector>
using namespace std;


map<string, int> mymap;
	bool printlog(int timestamp, string message){
	if (mymap.find(message) != mymap.end()) {
            int lastTime = mymap[message];
            if (timestamp - lastTime >= 10) {
                mymap.insert({message, timestamp});
                return true;
            }
            else {
                return false;
            }
        }
        else {
            mymap.insert({message, timestamp});

            return true;
        }
       

}


int main(){


cout<<printlog(1 , "test")<<endl;
cout<<printlog(2 , "test")<<endl;
cout<<printlog(1 , "yoyo")<<endl;
cout<<printlog(3 , "yoyo")<<endl;
cout<<printlog(15 , "test")<<endl;

return 0;
}
