package interview1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NewList {

    volatile List<Integer> intList = Collections.synchronizedList(new LinkedList<>());
    public void add(int a){

        intList.add(a);
        System.out.println(a);
    }
    public int size(){
        return intList.size();
    }
}
