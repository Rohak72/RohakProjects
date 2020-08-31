package com.pluralsight.getorganized;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Interface interfaceObj = new Interface();
        ArrayList<String> userInfo = (ArrayList<String>) interfaceObj.introMessage();
        interfaceObj.carDisplay();
        int userMoney = interfaceObj.introMessage(true);
        Transactions transactionObj = new Transactions(userInfo, userMoney);

        Hangman hangmanObj = new Hangman();
        List<Object> resultList = hangmanObj.playHangman(hangmanObj);
    }


}
