package com.edsgerlin.jetty.skeleton;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class HelloGreeter {
    public String getGreeting() {
        return "Hello, world!";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("HelloGreeter constructed!");
    }
}
