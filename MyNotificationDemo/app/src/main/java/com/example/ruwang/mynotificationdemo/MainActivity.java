package com.example.ruwang.mynotificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

/**
 * 简单的通知demo
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        //1.获取manager
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


    }

    @Override
    public void onClick(View view) {
        //3如果点击通知时候，就进入通知内容使用pendingIntent
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        //2创建notifation
        Notification notification = new NotificationCompat.Builder(this)//使用v7包下的NotifationCompat
                .setContentTitle("我是一个通知")
                .setContentText("点我看内容")
                .setWhen(System.currentTimeMillis())//指定通知被创建的时间，毫秒为单位！
                .setAutoCancel(true)//设置点击取消
                .setSmallIcon(R.mipmap.ic_launcher)//注意设置图片设置纯alpha图层的图片！
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))//设置不了就进行转变
                .setContentIntent(pi)//点击通知启动内容界面的方法


                /**
                 * 通知的音频，震动,灯光用法
                 */
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
//                .setLights(Color.YELLOW, 1000, 1000)
//                .setVibrate(new long[]{0, 1000, 1000, 1000})//震动需要权限
                /**
                 * 如果嫌麻烦，可以设置默认的
                 */
                .setDefaults(NotificationCompat.DEFAULT_ALL)

                /**
                 * 通知中显示富文本以及大图的操作
                 * 为什么华为手机显示不了富文本以及大图片
                 */
                .setStyle(new NotificationCompat.BigTextStyle().bigText("你知道我不爱你，你知道我不爱你，，你知道我不爱你，，你知道我不爱你，，你知道我不爱你，，你知道我不爱你，，你知道我不爱你"))
//                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.large)))
                .setPriority(NotificationCompat.PRIORITY_MAX)//设置通知的重要程度
                .build();
        manager.notify(1, notification);//启动显示通知


    }
}
