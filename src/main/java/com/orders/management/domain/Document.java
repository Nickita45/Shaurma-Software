package com.orders.management.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@OneToMany(mappedBy = "order_id")
    private Integer id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private boolean done;

    //@ManyToOne
    //@JoinColumn(name = "line_id", nullable=false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order_id", fetch = FetchType.EAGER)
    private Set<Line> lines;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashier_id")
    private User user_cash;

    public User getUser_cash() {
        return user_cash;
    }

    public void setUser_cash(User user_cash) {
        this.user_cash = user_cash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(){
        this.date = LocalDateTime.now();
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }


    public Set<Line> getLines() {
        return lines;
    }

    public void setLines(Set<Line> lines) {
        this.lines = lines;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
