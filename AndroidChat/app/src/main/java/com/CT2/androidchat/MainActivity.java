package com.CT2.androidchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import me.himanshusoni.chatmessageview.ChatMessageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static CharSequence username = "";
    static ArrayList<TextView> log = new ArrayList<>();
    static ArrayList<ChatMessageView> speak = new ArrayList<>();
    private static LinearLayout scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nameButton = findViewById(R.id.nameDecisionButton);
        Button sendButton = findViewById(R.id.sendMsgButton);
        final EditText name = findViewById(R.id.nameEditText);
        final EditText mes = findViewById(R.id.messageTextEdit);
        scroll = findViewById(R.id.chatfuki);

        //名前入力決定ボタン処理
        nameButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               username = name.getText();
           }
        });

        //送信ボタン処理
        sendButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (mes.getText().length() != 0) {
                    scrollAddLog(mes.getText());
                    speak.get(speak.size() - 1).addView(log.get(speak.size() - 1));
                    scroll.addView(speak.get(speak.size() - 1));
                }
            }
        });
    }
    public void scrollAddLog(CharSequence mes){
        speak.add(new ChatMessageView(this));
        log.add(new TextView(this));
        log.get(log.size() - 1).setText(mes);
    }
}
