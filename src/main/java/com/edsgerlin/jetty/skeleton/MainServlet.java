package com.edsgerlin.jetty.skeleton;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = "/*")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = -1633324050988750108L;
    @Inject
    private HelloGreeter greeter;
    @Inject
    private EntityManager entityManager;
    @Inject
    private Point2DRepository point2dRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Query query = entityManager.createNativeQuery("SELECT NOW()");
        entityManager.getTransaction().begin();
        entityManager.persist(new Point2D(1, 1));
        entityManager.getTransaction().commit();
        final String points = String.join(", ",
                point2dRepository.findAll().stream().map(p -> p.toString()).collect(Collectors.toList()));

        resp.getWriter()
                .write("hello em" + req.getRequestURI() + greeter.getGreeting() + query.getSingleResult() + points);

    }
}
