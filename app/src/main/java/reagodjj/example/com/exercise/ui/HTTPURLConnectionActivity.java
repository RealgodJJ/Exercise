package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import reagodjj.example.com.exercise.R;
import reagodjj.example.com.exercise.entity.Data;
import reagodjj.example.com.exercise.entity.PublicSecurityNetwork;

@SuppressLint("Registered")
public class HTTPURLConnectionActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://www.mengxianyi.net/one/homepage.json";
    private static final String NET_URL = "https://www.sojson.com/api/gongan/baidu.com";
    private TextView tvFuck;
    private Button btGetData;
    private Handler connectionHandler;
    private PublicSecurityNetwork publicSecurityNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpurlconnection);

        tvFuck = findViewById(R.id.tv_fuck);
        btGetData = findViewById(R.id.bt_get_data);

        btGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNetData();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
//                getDataFromInternet();
            }
        }).start();

        connectionHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                tvFuck.setText(msg.obj.toString());
                return false;
            }
        });
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
            while ((line = bufferedReader.readLine()) != null) {
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

    public void getNetData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(NET_URL);
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream inputStream = connection.getInputStream();
                    StringBuilder builder = new StringBuilder();
                    String line;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }

                    //拿到网络请求的结果
                    String result = builder.toString();
                    reader.close();
                    inputStream.close();
                    connection.disconnect();

                    //处理网络数据
                    publicSecurityNetwork = parseJson(result);
                    String fuck = String.valueOf(publicSecurityNetwork.toString()) +
                            publicSecurityNetwork.getData().toString();
                    Log.d("FUCK", fuck);
                    Message message = new Message();
                    message.what = 1;
                    message.obj = fuck;
                    connectionHandler.sendMessage(message);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private PublicSecurityNetwork parseJson(String result) throws JSONException {
        PublicSecurityNetwork publicSecurityNetwork = new PublicSecurityNetwork();
        Data data = new Data();
        JSONObject object = new JSONObject(result);
        if (object.has("status")) {
            publicSecurityNetwork.setStatus(object.getInt("status"));
        }
        if (object.has("data")) {
            JSONObject dataJson = object.getJSONObject("data");
            if (dataJson.has("cdate")) {
                data.setcDate(dataJson.getString("cdate"));
            }
            if (dataJson.has("comaddress")) {
                data.setComAddress(dataJson.getString("comaddress"));
            }
            if (dataJson.has("comname")) {
                data.setComName(dataJson.getString("comname"));
            }
            if (dataJson.has("comtype")) {
                data.setComType(dataJson.getString("comtype"));
            }
            if (dataJson.has("id")) {
                data.setId(dataJson.getString("id"));
            }
            if (dataJson.has("sitedomain")) {
                data.setSiteDomain(dataJson.getString("sitedomain"));
            }
            if (dataJson.has("sitename")) {
                data.setSiteName(dataJson.getString("sitename"));
            }
            if (dataJson.has("sitetype")) {
                data.setSiteType(dataJson.getString("sitetype"));
            }
            if (dataJson.has("updatetime")) {
                data.setUpdateTime(dataJson.getString("updatetime"));
            }
            publicSecurityNetwork.setData(data);
        }
        return publicSecurityNetwork;
    }
}