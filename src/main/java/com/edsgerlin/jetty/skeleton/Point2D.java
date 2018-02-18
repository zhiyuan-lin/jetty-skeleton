package com.edsgerlin.jetty.skeleton;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Point2D {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // Persistent Fields:
    private int x;
    private int y;

    // Constructor:
    Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point2D() {
    }

    // Accessor Methods:
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // String Representation:
    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", this.id, this.x, this.y);
    }
}
