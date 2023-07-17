// Time Complexity: O(logn)
//Space Complexity: O(1)
class Solution {
public:
    double myPow(double x, long long n) {
        return exp(x, n);
    }

    double exp(double x, long long n) {
        if(n == 0) return 1; 
        
        if(n < 0) {
            return 1.0 / exp(x, -1 * n);
        }

        if(n % 2 == 1) {
            return x * exp(x * x , (n-1)/2);
        } else {
            return exp(x * x, n / 2); 
        }
    }
};