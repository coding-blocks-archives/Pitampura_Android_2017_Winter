package com.codingblocks.network;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.codingblocks.network.models.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PostsActivity extends AppCompatActivity {
    public static final String TAG = "POSTS";
    ListView lvPosts;
    ArrayList<Post> postArrayList = new ArrayList<>();
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        lvPosts = findViewById(R.id.lvPosts);
        postAdapter = new PostAdapter();
        lvPosts.setAdapter(postAdapter);
        new DownloadPostsTask().execute();
    }

    class PostAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return postArrayList.size();
        }

        @Override
        public Post getItem(int position) {
            return postArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_2, parent, false);
            }
            Post post = getItem(position);
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(post.getTitle());
            ((TextView) convertView.findViewById(android.R.id.text2)).setText(post.getBody());
            return convertView;
        }
    }

    class DownloadPostsTask extends AsyncTask<Void, Void, ArrayList<Post>> {

        @Override
        protected ArrayList<Post> doInBackground(Void... voids) {
            ArrayList<Post> posts = new ArrayList<>();
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String buf = br.readLine();
                while (buf != null) {
                    sb.append(buf);
                    buf = br.readLine();
                }
                String data = sb.toString();
                JSONArray postJsonArray = new JSONArray(data);
                for (int i = 0; i < postJsonArray.length(); i++) {
                    JSONObject postJsonObject = postJsonArray.getJSONObject(i);
                    Post post = new Post();
                    post.setBody(postJsonObject.getString(Post.BODY));
                    post.setId(postJsonObject.getInt(Post.ID));
                    post.setTitle(postJsonObject.getString(Post.TITLE));
                    post.setUserId(postJsonObject.getInt(Post.USER_ID));
                    posts.add(post);
                }

            } catch (java.io.IOException | JSONException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "doInBackground: size = " + posts.size());
            return posts;
        }

        @Override
        protected void onPostExecute(ArrayList<Post> posts) {
            super.onPostExecute(posts);
            postArrayList.clear();
            postArrayList.addAll(posts);
            postAdapter.notifyDataSetChanged();
        }
    }
}
