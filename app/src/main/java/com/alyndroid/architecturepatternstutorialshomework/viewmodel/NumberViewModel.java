package com.alyndroid.architecturepatternstutorialshomework.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class NumberViewModel extends ViewModel {

    public MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();


    public void getResult(){
        NumberModel numberModel = getNumberFromDB();
        mutableLiveData.setValue(numberModel.getFirstNum() * numberModel.getSecondNum());
    }


    private NumberModel getNumberFromDB(){

        return new DataBase().getNumbers();
    }
}
