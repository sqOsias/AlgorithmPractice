package backtracking.seconde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution332 {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String,String> map = tickets.stream().collect(Collectors.toMap(list->list.get(0),list->list.get(1)));
        for (String from : map.keySet()){
            if (from.equals("JFK")){
                res.add(from);
                backtracking(map,map.get(from),res,1);
            }
        }
        backtracking(map,"JFK",res,0);
        return res;
        
    }

    private void backtracking(Map<String, String> map, String to, List<String> res,int index) {

        for (String from : map.keySet()){
            
        }
    }
}