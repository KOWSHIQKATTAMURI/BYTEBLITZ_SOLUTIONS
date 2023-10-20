class Solution {
public:
    bool isPossible(vector<int>& target){
        long long int sum = accumulate(target.begin(), target.end(), 0LL);
        priority_queue<int> pq (target.begin(), target.end());
        while(!pq.empty() and pq.top() > 1){
            int max_element = pq.top();
            pq.pop();
            sum -= max_element;
            if(max_element <= sum or sum < 1){
                return false;
            }
            int old_element = max_element%sum;
            sum += old_element;
            pq.push(old_element != 0 ? old_element : sum);
        }
        return true;
    }
};
