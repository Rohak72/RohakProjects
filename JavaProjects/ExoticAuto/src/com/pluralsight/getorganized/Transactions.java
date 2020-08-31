package com.pluralsight.getorganized;
import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private String username;
    private Integer userID;
    private Integer userMoney;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public String getUsername() {
        return username;
    }

    public Transactions(ArrayList<String> userInformation, int userMoney) {
        this.username = userInformation.get(0);
        this.userID = Integer.parseInt(userInformation.get(1));
        this.userMoney = userMoney;
    }

    public void decidePath(List<Object> resultList) {

    }

}
