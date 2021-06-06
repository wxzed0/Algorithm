package hashmap;

import java.util.*;

//根据字符出现频率排序
public class P0451_SortCharactersByFrequency {

    //统计字符出现的次数，map a：3 ； b：5； d:3;
    //按照value来排序
    //遍历，字符串拼接
    public String frequencySort(String s) {
        int len=s.length();
        if(len<=2 || s==null)return s;
        Map<String,Integer> map=new TreeMap<String,Integer>();
        //上面TreeMap可以改为hashMap，但是下面转为list的时候有些不同
        Comparator<Map.Entry<String, Integer>> valueComparator = new                                            Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {

                return o2.getValue()-o1.getValue();
            }
        };
        //统计某字符出现的次数 eg：eert e：2；r:1;t:1;
        for(int i=0;i<len;i++){
            String ch=s.charAt(i)+"";
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }
        // map转换成list进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
// 排序
        Collections.sort(list,valueComparator);
        StringBuilder sb=new StringBuilder("");
        //字符串拼接
        for (Map.Entry<String, Integer> entry : list) {
            for(int j=0;j<entry.getValue();j++){
                sb.append(entry.getKey());
            }
        }
        return  sb.toString();
    }

}

