package cn.lovelqq.julong.voicerw;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        // 初始化识别对象
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5a2a1917");
    }

    /**
     * 初始化语音识别
     */
    public void initSpeech(Context context) {
        //1.创建RecognizerDialog对象
        RecognizerDialog recognizerDialog = new RecognizerDialog(context, null);
        //2.设置accent、language等参数
        recognizerDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");//语种，这里可以有zh_cn和en_us
        recognizerDialog.setParameter(SpeechConstant.ACCENT, "mandarin");//设置口音，这里设置的是汉语普通话 具体支持口音请查看讯飞文档，
        recognizerDialog.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");//设置编码类型

        //其他设置请参考文档http://www.xfyun.cn/doccenter/awd
        //3.设置讯飞识别语音后的回调监听
        recognizerDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean b) {//返回结果
                if (!b) {
                    Log.e("讯飞识别的结果", recognizerResult.getResultString());
                    tv.setText(parseJsonVoice(recognizerResult.getResultString()));
                }
            }

            @Override
            public void onError(SpeechError speechError) {//返回错误
                Log.e("返回的错误码", speechError.getErrorCode() + "");
            }

        });
        //显示讯飞语音识别视图
        recognizerDialog.show();
    }

    /**
     * 解析语音json
     */
    public String parseJsonVoice(String resultString) {
        JSONObject jsonObject = JSON.parseObject(resultString);
        JSONArray jsonArray = jsonObject.getJSONArray("ws");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("cw");
            JSONObject jsonObject2 = jsonArray1.getJSONObject(0);
            String w = jsonObject2.getString("w");
            stringBuffer.append(w);
        }
        Log.e("识别结果", stringBuffer.toString());
        return stringBuffer.toString();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                initSpeech(this);
                break;
        }
    }
}
