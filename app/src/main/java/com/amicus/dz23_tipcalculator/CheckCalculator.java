package com.amicus.dz23_tipcalculator;


public class CheckCalculator { // класс для подсчёта полного чека

    public void calculate(CheckDescription checkDes)    // метод подсчёта
    {
        checkDes.setTipAmount(checkDes.getCheck()*checkDes.getTipPercent()*0.01f); // суммы чаевых в валюте
        checkDes.setPaymentCheck(checkDes.getCheck()+checkDes.getTipAmount()); // счёт к оплате с учётом всех добавок(+чаевые)
        checkDes.setSplitCheck(checkDes.getPaymentCheck()/checkDes.getNumGuests()) ; // счёт на каждого поровну между гостями
    }
    public void reset(CheckDescription checkDes)  // метод сброса всех значений
    {
        checkDes.setTipPercent(0);
        checkDes.setNumGuests(1);
        checkDes.setCheck(0);
        calculate(checkDes);
    }


}
