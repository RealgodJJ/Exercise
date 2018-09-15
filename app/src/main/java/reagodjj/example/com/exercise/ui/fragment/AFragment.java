package reagodjj.example.com.exercise.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import reagodjj.example.com.exercise.ui.DataChangeListener;
import reagodjj.example.com.exercise.R;

public class AFragment extends Fragment {
    private Context context;
    private TextView tvShow;
    private Button btActivityShow;
    private DataChangeListener dataChangeListener;

    public void setDataChangeListener(DataChangeListener dataChangeListener) {
        this.dataChangeListener = dataChangeListener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //当Fragment试图创建完成之后回调
        tvShow = view.findViewById(R.id.tv_show_a);
        btActivityShow = view.findViewById(R.id.bt_activity_show);
        btActivityShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataChangeListener != null) {
                    String data = tvShow.getText().toString();
                    dataChangeListener.onDataChange(data);
                }
            }
        });
    }

    public void setData(String s) {
        tvShow.setText(s);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //在父容器Activity的onCreate方法完成过后回调，做数据的处理
        Bundle bundle = getArguments();
        assert bundle != null;
        tvShow.setText(getString(R.string.a) +  bundle.getString("data"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
