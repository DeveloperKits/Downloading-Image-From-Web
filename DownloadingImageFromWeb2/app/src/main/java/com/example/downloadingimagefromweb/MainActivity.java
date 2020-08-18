package com.example.downloadingimagefromweb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView downloadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadImage = (ImageView) findViewById(R.id.imageView);

    }
    private class  ImageDownloader extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection Connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = Connection.getInputStream();
                Bitmap myBitMap = BitmapFactory.decodeStream(inputStream);
                return myBitMap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void DownloadingImage(View view) {

        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;
        try {
            myImage = task.execute("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Pokemon_Go_Tr%C3%A4sk%C3%A4nda_g%C3%A5rd.jpg/1200px-Pokemon_Go_Tr%C3%A4sk%C3%A4nda_g%C3%A5rd.jpg").get();
            downloadImage.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}