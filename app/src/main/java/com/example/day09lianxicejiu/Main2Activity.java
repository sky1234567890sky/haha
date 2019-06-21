package com.example.day09lianxicejiu;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvZi;
    private ProgressBar mPgb;
    /**
     * 下载
     */
    private Button mBtXiazai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mTvZi = (TextView) findViewById(R.id.tv_zi);
        mPgb = (ProgressBar) findViewById(R.id.pgb);
        mBtXiazai = (Button) findViewById(R.id.bt_xiazai);
        mBtXiazai.setOnClickListener(this);

    }

    private void initxiazai() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request build = new Request.Builder()
                .url("http://cdn.banmi.com/banmiapp/apk/banmi_330.apk")
                .get()
                .build();
        okHttpClient.newCall(build)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("tag", "onFailure: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody body = response.body();
                        InputStream inputStream = body.byteStream();
                        long length = body.contentLength();
                        saveFile(inputStream, length, Environment.getExternalStorageDirectory() + "/lian9.apk");

                    }
                });
    }

    private void saveFile(InputStream inputStream, long length, String s) {

        try {
            FileOutputStream fos = new FileOutputStream(new File(s));
            int len = 0;
            long count = 0;
            byte[] bytes = new byte[1024 * 20];
            while ((len = inputStream.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
                count += len;
                final long p = count * 100 / length;

                mPgb.setProgress((int) p);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvZi.setText("当前进度：" + p + "%");
                    }
                });
                Log.e("tag", "saveFile: " + p);
            }
            inputStream.close();
            fos.close();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    NotificationManager service = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification build = new NotificationCompat.Builder(Main2Activity.this, "1")
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentTitle("下载完成")
                            .setContentText("通知")
                            .build();
                    service.notify(1,build);
                    Toast.makeText(Main2Activity.this, "下载完成", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_xiazai:
                initxiazai();
                break;
        }
    }
}
