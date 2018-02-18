package com.edsgerlin.jetty.skeleton;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Point2DRepository {
    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Point2D> findAll() {
        return entityManager.createQuery("SELECT point FROM " + Point2D.class.getSimpleName() + " point").getResultList();
    }
}
