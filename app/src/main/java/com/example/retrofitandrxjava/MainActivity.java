package com.example.retrofitandrxjava;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitandrxjava.base.BaseMvpActivity;
import com.example.retrofitandrxjava.entity.BaseObjectBean;
import com.example.retrofitandrxjava.entity.MessageNotificateEntity;
import com.example.retrofitandrxjava.mvp.Contract;
import com.example.retrofitandrxjava.mvp.MessagePresenter;

import java.util.List;

public class MainActivity extends BaseMvpActivity<MessagePresenter> implements Contract.View {

    Button button;
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                mPresenter.getNotificatMessages();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        button = findViewById(R.id.click_btn);
        progressBar = findViewById(R.id.pb);
        textView = findViewById(R.id.abcd);
        mPresenter = new MessagePresenter();

        //绑定视图
        mPresenter.attachView(this);



    }

    @Override
    public void onSuccsee(List<MessageNotificateEntity> messageNotificates) {
        Toast.makeText(this,"getIt",Toast.LENGTH_SHORT).show();
        textView.setText("12356");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        //ProgressDialog.getInstance().show(this);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
