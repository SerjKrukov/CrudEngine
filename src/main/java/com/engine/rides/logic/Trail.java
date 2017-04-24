package com.engine.rides.logic;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Serj on 21.04.2017.
 */
@Entity
@Table(name = "TRAILS")
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRAIL_ID")
    private long id;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TITLE")
    private String title;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "REGION")
    private String region;

    @NotNull
    @Column(name = "DATE")
    private String date;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String descrption;

    @Column(name = "PHOTOLINK")
    private String photoLink;

    @Column(name = "VIDEOLINK")
    private String videoLink;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "trails")
    private Set<RiderProfile> riderProfiles = new HashSet<RiderProfile>();

    public Trail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Set<RiderProfile> getRiderProfiles() {
        return riderProfiles;
    }

    public void setRiderProfiles(Set<RiderProfile> riderProfiles) {
        this.riderProfiles = riderProfiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trail trail = (Trail) o;

        if (!getTitle().equals(trail.getTitle())) return false;
        if (!getRegion().equals(trail.getRegion())) return false;
        if (!getDate().equals(trail.getDate())) return false;
        if (!getDescrption().equals(trail.getDescrption())) return false;
        if (getPhotoLink() != null ? !getPhotoLink().equals(trail.getPhotoLink()) : trail.getPhotoLink() != null)
            return false;
        return getVideoLink() != null ? getVideoLink().equals(trail.getVideoLink()) : trail.getVideoLink() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getRegion().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getDescrption().hashCode();
        result = 31 * result + (getPhotoLink() != null ? getPhotoLink().hashCode() : 0);
        result = 31 * result + (getVideoLink() != null ? getVideoLink().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", date='" + date + '\'' +
                ", descrption='" + descrption + '\'' +
                ", photoLink='" + photoLink + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", riderProfiles=" + riderProfiles +
                '}';
    }
}
