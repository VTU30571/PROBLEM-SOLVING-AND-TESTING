class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
        map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer>[] bucket = new ArrayList[nums.length +1];
        for(int n : map.keySet()){
            int f = map.get(n);
            if(bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(n);
        }
        int[] ans = new int[k];
        int j = 0;
        for(int i = bucket.length - 1; i >= 0 && j < k; i--){
            if(bucket[i] != null){
                for(int n: bucket[i]){
                    ans[j++] = n;
                    if(j == k) break;
                }
            }
        }
        return ans;
    }
}


