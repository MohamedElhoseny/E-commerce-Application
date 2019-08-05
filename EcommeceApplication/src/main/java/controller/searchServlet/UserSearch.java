/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.searchServlet;

import exceptions.UniqueExceptionEmplementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Brand;
import model.entity.Category;
import model.entity.User;
import services.BrandServices;
import services.CategoryServices;
import services.SearchService;
import services.UserServices;

/**
 *
 * @author pc
 */
@WebServlet(value = "/admin/UserSearch")

public class UserSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

        String searchTxt = request.getParameter("searchTxt");
        String phoneTxt = request.getParameter("phoneTxt");

        System.out.println(currentPage + " sss " + recordsPerPage + "dd" +searchTxt+"d"+phoneTxt);

        SearchService searchService = new SearchService();

        List<User> usersPagination = searchService.getUserSearch(currentPage, recordsPerPage, searchTxt, phoneTxt);

        request.setAttribute("usersPagination", usersPagination);

        int rows = searchService.getNumberOfRowsSearch(searchTxt, phoneTxt);

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("displayUsers", "displaySearchUsers");
        request.setAttribute("searchTxtValue", searchTxt);
        request.setAttribute("phoneTxtValue", phoneTxt);

        RequestDispatcher dispatcher = request.getRequestDispatcher("display-all-users.jsp");
        dispatcher.forward(request, response);
    }
}
