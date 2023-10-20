class Solution(object):
    def isPossible(self, target):
        max_heap = [-num for num in target]
        heapq.heapify(max_heap)
        total = sum(target)
        while True:
            max_element = -heapq.heappop(max_heap)
            total -= max_element
            if max_element <= total or total < 1:
                return False
            old_element = max_element % total
            total += old_element
            heapq.heappush(max_heap, -old_element if old_element != 0 else -total)
            if max_heap and -max_heap[0] == 1:
                return True
    
