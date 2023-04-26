package org.example;

import java.util.*;

public class MyNode {

    int state = 0;

    String path = "";

    String pathTemp = "";

    Map<String, Integer> links = new HashMap<>();

    public int getState() {
        return state;
    }

    public void setStart(){
        state = 2;
    }

    public String getPath() {
        return path;
    }

    private boolean changeState(){
        if (state == 0) {
            state = 1;
            return true;
        }
        if (state == 2) {
            state = 3;
        return true;
        }
        return false;
    }

    public void checkState(){
        if (state == 2)
            state = 0;
        if ((state == 1) || (state == 3)) {
            path = pathTemp;
            state = 2;
        }
    }

    public void statusProceed(List<MyNode> statuses){
        for (Map.Entry<String, Integer> link: links.entrySet()) {
            MyNode status = statuses.get(link.getValue());
            if (status.changeState())
                status.pathTemp = this.path + link.getKey();
        }}

    public void addLink(char c, int i){
        links.put(String.valueOf(c),i);
    }
}
