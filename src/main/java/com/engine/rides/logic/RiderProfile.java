package com.engine.rides.logic;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Serj on 21.04.2017.
 */
@Entity
@Table(name = "RIDER_PROFILES")
public class RiderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RIDER_PROFILE_ID")
    private long id;

    @NotNull
    @Size(min = 2,max = 200)
    @Column(name = "NAME")
    private String name;

    @Size(min = 1, max = 30)
    @Column(name = "NICKNAME")
    private String nickname;

    @Min(2)
    @Column(name = "AGE")
    private Integer age;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RIDES",
            joinColumns = {@JoinColumn(name = "RIDER_PROFILE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TRAIL_ID")})
    private Set<Trail> trails = new HashSet<Trail>();


    public RiderProfile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Trail> getTrails() {
        return trails;
    }

    public void setTrails(Set<Trail> trails) {
        this.trails = trails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiderProfile that = (RiderProfile) o;

        if (!getName().equals(that.getName())) return false;
        if (getNickname() != null ? !getNickname().equals(that.getNickname()) : that.getNickname() != null)
            return false;
        return getAge() != null ? getAge().equals(that.getAge()) : that.getAge() == null;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + (getNickname() != null ? getNickname().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RiderProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trails=" + trails +
                '}';
    }
}
