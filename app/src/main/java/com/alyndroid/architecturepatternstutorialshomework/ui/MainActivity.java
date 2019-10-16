package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.db.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.viewmodel.NumberViewModel;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewNumbers {
    private ActivityMainBinding binding;
    private NumberViewModel numberViewModel;
    NumberPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        binding.setViewModel(numberViewModel);
        binding.setLifecycleOwner(this);

        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        presenter = new NumberPresenter(this);
    }


    public int plusResult(){
        NumberModel numberModel = new DataBase().getNumbers();
        return numberModel.getFirstNum()+ numberModel.getSecondNum();
    }


    @Override
    public void onClick(View view) {

//        switch (view.getId()){
//            case R.id.plus_button:
//                String result = Integer.toString(plusResult());
//                binding.plusResultTextView.setText(result);
//                break;
//
//            case R.id.div_button:
//                presenter.divResult();
//
//
//
//        }
        if (view.getId()== R.id.plus_button){
            String result = Integer.toString(plusResult());
            binding.plusResultTextView.setText(result);
        }else if (view.getId()==R.id.div_button){
            presenter.divResult();
        }
    }

    @Override
    public void getDivideResult(int divideResult) {
        binding.divResultTextView.setText(Integer.toString(divideResult));
    }
}
