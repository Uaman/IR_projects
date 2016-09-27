package com.company;

import com.company.Vocabulary.Buffer;
import com.company.Vocabulary.Vocabulary;

import java.io.*;
import java.util.*;

/**
 * Created by zvazhiidmytro on 11.09.16.
 */
public class Reader implements Runnable {

    String[] books = {"baud.fb2","bredb451.fb2","bredbTigers.fb2","chyornaya-rada.fb2",
            "dobbskartochdomik.fb2","DumaGraf_Monte-Kristo.fb2","ImaRos.fb2",
            "Posledniyi_Iz_MogikanI.fb2","VernJDeti_Kapitana.fb2","VernJDvadcat_Tyisyach.fb2"};

    private static int _currentDocId;

    protected static void parseDocument(String documentName, int docID){
        _currentDocId = docID;
        try {
            File file = new File(documentName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null && line.indexOf("<body>") < 0) {
            }
            while ((line = bufferedReader.readLine()) != null && line.indexOf("</body>") < 0) {
                if(line.indexOf("<p>") >= 0){
                    Buffer.getInstance().getStack().push(new BufferedNode(line,docID,1));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < books.length; i++){
            Reader.parseDocument(books[i],i);
        }
        LineAnalyzer.flag = false;
    }
}
