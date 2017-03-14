package com.hanbit.contactsapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hanbit.contactsapp.R;
import com.hanbit.contactsapp.dao.ListQuery;
import com.hanbit.contactsapp.domain.MemberBean;
import com.hanbit.contactsapp.service.ListService;

import java.util.ArrayList;

import static com.hanbit.contactsapp.R.id.mList;

public class MemberlistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberlist);
        final ListView listView= (ListView) findViewById(mList);
        final MemberBean member = new MemberBean();
        final MemberList mlist = new MemberList(MemberlistActivity.this);
        ListService service = new ListService() {
            @Override
            public ArrayList<?> list() {
                ArrayList<?>list=mlist.list("SELECT _id AS id,name,phone,age,address,salary FROM Member;");
                return list;
            }
        };
        ArrayList<?>list=service.list();
        //  Toast.makeText(MemberlistActivity.this,((MemberBean)list.get(0)).getName(), Toast.LENGTH_LONG).show();
        listView.setAdapter(new MemberAdapter(list,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                MemberBean member = (MemberBean)listView.getItemAtPosition(i);
                Intent intent = new Intent(MemberlistActivity.this,MemberdetailActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });

    }
    class MemberList extends ListQuery{
         public MemberList(Context context) {
            super(context);
        }
        @Override
        public ArrayList<?> list(String sql){
            ArrayList<MemberBean> list=new ArrayList<>();
            SQLiteDatabase db=super.getDatabase();
            Cursor cursor=db.rawQuery(sql,null);
            MemberBean bean = null;
            if(cursor!=null){
                if(cursor.moveToFirst()){
                    do{
                        bean=new MemberBean();
                        bean.setId(cursor.getString(cursor.getColumnIndex("id")));
                        bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                        bean.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                        bean.setAge(cursor.getString(cursor.getColumnIndex("age")));
                        bean.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                        bean.setSalary(cursor.getString(cursor.getColumnIndex("salary")));
                        list.add(bean);
                    }while (cursor.moveToNext());
                }
            }
            return list;
        }
    }
    class MemberAdapter extends BaseAdapter {
        ArrayList<?>list;
        LayoutInflater inflater;
        private int[] photos={
                R.drawable.cupcake,
                R.drawable.donut,
                R.drawable.eclair,
                R.drawable.froyo,
                R.drawable.gingerbread,
                R.drawable.honeycomb,
                R.drawable.icecream,
                R.drawable.jellybean,
                R.drawable.kitkat,
                R.drawable.lollipop
        };

        public MemberAdapter(ArrayList<?> list, Context context) {
            this.list = list;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View v, ViewGroup g) {
            ViewHolder holder;
            if(v==null){
                v=inflater.inflate(R.layout.member_item,null);
                holder=new ViewHolder();
                holder.profileImg= (ImageView) v.findViewById(R.id.profileImg);
                holder.tvName= (TextView) v.findViewById(R.id.tvName);
                holder.tvPhone= (TextView) v.findViewById(R.id.tvPhone);
                v.setTag(holder);
            }else{
                holder= (ViewHolder) v.getTag();
            }
            holder.profileImg.setImageResource(photos[i]);
            holder.tvName.setText(((MemberBean) list.get(i)).getName());
            holder.tvPhone.setText(((MemberBean) list.get(i)).getPhone());
            return v;
        }
    }
    static class ViewHolder{
        ImageView profileImg;
        TextView tvName;
        TextView tvPhone;
    }
}
