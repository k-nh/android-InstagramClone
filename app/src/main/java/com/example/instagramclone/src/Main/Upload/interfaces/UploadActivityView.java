package com.example.instagramclone.src.Main.Upload.interfaces;

import com.example.instagramclone.src.Main.Upload.models.UploadResponse;

public interface UploadActivityView {
    void UploadSuccess(UploadResponse uploadResponse);

    void UploadFailure(String message);

}
