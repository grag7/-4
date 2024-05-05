package com.mycompany.laba3;

import java.util.ArrayList;
import java.util.List;


public class Storage {
    private final List<Reactor> reactorStorage = new ArrayList<>();
    
    public void addToStorage(List<Reactor> list) {
        for(Reactor reactor: list) {
            reactorStorage.add(reactor);
        }
        
    }
    
    public List<Reactor> getReactorStorage() {
        return reactorStorage;
    }
}
