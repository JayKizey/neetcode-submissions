class Solution {
    public int[] twoSum(int[] nums, int target) {
                int size = nums.length;
        if (size < 1) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

             if (map.get(target - nums[i]) != null) {
                 return new int[] {map.get(target - nums[i]), i};
             } else
                 map.put(nums[i], i);
        }
        return null;
    }
}
