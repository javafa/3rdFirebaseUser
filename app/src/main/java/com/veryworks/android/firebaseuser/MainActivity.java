package com.veryworks.android.firebaseuser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.veryworks.android.firebaseuser.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    UserAdapter adapter;

    FirebaseDatabase database;
    DatabaseReference userRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        database = FirebaseDatabase.getInstance();
        // root 노드인 user를 레퍼런스로 사용
        userRef = database.getReference("user");
        // 이벤트 리스너 달기
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot users) {
                List<User> data = new ArrayList<User>();
                for(DataSnapshot item : users.getChildren()){
                    String key = item.getKey();
                    Log.i("Firebase","user key="+key);
                    User user = item.getValue(User.class);
                    data.add(user);
                }
                refreshData(data);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    // 파이어베이스의 valueEventListener 에서 호출
    public void refreshData(List<User> data){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
