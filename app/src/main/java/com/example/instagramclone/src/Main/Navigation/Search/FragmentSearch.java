package com.example.instagramclone.src.Main.Navigation.Search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;
import com.example.instagramclone.src.Main.Navigation.Account.FragmentAccount;
import com.example.instagramclone.src.Main.Navigation.Search.Models.SearchResponse;
import com.example.instagramclone.src.Main.Navigation.Search.interfaces.SearchActivityView;

import java.util.ArrayList;

public class FragmentSearch extends Fragment implements SearchActivityView {

    EditText et_search;
    ImageView btn_search;
    ImageView img_smallprofile;

    private ArrayList<SearchResponse.SearchResult> searchResultArrayList;
    private SearchAdapter searchAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;


    public FragmentSearch() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search,container,false);
        searchResultArrayList = new ArrayList<SearchResponse.SearchResult>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_search);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        searchAdapter = new SearchAdapter(searchResultArrayList,getActivity());
        mRecyclerView.setAdapter(searchAdapter);

        et_search = view.findViewById(R.id.search_bar);
        btn_search = view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = et_search.getText().toString();
                tryGetSearch(userId);
            }
        });

        searchAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItem(View v, int position) {
                System.out.println("아이디 검색 , 클릭");
                int userIdx = searchResultArrayList.get(position).getUserIdx();
                Fragment fragment = new FragmentAccount(); // Fragment 생성
                Bundle bundle = new Bundle();
                bundle.putInt("userIdx", userIdx); // Key, Value
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    private void tryGetSearch(String userId) {
        final SearchService searchService = new SearchService(this);
        searchService.getSearch(userId);
    }


    @Override
    public void SearchSuccess(SearchResponse searchResponse) {
        //검색 -> 나온 결과들 리사이클러뷰에 넣음
        System.out.println("검색 성공");
        for (com.example.instagramclone.src.Main.Navigation.Search.Models.SearchResponse.SearchResult r : searchResponse.getSearchResults())
            searchAdapter.addItem(r);
        searchAdapter.notifyDataSetChanged();

    }

    @Override
    public void SearchFailure(String message) {
        System.out.println("검색실패");
    }
}
