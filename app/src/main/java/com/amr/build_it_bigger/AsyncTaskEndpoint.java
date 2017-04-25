package com.amr.build_it_bigger;

import android.os.AsyncTask;
import com.example.amr.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Amr on 4/25/2017.
 */

public class AsyncTaskEndpoint extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private String joke;
    public AsyncResponse delegate = null;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    public String getJoke() {
        return joke;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //- setRootUrl("http://192.168.1.9:8080/_ah/api/")

                    .setRootUrl("https://build-it-bigger-163016.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            return myApiService.jokeSupplier().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        joke = result;
        delegate.processFinish(result);
    }
}
