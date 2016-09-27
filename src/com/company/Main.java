package com.company;

import com.company.Vocabulary.Vocabulary;

import java.io.*;
import java.util.Arrays;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Reader reader = new Reader();
        LineAnalyzer lineAnalyzer = new LineAnalyzer();
        lineAnalyzer.run();
        reader.run();
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

        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter your query : ");
                String input = br.readLine();

                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }
}