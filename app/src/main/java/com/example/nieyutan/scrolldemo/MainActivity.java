package com.example.nieyutan.scrolldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    protected RelativeLayout mActivityMain;
    String mString[] = {"q", "s", "d", "f", "g", "h", "3", "4", "7"};
    RelativeLayout sss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);

        Button button = new Button(this);
        button.setWidth(160);
        button.setHeight(190);
        button.setText("测试rxjava");
        mActivityMain.addView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册被观察者  然后订阅事件
                Observable.from(mString).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        //观察者发出消息
                        if (!s.equals("水水水水")) {

                            Log.d("TTT", "ttt:" + s);
                        } else {
                            sss.addView(mActivityMain);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d("TTT", "eee:" + throwable.toString());
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        Log.d("TTT", "ccc:" +"成功了");

                    }
                });
            }
        });
    }

}
