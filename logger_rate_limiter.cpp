//Logger rate limiter
//Time Complexity - O(1) because hashmap
//Space complexity - O(n) where n is the number if distinct messages

unordered_map<string,int>m;
bool shouldprint(int timestamp, string message)
{
		//if the string doesnt exist, we push it into the hashmap and return true cause it can be printed
		if(!map.count(message))
		{
			m[message]=timestamp;
			return true;
		}
		//if the string exists in the hashmap, we check if it has arrived before 10 seconds
		int prev_time=m.at(message);
		if(timestamp-prev_time>=10)
		{
			m[message]=timestamp;
			return true;
		}
		else
			return true;
}