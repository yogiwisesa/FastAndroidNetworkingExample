package com.yogiw.fastandroidnetworking;

import java.util.List;

public class NoteDao {

    private List<NotesBean> notes;

    public List<NotesBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NotesBean> notes) {
        this.notes = notes;
    }

    public static class NotesBean {
        /**
         * _id : 5ac48a1a1c46490014c13b5c
         * text : besok jalan jalan
         * user : yogiw
         * __v : 0
         */

        private String _id;
        private String text;
        private String user;
        private int __v;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }
    }
}
