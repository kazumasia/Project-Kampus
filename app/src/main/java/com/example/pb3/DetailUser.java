package com.example.pb3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;


public class DetailUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Detail User");
        setContentView(R.layout.activity_detail_user);
        Intent intent = getIntent();
        // Mendapatkan data alamat dan email dari sumber daya XML
        String[] alamatArray = getResources().getStringArray(R.array.data_alamat);
        String[] emailArray = getResources().getStringArray(R.array.data_email);
        String[] descArray = getResources().getStringArray(R.array.data_desc);


        // Mendapatkan data pengguna dari Intent
        int position = getIntent().getIntExtra("position", 0);

        String name = intent.getStringExtra("name");
        String alamat = alamatArray[position];
        String email = emailArray[position];
        String desc = descArray[position];
        int photo = intent.getIntExtra("photo", 0);
        int latar = intent.getIntExtra("latar",0);

        // Menampilkan data pengguna di tampilan
        TextView nameTextView = findViewById(R.id.tv_item_name);
        TextView alamatTextView = findViewById(R.id.addressTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView descTextView = findViewById(R.id.tv_item_description);
        ImageView photoImageView = findViewById(R.id.img_item_photo);
        ImageView latarImageView = findViewById(R.id.latar_belakang);

        nameTextView.setText(name);
        alamatTextView.setText(alamat);
        emailTextView.setText(email);
        descTextView.setText(desc);
        photoImageView.setImageResource(photo);
        latarImageView.setImageResource(latar);
    }
}
