package com.test.admin.activitypromulgator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.test.admin.R;
import com.test.admin.bean.AsImformation;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

import static com.test.admin.bean.Parameters.staticObjectdId;

public class ImformViewActivity extends AppCompatActivity {

    private TextView imTitle;
    private TextView imOrganizer;
    private TextView imTime;
    private TextView imContent;
    private TextView imAudiences;

    //声明活动申请对象，保存当前查找到的活动申请对象
    private List<AsImformation> myAsImformation = new ArrayList<AsImformation>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inform_view);

        imTitle = (TextView)findViewById(R.id.inform_biao);
        imOrganizer = (TextView)findViewById(R.id.inform_fang);
        imTime = (TextView)findViewById(R.id.inform_time);
        imContent = (TextView)findViewById(R.id.inform_nei);
        imAudiences = (TextView)findViewById(R.id.inform_shouzhong);

        //查找当前item对应的活动申请对象并返回值显示在TextView上
        BmobQuery<AsImformation> query = new BmobQuery<AsImformation>();
        query.getObject(staticObjectdId, new QueryListener<AsImformation>() {
            @Override
            public void done(AsImformation asImformation, BmobException e) {

                if(e == null){
                    myAsImformation.add(asImformation);

                    imTitle.setText(asImformation.getImTitle());
                    imOrganizer.setText(asImformation.getImOrganizer());
                    imTime.setText(asImformation.getCreatedAt());
                    imContent.setText(asImformation.getImContent());
                    imAudiences.setText(asImformation.getImAudiences());
                }
            }
        });
    }
}
