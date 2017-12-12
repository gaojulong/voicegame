package cn.lovelqq.julong;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.lovelqq.julong.voicerw.R;

/**
 * Created by julong on 2017/12/12.
 */

public class FriendType extends Activity implements View.OnClickListener{
    private Button bt_voice_F;//识别控件
    private EditText et_input_F;//需要识别的控件
    private TextView tv_result_F,tv_score_F;//识别结果控件
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firend);
        init();
    }
    private void init(){
        bt_voice_F=findViewById(R.id.btn_fri_voice);
        et_input_F=findViewById(R.id.ed_firend_input);
        tv_result_F=findViewById(R.id.tv_friend_result);
        tv_score_F=findViewById(R.id.tv_f_score1);

        //设置监听
        bt_voice_F.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_fri_voice:

                break;
        }

    }
}
