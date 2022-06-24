class MedianFinder {
    /*
        To find the median we need to have the array in a sorted order.. How to sort an array when there is a stream of ints coming?
        Idea is to use heap to maintain order
        if we divide the array into two parts then we can heapify both the side and have a sorted array
        [heap][heap]
        the left heap is a max heap and the right heap is a min heap
        we should always make sure that the greatest element in the left is smaller than or equal to the smallest element in the right heap, this maintains
        order
        always maintain the size of the heaps they should be as balanced as possible
        size of one heap shouldn't go more than one elment above the other heap
    */
    PriorityQueue<Integer> minHeapRight;
    PriorityQueue<Integer> maxHeapLeft;
    public MedianFinder() {
        minHeapRight = new PriorityQueue<>();
        maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // By default add to the left side
        maxHeapLeft.add(num);
        if(!maxHeapLeft.isEmpty() && !minHeapRight.isEmpty() && maxHeapLeft.peek() > minHeapRight.peek()){
            int temp = maxHeapLeft.poll();
            minHeapRight.add(temp);
        }
        // adding to left always so need to check for imbalance
        resize();
    }
    
    public double findMedian() {
        // odd number of elements = unbalanced heap sizes
        if(maxHeapLeft.size() > minHeapRight.size()){
            // this means the odd element is in the left heap
            return (double)maxHeapLeft.peek();
        }
        else if(minHeapRight.size() > maxHeapLeft.size()){
            // this means the odd element is in the right heap
            return (double)minHeapRight.peek();
        } else {
            // balanced heaps find the median by division
            double median = ((double)maxHeapLeft.peek() + (double)minHeapRight.peek())/2;
            return median;
        }
    }
    
    public void resize() {
        int temp;
        if(minHeapRight.size() > maxHeapLeft.size() + 1){
            temp = minHeapRight.poll();
            maxHeapLeft.add(temp);
        }
        if(maxHeapLeft.size() > minHeapRight.size() + 1){
            temp = maxHeapLeft.poll();
            minHeapRight.add(temp);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */