class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = frequentChar(str);
            map.computeIfAbsent(key, s -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public String frequentChar(String s) {
        int[] index = new int[26];
        for (char c : s.toCharArray()) {
            index[c-'a']++;
        }
        StringBuilder string = new StringBuilder();
        for (int i : index) {
            string.append('#').append(i);
        }
        return string.toString();
    }
}
