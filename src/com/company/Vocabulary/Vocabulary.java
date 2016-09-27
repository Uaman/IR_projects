package com.company.Vocabulary;

import java.util.*;

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

    public void insertWord(String word,int docId){
        if(words.containsKey(word)){
            words.get(word);//.add(String);
        }else {
            words.put(word,word);
        }
    }

    public Set<String> getWordSet(){
        return words.keySet();
    }




}
