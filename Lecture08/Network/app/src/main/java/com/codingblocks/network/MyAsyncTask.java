package com.codingblocks.network;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by arnav on 12/30/2017.
 */
class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {
    public interface MyAsyncTaskListener {
        void onProgressUpdate (Integer progress);
        void onPostExecute();
    }

    private MyAsyncTaskListener listener;

    public MyAsyncTask(MyAsyncTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        Log.d(MainActivity.TAG, "onPreExecute: ");
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int countUpto = 0;
        if (integers.length > 0) countUpto = integers[0];

        for (int i = 0; i < countUpto; i++) {
            MainActivity.waitAsec();
            publishProgress(i + 1);
        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        if (listener != null) {
            listener.onProgressUpdate(values[0]);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (listener != null) {
            listener.onPostExecute();
        }
    }

}
