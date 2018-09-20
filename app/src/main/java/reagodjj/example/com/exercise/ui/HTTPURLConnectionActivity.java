package reagodjj.example.com.exercise.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import reagodjj.example.com.exercise.R;

public class HTTPURLConnectionActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://www.mengxianyi.net/one/homepage.json";
    private TextView tvFuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpurlconnection);

        tvFuck = findViewById(R.id.tv_fuck);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getDataFromInternet();
            }
        }).start();
    }

    public void getDataFromInternet() {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.getContent();
            httpURLConnection.setRequestMethod("GET");
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
//            StringBuffer stringBuffer = new StringBuffer();
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String response = stringBuilder.toString();
            Log.d("RealgodJJ", response);
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
//            textView.setText(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
