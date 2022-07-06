package dailyCheckin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/5 21:05
 */
public class MyCalendar {
    private List<List<Integer>>list;
    public MyCalendar(){
        list = new ArrayList<>();
    }
    public boolean book(int start,int end){
        if (list.size() == 0){
            list.add(Arrays.asList(start,end));
            return true;
        }else {
            for (List<Integer> temp : list){
                int left = temp.get(0);
                int right = temp.get(1);
                if (!(start >= right || end <= left)){
                    return false;
                }
            }
            list.add(Arrays.asList(start,end));
            return true;
        }
    }
}
