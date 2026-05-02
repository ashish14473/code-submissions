class MedianFinder {
    List<Integer> lheap;
    List<Integer> rheap;
     int lheapSize=0;
     int rheapSize=0;
    public MedianFinder() {
         lheap = new ArrayList<>();
          rheap = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(lheapSize == 0){
            lheap.add(num);
            lheapSize++;
            return;
        }
        if(rheapSize == 0){
            if(lheap.get(0) > num){
                 rheap.add(lheap.get(0));
                lheap.set(0,num);
                 rheapSize++;
                return;
            }
            rheap.add(num);
            rheapSize++;
            return;
        }

        if(num < rheap.get(0)){
            lheap.add(num);
            lheapSize++;
            heapifyupm(lheap,lheapSize-1);
        }else{
            rheap.add(num);
            rheapSize++;
            heapifyupmin(rheap,rheapSize-1);
        }
        if(lheapSize-rheapSize >1){
            rheap.add(lheap.get(0));
            rheapSize++;
            lheap.set(0,lheap.get(lheapSize-1));
            lheap.remove(lheapSize-1);
            lheapSize--;
            heapifyDownmax(lheap , lheapSize,0);
             heapifyupmin(rheap,rheapSize-1);
           
        }
         if(rheapSize -lheapSize >1){
            lheap.add(rheap.get(0));
            lheapSize++;
            rheap.set(0,rheap.get(rheapSize-1));
            rheap.remove(rheapSize-1);
            rheapSize--;
             heapifyDownmin(rheap , rheapSize,0);
             heapifyupm(lheap,lheapSize-1);
            
        }
        
    }

    void heapifyDownmax(List<Integer> arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;
        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;
        if (largest != i) {
            int temp = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest, temp);
            heapifyDownmax(arr, n, largest);
        }
    }

    void heapifyDownmin(List<Integer> arr, int n, int i) {
       int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr.get(l) < arr.get(largest))
            largest = l;
        if (r < n && arr.get(r) < arr.get(largest))
            largest = r;
        if (largest != i) {
            int temp = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest, temp);
            heapifyDownmin(arr, n, largest);
        }
    }
    
    public double findMedian() {
        if(lheapSize == rheapSize){
            System.out.println("here");
            return ((double)lheap.get(0)+(double)rheap.get(0))/2.0;
        }else if(lheapSize > rheapSize){
              return lheap.get(0);
        }else{
           
            return rheap.get(0);
        }
    }

    void heapifyupm(List<Integer> arr,int index){
        if(index == 0){
            return;
        }
        int parent = (index-1)/2;
        if(arr.get(parent) < arr.get(index)){
            int temp = arr.get(index);
            arr.set(index ,arr.get(parent));
            arr.set(parent ,temp);
            heapifyupm(arr, parent);
        }
    }
     void heapifyupmin(List<Integer> arr,int index){
        if(index == 0){
            return;
        }
        int parent = (index-1)/2;
        if(arr.get(parent) > arr.get(index)){
            int temp = arr.get(index);
            arr.set(index ,arr.get(parent));
            arr.set(parent ,temp);
            heapifyupmin(arr, parent);
        }
    }
}
