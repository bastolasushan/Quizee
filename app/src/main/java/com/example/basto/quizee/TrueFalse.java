package com.example.basto.quizee;

/**
 * Created by basto on 3/16/2018.
 */

public class TrueFalse {

    private int questionid;
    private boolean trueanswer;

    public TrueFalse(int questionresourceid, boolean trueorfalse) {
        questionid=questionresourceid;
        trueanswer=trueorfalse;
    }


    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public boolean isTrueanswer() {
        return trueanswer;
    }

    public void setTrueanswer(boolean trueanswer) {
        this.trueanswer = trueanswer;
    }
}


