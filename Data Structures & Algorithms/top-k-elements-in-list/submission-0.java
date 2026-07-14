class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer i : map.keySet()) {
            int freq = map.get(i);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(i);
        }

        List<Integer> result = new ArrayList();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null)
                for (int num : bucket[i]) {
                    result.add(num);
                    if (result.size() == k)
                        break;
                }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
