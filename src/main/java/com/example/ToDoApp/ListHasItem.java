package com.example.ToDoApp;

import java.sql.Date;

public class ListHasItem {


        private Long listid;
        private Long itemid;
        private Date created;

        public ListHasItem() {
        }



    public ListHasItem(Long listid, Long itemid, Date created) {
        this.listid = listid;
        this.itemid = itemid;
        this.created = created;
    }

    public Long getListId() {
        return listid;
    }

    public void setListId(Long listid) {
        this.listid = listid;
    }

    public Long getItemId() {
        return itemid;
    }

    public void setItemId(Long itemid) {
        this.itemid = itemid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

