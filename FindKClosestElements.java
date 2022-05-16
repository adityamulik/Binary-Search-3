
class FindKClosestElements {
    /*
     *
     * time complexity: O(n-k) + O(k) as to traverse the entire list in worst case
     * space complexity: O(1) as no additional space required
     *
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // two pointer solution
        if (arr == null || arr.length == 0) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        int left = 0;
        int right = arr.length - 1;
        
        // TC O(n-k) 
        while (right - left + 1 > k) {
            
            int distLeft = Math.abs(arr[left] - x);
            int distRight = Math.abs(arr[right] - x);
            
            if ((distLeft == distRight && arr[left] < arr[right]) ||
                distLeft < distRight) {
                right--;
            } else {
                left++;
            }            
        }
        
        // O(k)
        for (int i=left; i<left+k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
