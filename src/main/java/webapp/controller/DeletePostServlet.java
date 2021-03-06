package webapp.controller;

import webapp.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deletePostServlet", urlPatterns = "/delete-post")
public class DeletePostServlet extends HttpServlet {
    private PostService postService = PostService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("servlet id: " + id);
        postService.deletePost(id);
        req.getRequestDispatcher("/posts").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
