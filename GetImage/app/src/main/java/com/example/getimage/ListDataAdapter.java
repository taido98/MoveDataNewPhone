package com.example.getimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.getimage.R.drawable.ic_collections_black_24dp;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ViewHolder> {
    private ArrayList<Data> mListData = new ArrayList<>();
    private Context mContext;
    private OnItemDataClickListener mOnItemDataClickListener;

    public ListDataAdapter(Context context, ArrayList<Data> ListData){
        this.mContext = context;
        this.mListData = ListData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View dataView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new ViewHolder(dataView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtDataType.setText(mListData.get(position).getTypeData());
        holder.txtSize.setText((mListData.get(position).getSize()+" MB"));
        holder.imgData.setImageResource(mListData.get(position).getUrlData());
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDataType;
        private ImageView imgData;
        private TextView txtSize;
        public ViewHolder(View itemView) {
            super(itemView);
            txtDataType = itemView.findViewById(R.id.txt_type_data);
            imgData = itemView.findViewById(R.id.img_data);
            txtSize = itemView.findViewById(R.id.txt_size_data);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemDataClickListener != null) {
                        mOnItemDataClickListener.OnItemDataClick(getLayoutPosition());
                    }
                }
            });
        }
    }
    public void setClick(OnItemDataClickListener onItemDataClickListener){
        this.mOnItemDataClickListener = onItemDataClickListener;
    }
}
