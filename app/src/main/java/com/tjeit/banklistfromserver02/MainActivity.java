package com.tjeit.banklistfromserver02;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tjeit.banklistfromserver02.databinding.ActivityMainBinding;
import com.tjeit.banklistfromserver02.utils.ConnectServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        setUpEvents();
        setValues();
    }

    @Override
    public void setUpEvents() {



        act.serverTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectServer.getRequestInfoBank(mContext, new ConnectServer.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
//                      실제로 서버에서 돌아온 응답을 메인 액티비티에서 처리하는 메소드.

                        try {
                            int code = json.getInt("code");

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(code == 200 ) {
                                        Toast.makeText(mContext,"정상적으로 데이터를 가져왔습니다.", Toast.LENGTH_SHORT).show();

//                                        은행이름만 따서 로그찍기
                                        try {
                                            JSONObject data = json.getJSONObject("data");
                                            JSONArray banks = data.getJSONArray("banks");

                                            for(int i=0;i<banks.length();i++) {
                                                JSONObject bank = banks.getJSONObject(i);
                                                String name = bank.getString("name");

                                                Log.d("은행이름",name);
                                            }

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    else {
//                                        서버에서 주는 에러메세지를 토스트로 출력
                                        try {
                                            String message = json.getString("message");
                                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
