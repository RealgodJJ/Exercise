package reagodjj.example.com.exercise.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import reagodjj.example.com.exercise.R;

public class TextFragment extends Fragment {

    private TextView tvShowNo;

    public static TextFragment getTextFragment(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        TextFragment textFragment = new TextFragment();
        textFragment.setArguments(bundle);
        return textFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("String", "onCreateView");
        return inflater.inflate(R.layout.new_fragment_first, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvShowNo = view.findViewById(R.id.tv_new_fragment_first);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String text = bundle.getString("text");
        tvShowNo.setText(text);
    }

    @Override
    public void onDestroy() {
        Log.d("String", "onDestroy" + tvShowNo.getText().toString());
        super.onDestroy();
    }
}
