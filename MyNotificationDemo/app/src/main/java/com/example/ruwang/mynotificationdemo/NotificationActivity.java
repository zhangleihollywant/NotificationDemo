package com.example.ruwang.mynotificationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <b>Create Date:</b> 17/3/21<br>
 * <b>Author:</b> Zhanglei<br>
 * <b>Description:</b> <br>
 */
public class NotificationActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noti);
        //点击通知消失的另外一种方法
//        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        manager.cancel(1);//显示时候传入的id为1
    }
}
