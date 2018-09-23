package reagodjj.example.com.exercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import reagodjj.example.com.exercise.R;
import reagodjj.example.com.exercise.entity.Person;

public class MyBaseAdapter extends BaseAdapter {
    private List<Person> personList;

    public MyBaseAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList == null ? 0 : personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void deleteItem(int position) {
        personList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Context context = parent.getContext();
            convertView = LayoutInflater.from(context).inflate(R.layout.new_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(personList.get(position).getIcon());
        viewHolder.textView.setText(personList.get(position).getName());

//        ImageView imageView = convertView.findViewById(R.id.iv_icon);
//        imageView.setImageResource(personList.get(position).getIcon());
//        TextView textView = convertView.findViewById(R.id.tv_name);
//        textView.setText(personList.get(position).getName());

        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;

        private ViewHolder(View view) {
            imageView = view.findViewById(R.id.iv_icon);
            textView = view.findViewById(R.id.tv_name);
        }
    }
}
