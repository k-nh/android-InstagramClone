package com.example.instagramclone.src.Main.Navigation.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.instagramclone.R;
import com.example.instagramclone.src.Main.Navigation.Search.Models.SearchResponse;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private final Context context;
    private ArrayList<SearchResponse.SearchResult> SearchResponseArrayList;
    private SearchAdapter.OnItemClickListener mListener = null ;

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout searchResult;
        public ImageView searchProfileImg;
        public TextView searchId;
        public TextView searchName;

        //view holder
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            searchResult = (LinearLayout)itemView.findViewById(R.id.search_result);
            searchProfileImg = (ImageView)itemView.findViewById(R.id.search_profile_img);
            searchId = (TextView)itemView.findViewById(R.id.tv_search_id);
            searchName = (TextView)itemView.findViewById(R.id.tv_search_name);


            //결과값 Click -> 해당 유저 페이지로 넘어감
            searchResult.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        if(mListener != null){
                            mListener.onItem(v,pos);
                        }
                    }
                }
            });
        }


    }

    //생성자
    public SearchAdapter(ArrayList<SearchResponse.SearchResult> searchResponseArrayList, Context context){
        this.SearchResponseArrayList = searchResponseArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_search_item, parent, false);
        return new SearchViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(SearchViewHolder searchViewHolder, int position) {
        SearchViewHolder holder = (SearchViewHolder) searchViewHolder;
        holder.searchId.setText(SearchResponseArrayList.get(position).getUserId());
        holder.searchName.setText(SearchResponseArrayList.get(position).getName());

        Glide.with(context)
                .load(SearchResponseArrayList.get(position).getProfileImgUrl())
                .error(R.drawable.icon_default_profileimg)
                .into(holder.searchProfileImg);

    }

    @Override
    public int getItemCount() {
        return SearchResponseArrayList.size();
    }


    public void addItem(SearchResponse.SearchResult r) {
        SearchResponseArrayList.add(r);
    }




    public interface OnItemClickListener{
        void onItem(View v, int position);
    }

    public void setOnItemClickListener(SearchAdapter.OnItemClickListener listener){
        this.mListener = listener;
    }
}
