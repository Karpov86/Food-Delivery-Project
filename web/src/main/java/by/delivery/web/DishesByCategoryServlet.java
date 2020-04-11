package by.delivery.web;

import by.delivery.entity.Dish;
import by.delivery.service.DishServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.delivery.util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/menu", name = "DishesByCategoryServlet")
public class DishesByCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Dish> dishes = new DishServiceImpl().find((request.getParameter("category")));
        request.setAttribute("dishes", dishes);
        request.getRequestDispatcher(createViewPath("menu")).forward(request, response);

    }
}
