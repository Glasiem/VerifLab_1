package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Automaton {

    int k = 5;

    int alphabetPower;

    HashSet<Character> alphabet = new HashSet<>();

    int statusPower;

    List<MyNode> statuses = new ArrayList<>();

    int statusFinalPower;

    HashSet<Integer> statusFinal = new HashSet<>();

    public void setAlphabetPower(int n){
        alphabetPower = n;
        for (int i = 0; i < alphabetPower; i++) {
            alphabet.add((char)(i+97));
        }
    }

    public void setStatusPower(int n) {
        statusPower = n;
        for (int i = 0; i < statusPower; i++) {
            statuses.add(new MyNode());
        }
    }

    public void setStart(int n) throws Exception{
        statuses.get(n).setStart();
    }

    public void setStatusFinalPower(int n) {
        statusFinalPower = n;
        for (int i = 0; i < statusPower; i++) {
            statuses.add(new MyNode());
        }
    }

    public void setStatusFinal(int n) {
        statusFinal.add(n);
    }

    public void setLink(int n, char c, int nextn) {
        statuses.get(n).addLink(c, nextn);
    }

    public String proceed(){
        for (int i = 0; i < k; i++) {
            for (MyNode status: statuses) {
                if ((status.getState() == 2) || (status.getState() == 3)){
                    status.statusProceed(statuses);
                }
            }
            for (MyNode status: statuses) {
                status.checkState();
            }
        }
        for (int i = 0; i < statusPower; i++) {
            if ((statuses.get(i).getState() == 2) && (statusFinal.contains(i))) {
                return (statuses.get(i).getPath());
            }
        }
        return ("There`s no suitable words of length " + k);
    }
}
