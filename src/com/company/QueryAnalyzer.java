package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by zvazhiidmytro on 25.09.16.
 */
public class QueryAnalyzer {

    private static final String AND = "AND";

    private static final String OR = "OR";

    private static final String NOT = "NOT";

    protected static void parseQuery(String query){

        StringTokenizer tokenizer = new StringTokenizer(query);
        List<String> sequence = new ArrayList<String>();
        String token = "";

        while(tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();

            Node node = new Node();

            if (AND.equals(token) || OR.equals(token) || NOT.equals(token)) {
            } else {
            }
            if (AND.equals(token) || OR.equals(token) || NOT.equals(token)) {
            } else {
            }

        }
    }



}
