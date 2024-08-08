package com.example.taskboardbackend.GlobalData;

import java.util.concurrent.ConcurrentHashMap;

public class RegisterBuffer {
    ConcurrentHashMap.KeySetView<String, Integer> set;
    public RegisterBuffer(){
        ConcurrentHashMap<String, Integer> map
                = new ConcurrentHashMap<>();
        set= map.keySet();
    }
    public boolean checkEmail(String email){
        return set.contains(email);
    }
    public void addEmail(String email){
        set.add(email);
    }
    public void removeEmail(String email){
        set.remove(email);
    }
}
