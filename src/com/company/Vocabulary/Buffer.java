package com.company.Vocabulary;

import com.company.BufferedNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zvazhiidmytro on 25.09.16.
 */
public class Buffer {

    private static Buffer buffer;

    private Stack<BufferedNode> stack;

    private Buffer() {
        stack = new Stack<BufferedNode>();
    }

    public static Buffer getInstance(){
        if(buffer == null) buffer = new Buffer();
        return buffer;
    }

    public Stack<BufferedNode> getStack(){
        return stack;
    }
}
