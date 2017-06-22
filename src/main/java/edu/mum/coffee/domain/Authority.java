package edu.mum.coffee.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by trauma_sushan on 6/21/2017.
 */
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String authority;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private Person person;

    public Authority(Person user,String authority){
        this.person = user;
        this.authority = authority;
    }

    public Authority(){}

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
