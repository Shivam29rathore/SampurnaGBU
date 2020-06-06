package com.cs.blogger.Model;

public class TimetableHelper {

    public String subject;
    public String faculty;
    public String timing;
    public String roomno;

    public TimetableHelper(String subject, String faculty, String timing, String roomno) {
        this.subject = subject;
        this.faculty = faculty;
        this.timing = timing;
        this.roomno = roomno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }
}
