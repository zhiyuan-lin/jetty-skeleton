package com.edsgerlin.jetty.skeleton;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class PointApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(PointResource.class);
        return classes;
    }
}