public List<List<String>>groupAnagrams(String[]strs){
    if(strs.length==0){
        return new ArrayList();
    }
    Map<String, List> map=new HashMap<String, List>();
    for(String s:strs){
        char[]ca=s.toCharArray();
        Arrays.sort(ca);
        String key=String.valueOf(ca);
        // 如果map里不包含key，就put进去然后new 一个ArrayList
        if(!map.containsKey(key)){
            map.put(key,new ArrayList());
        }
        // 然后在把s加入到ArrayList中
        map.get(key).add(s);
    }
    return new ArrayList(map.values());
}