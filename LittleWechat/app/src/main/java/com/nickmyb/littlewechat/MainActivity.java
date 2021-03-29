package com.nickmyb.littlewechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Message> messageList = new ArrayList<>();
    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    private WechatAdapter wechatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMessageList();
        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        wechatAdapter = new WechatAdapter(messageList);
        recyclerView.setAdapter(wechatAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message_content = editText.getText().toString();
                if (!"".equals(message_content)) {
                    Message message = new Message(message_content, Message.TYPE_SENDED);
                    messageList.add(message);
                    wechatAdapter.notifyItemInserted(messageList.size() - 1);
                    recyclerView.scrollToPosition(messageList.size() - 1);
                    editText.setText("");
                }
            }
        });
    }

    public void initMessageList() {
        Message m1 = new Message("Hello, nice to meet u!", Message.TYPE_RECEIVED);
        Message m2 = new Message("Nice to meet u too!", Message.TYPE_SENDED);
        Message m3 = new Message("What's your name?", Message.TYPE_RECEIVED);
        messageList.add(m1);
        messageList.add(m2);
        messageList.add(m3);
    }
}