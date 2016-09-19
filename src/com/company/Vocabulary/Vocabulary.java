package com.company.Vocabulary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zvazhiidmytro on 11.09.16.
 */
public class Vocabulary {

    private static Vocabulary _instance;

    private Map<String,String> words;

    private Vocabulary(){
        words = new HashMap<String,String>();
    };

    public static Vocabulary getInstance(){
        if (_instance == null) {
            _instance = new Vocabulary();
        }
        return _instance;
    }

    public void insertWord(String word){
        words.put(word,word);
    }

    public Set<String> getWordSet(){
        return words.keySet();
    }




}
