/*
TC: O(max(n,m)) which is O(n) as n: len of s and m: lenght of pattern and n>m
SC: O(1)
Store the chars of pattern in a map, Use Sliding window on source to check if each char exists in the map
there will be one incominga and one outgoing char, outgoing only after we reach 'n' 
keep track of matching chars from map and if match variable is same as num of keys in map, thats one result
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = p.length();
        int m = s.length();
        if(n>m) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int match = 0;
        for(int i = 0; i<m; i++){
            //in
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int cnt = map.get(in);
                cnt--;
                if(cnt==0) match++;
                map.put(in,cnt);
            }
            //out
            if(i>=n){
                char out = s.charAt(i - n);
                if(map.containsKey(out)){
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt == 1) match--;
                    map.put(out,cnt);
                }
            }

            if(match == map.size()){
                result.add(i-n+1);
            }
           
        }
        return result;
    } 
}