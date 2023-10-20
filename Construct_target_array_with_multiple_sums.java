public class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : target) {
            sum += num;
            pq.offer(num);
        }
        while (!pq.isEmpty() && pq.peek() > 1) {
            int maxElement = pq.poll();
            sum -= maxElement;
            if (maxElement <= sum || sum < 1) {
                return false;
            }
            int oldElement = (int)(maxElement % sum);
            sum += oldElement;
            pq.offer(oldElement != 0 ? oldElement : (int)sum);
        }
        return true;
    }
}
