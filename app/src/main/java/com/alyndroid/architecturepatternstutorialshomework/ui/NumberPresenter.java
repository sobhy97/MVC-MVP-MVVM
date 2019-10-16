package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class NumberPresenter {

    private ViewNumbers viewNumbers;

    public NumberPresenter(ViewNumbers viewNumbers) {
        this.viewNumbers = viewNumbers;
    }


    public void divResult(){
        NumberModel numberModel = getNumberFromDB();
        int result =  (numberModel.getFirstNum() / numberModel.getSecondNum());
        viewNumbers.getDivideResult(result);
    }


    private NumberModel getNumberFromDB(){

        return new DataBase().getNumbers();
    }
}
