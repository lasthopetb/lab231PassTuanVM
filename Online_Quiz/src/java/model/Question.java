/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Question {

    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String[] answers;
    private String date;
    private int accountid;

    public Question() {
    }

    public Question(int id, String question, String option1, String option2, String option3, String option4, String[] answers, Date date, int accountid) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answers = answers;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = sdf.format(date);
        this.accountid = accountid;
    }

    public Question(String question, String option1, String option2, String option3, String option4, String[] answers, Date date, int accountid) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answers = answers;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = sdf.format(date);
        this.accountid = accountid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String ans) {
        String[] answers = ans.trim().split(" ");
        this.answers = answers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = sdf.format(date);
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

}
