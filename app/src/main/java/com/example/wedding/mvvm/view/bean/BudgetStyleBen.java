package com.example.wedding.mvvm.view.bean;

public class BudgetStyleBen {
    private int drawID;
    private String styleStr;
    private int money;

    public BudgetStyleBen() {
    }

    public BudgetStyleBen(int drawID, String styleStr, int money) {
        this.drawID = drawID;
        this.styleStr = styleStr;
        this.money = money;
    }

    public int getDrawID() {
        return drawID;
    }

    public void setDrawID(int drawID) {
        this.drawID = drawID;
    }

    public String getStyleStr() {
        return styleStr;
    }

    public void setStyleStr(String styleStr) {
        this.styleStr = styleStr;
    }

    public String getMoney() {
        return "￥"+money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
