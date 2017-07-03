package com.veryworks.android.firebaseuser.domain;

public class User {
    // 멤버필드, 속성, 멤버변수, 전역변수
    public String username;
    public String email;

    // 생성자
    public User() {

    }

    // 파라미터가 있는 생성자 오버로드
    public User(String username, String email){
        this.username = username;
        this.email = email;
    }
}