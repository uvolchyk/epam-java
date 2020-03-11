package com.company.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Announcement extends Model {
    private Restaurant owner;
    private List<Position> positions;
    private Date date;

    public Restaurant getOwner() {
        return owner;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public Date getDate() {
        return date;
    }

    public void setOwner(Restaurant owner) {
        this.owner = owner;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Announcement.class.getSimpleName() + "[", "]")
                .add("owner=" + owner)
                .add("positions=" + positions)
                .add("date=" + date)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announcement that = (Announcement) o;
        return getOwner().equals(that.getOwner()) &&
                getPositions().equals(that.getPositions()) &&
                getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner(), getPositions(), getDate());
    }
}
