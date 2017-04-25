package com.amr.build_it_bigger;

import android.util.Log;

import junit.framework.Assert;

import org.junit.Test;
/**
 * Created by Amr on 4/25/2017.
 */

public class testJoke implements AsyncResponse {

    @Override
    public void processFinish(String output) {
        Assert.assertNotNull(output);
        Log.d("Feteched Data", "Data : " + output);

    }
    @Test
    public void testJoke() {

        AsyncTaskEndpoint asyncTask = new AsyncTaskEndpoint();
        asyncTask.delegate = this;
        asyncTask.execute();
    }

}
