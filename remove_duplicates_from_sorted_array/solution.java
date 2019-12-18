/* Two Pointers Approach

Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while 
j is the fast-runner. As long as nums[i]=nums[j], we increment j to skip the duplicate.
When we encounter nums[j]≠nums[i], the duplicate run has ended so we must copy its value to nums[i+1]. 
i is then incremented and we repeat the same process again until j reaches the end of array.

*/

class Solution {
    public int removeDuplicates(int[] nums){
        if (nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}