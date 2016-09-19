package com.company;

import com.company.Vocabulary.Vocabulary;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String[] books = {"baud.fb2","bredb451.fb2","bredbTigers.fb2","chyornaya-rada.fb2",
                "dobbskartochdomik.fb2","DumaGraf_Monte-Kristo.fb2","ImaRos.fb2",
                "Posledniyi_Iz_MogikanI.fb2","VernJDeti_Kapitana.fb2","VernJDvadcat_Tyisyach.fb2"};
        long time = System.currentTimeMillis();
        for(int i = 0; i < books.length; i++){
            Parser.parseDocument(books[i]);
        }
        long timeIndex = System.currentTimeMillis();
        File file = new File("result.txt");
        Set<String> wordsSet = Vocabulary.getInstance().getWordSet();
        String[] wordsList = new String[wordsSet.size()];
        wordsList = wordsSet.toArray(wordsList);
        Arrays.sort(wordsList);
        long timePrepare = System.currentTimeMillis();
        long timeWritten = 0;
        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            for(int i = 0; i < wordsList.length; i++) {
                try {
                    //Записываем текст у файл
                    out.println(wordsList[i]);
                } catch(Exception e){

                }
            }
            out.close();
            timeWritten = System.currentTimeMillis();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Number of words:" + wordsSet.size());
        System.out.println("Index time:" + (timeIndex - time));
        System.out.println("Get sorted array:" + (timePrepare - timeIndex));
        System.out.println("Write in file:" + (timeWritten - timePrepare));
        System.out.println("Total time:" + (timeWritten - time));

    }
}