/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.userServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.User;
import services.UserServices;

/**
 *
 * @author pc
 */
@WebServlet(value = "/admin/UserController")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if (action.equals("displayAllUsers")) {

            int currentPage = Integer.valueOf(request.getParameter("currentPage"));
            int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));

            UserServices countryService = new UserServices();

            List<User> usersPagination = countryService.getUsersPagenation(currentPage,recordsPerPage);

//            for (int i = 0; i < usersPagination.size(); i++) {
//                System.out.println(usersPagination.get(i).getEmail());
//            }
            
            request.setAttribute("usersPagination", usersPagination);

            int rows = countryService.getNumberOfRows();

            int nOfPages = rows / recordsPerPage;

            if (nOfPages % recordsPerPage > 0) {
                nOfPages++;
            }

            request.setAttribute("noOfPages", nOfPages);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("recordsPerPage", recordsPerPage);
            request.setAttribute("displayUsers","displayAllUsers");
            RequestDispatcher dispatcher = request.getRequestDispatcher("display-all-users.jsp");
            dispatcher.forward(request, response);
        }
    }
}
