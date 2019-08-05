/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.orderServlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dto.OrderDTO;
import model.entity.Order;
import model.entity.User;
import services.OrderServices;
import services.UserServices;

/**
 *
 * @author ghazallah
 */
@WebServlet(value = "/client/createOrder")
public class CreateOrder extends HttpServlet {

    private OrderServices orderServices = new OrderServices();
    private UserServices userServices = new UserServices();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        String orderStr = request.getParameter("order");
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        Gson gson = new Gson();
        OrderDTO orderDTO = gson.fromJson(orderStr, OrderDTO.class);
        int orderID = orderServices.addNewOrder(orderDTO, user);
        User updatedUser = userServices.getUser(user.getEmail());
        session.setAttribute("user", updatedUser);
        out.print(orderID);
        int newOrders = orderServices.getNewOrders();
        session.setAttribute("newOrders", newOrders);

        int newOrdersWeek = orderServices.getNewOrdersWeek();
        session.setAttribute("newOrdersWeek", newOrdersWeek);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if (action.equals("displayAllOrders")) {

            int currentPage = Integer.valueOf(request.getParameter("currentPage"));
            int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

            OrderServices orderServices = new OrderServices();

            List<Order> ordersPagination = orderServices.getUsersPagenation(currentPage, recordsPerPage);

            for (int i = 0; i < ordersPagination.size(); i++) {
                System.out.println(ordersPagination.get(i).getFullName());
            }

            request.setAttribute("ordersPagination", ordersPagination);

            int rows = orderServices.getNumberOfRows();

            int nOfPages = rows / recordsPerPage;

            if (nOfPages % recordsPerPage > 0) {
                nOfPages++;
            }

            request.setAttribute("noOfPages", nOfPages);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("recordsPerPage", recordsPerPage);
            request.setAttribute("displayOrders", "displayAllOrders");
//            response.sendRedirect("../admin/orders.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("../admin/orders.jsp");
            dispatcher.forward(request, response);
        }
    }
}
