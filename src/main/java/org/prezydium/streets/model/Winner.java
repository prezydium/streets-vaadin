package org.prezydium.streets.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Winner {

    @Id
    private Long id;

    private String nick;

    private Integer chancesLeft;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getChancesLeft() {
        return chancesLeft;
    }

    public void setChancesLeft(Integer chancesLeft) {
        this.chancesLeft = chancesLeft;
    }
}
