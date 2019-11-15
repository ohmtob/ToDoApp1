package com.example.ToDoApp;

public class UserHasList {

    private Long userid;
    private Long listid;

    public UserHasList() {
    }

    public UserHasList(Long userid, Long listid) {
        this.userid = userid;
        this.listid = listid;
    }

    public Long getUserId() {
        return userid;
    }

    public Long getListId() {
        return listid;
    }
}
