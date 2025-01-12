package com.amicus.dz23_tipcalculator;

public class CheckDescription {
    private float check; // предварительный счёт
    private float paymentCheck; // счёт к оплате с учётом всех добавок
    private float splitCheck; // счёт разделённый поровну между гостями

    private int tipPercent;  // процент чаевых
    private float tipAmount; // сумма чаевых в валюте
    private int numGuests;// число гостей

    public CheckDescription() {
        this.numGuests = 1;
        this.tipPercent = 0;
    }

    @Override
    public String toString() {
        return "Check{" +
                "check=" + check +
                ", paymentCheck=" + paymentCheck +
                ", splitCheck=" + splitCheck +
                ", tipPercent=" + tipPercent +
                ", tipAmount=" + tipAmount +
                ", numGuests=" + numGuests +
                '}';
    }

    public float getCheck() {
        return check;
    }

    public void setCheck(float check) {
        this.check = check;
    }

    public float getPaymentCheck() {
        return paymentCheck;
    }

    public void setPaymentCheck(float paymentCheck) {
        this.paymentCheck = paymentCheck;
    }

    public float getSplitCheck() {
        return splitCheck;
    }

    public void setSplitCheck(float splitCheck) {
        this.splitCheck = splitCheck;
    }

    public int getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(int tipPercent) {
        this.tipPercent = tipPercent;
    }

    public float getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(float tipAmount) {
        this.tipAmount = tipAmount;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }
}
