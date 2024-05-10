package com.example.firebaseimage;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firebaseimage.databinding.ActivityRetriveBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class retrive extends AppCompatActivity {

    ActivityRetriveBinding binding;
    StorageReference storageReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetriveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.Retrivebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            progressDialog = new ProgressDialog(retrive.this);
            progressDialog.setTitle("Retriving File....");
            progressDialog.show();

            String imageID = binding.selectImagebtn.getText().toString();

            storageReference = FirebaseStorage.getInstance().getReference("images/"+imageID+".jpg");

                try {
                    File localfile = File.createTempFile("tempfile",".jpg");
                    storageReference.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                            binding.retimage.setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });



    }
}