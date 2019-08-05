/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.searchServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Order;
import model.entity.Product;
import model.entity.User;
import services.OrderSearchService;
import services.ProductSearchService;
import services.SearchService;

/**
 *
 * @author pc
 */
@WebServlet(value = "/client/OrderSearch")

public class OrderSearch extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

        String orderSearchTxt = request.getParameter("orderSearchTxt");

        System.out.println(currentPage + " sss " + recordsPerPage + "dd" + orderSearchTxt);

        OrderSearchService orderSearchService = new OrderSearchService();

        List<Order> ordersPagination = orderSearchService.getOrderSearch(currentPage, recordsPerPage, orderSearchTxt);

        request.setAttribute("ordersPagination", ordersPagination);

        int rows = orderSearchService.getNumberOfRowsOrderSearch(orderSearchTxt);

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("displayOrders", "displaySearchOrder");
        request.setAttribute("searchTxtValue", orderSearchTxt);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../admin/orders.jsp");
        dispatcher.forward(request, response);
    }
}
