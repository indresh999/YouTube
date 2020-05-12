package com.teetask.youtube;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private  String[] videoname;
    private  String[] channelname;
    private  String[] links;
    private  int[] videoimg;
    private OnAdapterItemClickListener adapterItemClickListener = null;

    public ListAdapter(String[] videoname, String[] channelname, String[] links, int[] videoimg, OnAdapterItemClickListener listener)
    {
        this.videoname =    videoname;
        this.channelname =  channelname;
        this.links =        links;
        this.videoimg =     videoimg;
        this.adapterItemClickListener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.listitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        String vname = videoname[position];
        String cname = channelname[position];
        String lnks = links[position];
        int vimage = videoimg[position];
        holder.title.setText(vname);
        holder.channel.setText(cname);

        holder.imageView.setImageResource(vimage);


    }

    @Override
    public int getItemCount() {
        return videoimg.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView title;
        TextView channel;
        TextView link;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            title =     (TextView)itemView.findViewById(R.id.title);
            channel =   (TextView)itemView.findViewById(R.id.channel);
            imageView = (ImageView) itemView.findViewById(R.id.myimg);
            link =      (TextView) itemView.findViewById(R.id.lnk);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            adapterItemClickListener.onAdapterItemClickListener(getAdapterPosition());
        }
    }

}
