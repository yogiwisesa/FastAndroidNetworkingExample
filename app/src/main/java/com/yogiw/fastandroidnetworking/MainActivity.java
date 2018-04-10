package com.yogiw.fastandroidnetworking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());

        post("coba dari FAN", "yogiw");
    }

    void requestByUser(String user){
        AndroidNetworking.get("https://obscure-crag-32540.herokuapp.com/{user}")
                .addPathParameter("user", user)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(NoteDao.class, new ParsedRequestListener<NoteDao>() {
                    @Override
                    public void onResponse(NoteDao response) {
                        for (int i = 0; i < response.getNotes().size(); i++) {
                            Log.i("yogixx", "" + response.getNotes().get(i).getText());
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.i("yogixx", "Error mas: " + anError);
                    }

                });
    }

    void requestAll(){
        AndroidNetworking.get("https://obscure-crag-32540.herokuapp.com/")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(NoteDao.class, new ParsedRequestListener<NoteDao>() {
                    @Override
                    public void onResponse(NoteDao response) {
                        for (int i = 0; i < response.getNotes().size(); i++) {
                            Log.i("yogixx", "" + response.getNotes().get(i).getText());
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.i("yogixx", "Error mas: " + anError);
                    }

                });
    }

    void post(String text, String user){
        AndroidNetworking.post("https://obscure-crag-32540.herokuapp.com/")
                .addBodyParameter("text", text)
                .addBodyParameter("user", user)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(PostDao.class, new ParsedRequestListener<PostDao>() {
                    @Override
                    public void onResponse(PostDao response) {
                        Log.i("yogixx", "" + response.getText());
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.i("yogix", "error mas: " + error);
                    }
                });
    }


}
