package cn.lovelqq.julong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import cn.lovelqq.julong.voicerw.R;

/**
 * Created by julong on 2017/12/12.
 */

public class SelestType extends Activity implements View.OnClickListener {
    private Button butRandom,butFriend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        //加载控件
        butRandom=findViewById(R.id.btnTypeRand);
        butFriend=findViewById(R.id.btnTypeFriend);

        //设置监听
        butRandom.setOnClickListener(this);
        butFriend.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnTypeRand:
                Intent intent=new Intent(SelestType.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTypeFriend:
                startActivity(new Intent(SelestType.this,FriendType.class));
                break;
        }

    }
}
