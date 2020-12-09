package com.example.instagramclone.src.Main.Navigation.Upload;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.instagramclone.R;
import com.example.instagramclone.src.Main.Upload.UploadActivity;

public class FragmentUpload extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(getActivity().getApplicationContext(), UploadActivity.class);
        startActivity(intent);
        return inflater.inflate(R.layout.activity_upload,container,false);
    }
}
