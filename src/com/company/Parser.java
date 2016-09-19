package com.company;

import com.company.Vocabulary.Vocabulary;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by zvazhiidmytro on 11.09.16.
 */
public class Parser {

    protected static void parseDocument(String documentName){

        try {
            File file = new File(documentName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null && line.indexOf("<body>") < 0) {
            }
            while ((line = bufferedReader.readLine()) != null && line.indexOf("</body>") < 0) {
                if(line.indexOf("<p>") >= 0){
                    analyzeLine(line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeLine(String line){
        StringTokenizer stringTokenizer = new StringTokenizer(line.replaceAll("(<((a)[^>]+)>)(.*?)(<((a)[^>]+)>)","").replaceAll("(<((.*?)[^>]+)>)",""));
        String token = "";
        for(int i = 0; i < stringTokenizer.countTokens(); i++){
            token = stringTokenizer.nextToken();
            token = token.replaceAll("[\\xAB\\x28\\x2E\\x86]", "").replaceAll("[\\xBB\\x3B\\x3A\\x2E\\x2C\\x21\\x22\\x3F\\x29\\xA9\\x2A\\x2D]","");
            if(!token.equals("")) Vocabulary.getInstance().insertWord(token);
        }
    }

}
