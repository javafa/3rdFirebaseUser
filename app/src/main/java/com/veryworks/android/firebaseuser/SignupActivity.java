package com.veryworks.android.firebaseuser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.veryworks.android.firebaseuser.domain.User;

public class SignupActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference userRef;

    EditText editEmail, editName, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("user");

        editEmail = (EditText) findViewById(R.id.editEmail);
        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
    }

    // Sign Up 버튼의 onClick 속성에 직접 연결
    // android:onClick="postData"
    public void postData(View view){
        String email = editEmail.getText().toString();
        String name = editName.getText().toString();
        String password = editPassword.getText().toString();
        // 정규식으로 이메일이 맞는 지 체크후

        // 패스워드 자릿수 체크

        // 파이어베이스에 저장할 User 객체 생성
        User user = new User(name, email, password);

        // 파이어베이스에 키를 자동으로 생성
        String childKey = userRef.push().getKey();  // << hash 코드로 된 키를 레퍼런스 아래에 삽입해준다
        userRef.child(childKey).setValue(user);

    }
}
