package cn.lovelqq.julong;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gaojulong.github.GeiRandomeString;
import com.gaojulong.github.Shibie;
import com.gaojulong.github.Time;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import cn.lovelqq.julong.voicerw.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public   static TextView tv_score,tv,tv_time,tv_random;
    static  Button btn,btn_start;
    private static int timeint=0;//答题剩余时间
    private Time time=new Time();
    private Shibie shibie=new Shibie();
    public static String strRandom=null;//随机数
    public static int score=0;//所得分
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    /**
     * 初始化控件
     */
    private void init(){
        tv =  findViewById(R.id.tv);
        tv_time=findViewById(R.id.tv_time1);
        tv_score=findViewById(R.id.tv_score1);
        tv_random=findViewById(R.id.tv_random);
        btn =  findViewById(R.id.btn);
        btn_start=findViewById(R.id.btnstart);
        //监听事件
        btn.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        // 初始化识别对象
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5a2a1917");

    }


    public static Handler handlerMain =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    int timer=msg.arg1;
                    timeint=timer;//返回剩余时间
                    tv_time.setText(Integer.toString(timer));
                    if(timeint==0)
                    {
                        btn_start.setText("开始");
                    }
                    break;
                case 2:
                    int score=msg.arg1;
                    tv_score.setText(Integer.toString(score));
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                //String s="";
                if(timeint>0) {
                    shibie.initSpeech(this);
                }
                else{
                    Toast.makeText(this,"请先选择开始游戏",Toast.LENGTH_LONG).show();
                   // score=0;//清除得分
                }
                break;
            case R.id.btnstart:
                //如果没有剩余时间，才可以再次计时。
                time.gettimer(60);
                //生成汉字
                strRandom= GeiRandomeString.getRandomChar();
               tv_random.setText(strRandom);
               btn_start.setText("下一个");
                break;
        }

    }

}
