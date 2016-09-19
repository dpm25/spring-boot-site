package com.mahoney.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String note;
    Date createDate;
    Date dueDate;
    boolean complete;

    public Todo() {
    }

    public Todo(Long id, String title, String note, Date createDate, Date dueDate, boolean complete) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {

        this.createDate = createDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        if (complete != todo.complete) return false;
        if (title != null ? !title.equals(todo.title) : todo.title != null) return false;
        if (note != null ? !note.equals(todo.note) : todo.note != null) return false;
        if (createDate != null ? !createDate.equals(todo.createDate) : todo.createDate != null) return false;
        return dueDate != null ? dueDate.equals(todo.dueDate) : todo.dueDate == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (complete ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", complete=" + complete +
                '}';
    }
}
