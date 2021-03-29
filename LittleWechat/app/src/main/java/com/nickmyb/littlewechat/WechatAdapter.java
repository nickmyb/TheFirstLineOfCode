package com.nickmyb.littlewechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WechatAdapter extends RecyclerView.Adapter<WechatAdapter.ViewHolder> {
    private List<Message> messageList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_view_received;
        TextView text_view_sended;

        public ViewHolder(View view) {
            super(view);
            text_view_received = (TextView) view.findViewById(R.id.text_view_received);
            text_view_sended = (TextView) view.findViewById(R.id.text_view_sended);
        }
    }

    public WechatAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (message.getType() == Message.TYPE_RECEIVED) {
            holder.text_view_sended.setVisibility(View.GONE);
            holder.text_view_received.setVisibility(View.VISIBLE);
            holder.text_view_received.setText(message.getMessage());
        } else {
            holder.text_view_sended.setVisibility(View.VISIBLE);
            holder.text_view_received.setVisibility(View.GONE);
            holder.text_view_sended.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
