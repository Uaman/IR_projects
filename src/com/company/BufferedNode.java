package com.company;

import com.company.Vocabulary.Buffer;

/**
 * Created by zvazhiidmytro on 25.09.16.
 */
public class BufferedNode {
    private String line;

    private int docId;

    private int lineNumber;

    public BufferedNode(String line, int docId, int lineNumber){
        this.line = line;
        this.docId = docId;
        this.lineNumber = lineNumber;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
