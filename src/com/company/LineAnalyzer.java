package com.company;

import com.company.Vocabulary.Buffer;
import com.company.Vocabulary.Vocabulary;

import java.util.StringTokenizer;

/**
 * Created by zvazhiidmytro on 25.09.16.
 */
public class LineAnalyzer implements Runnable {

    static boolean flag = true;

    private static void analyzeLine(BufferedNode currentNode){
        StringTokenizer stringTokenizer = new StringTokenizer(currentNode.getLine().replaceAll("(<((a)[^>]+)>)(.*?)(<((a)[^>]+)>)","").replaceAll("(<((.*?)[^>]+)>)",""));
        String token = "";
        for(int i = 0; i < stringTokenizer.countTokens(); i++){
            token = stringTokenizer.nextToken();
            token = token.replaceAll("[\\xAB\\x28\\x2E\\x86\\xBB\\x3B\\x3A\\x2E\\x2C\\x21\\x22\\x3F\\x29\\xA9\\x2A\\x2D]","");
            if(!token.equals("")) Vocabulary.getInstance().insertWord(token,currentNode.getDocId());
        }
    }

    @Override
    public void run() {
        while (true) {
            if(Buffer.getInstance().getStack().size() == 0){
//                try {
//                    //this.wait(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }else {
                    analyzeLine(Buffer.getInstance().getStack().pop());
            }

            if(!flag && Buffer.getInstance().getStack().size() == 0){
               break;
            }

        }
    }
}
