/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.orderServlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dto.OrderValidationDTO;
import model.entity.User;
import services.OrderServices;

/**
 *
 * @author ghazallah
 */
@WebServlet(value = "/client/validateProduct")
public class ValidateOrder extends HttpServlet {

    private OrderServices orderServices = new OrderServices();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //OrderServices orderServices = new OrderServices();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String orderStr = (String) request.getParameter("order");
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        Gson gson = new Gson();
        OrderValidationDTO validationList = gson.fromJson(orderStr, OrderValidationDTO.class);
        OrderValidationDTO validationList2= orderServices.validateOrderQuantity(validationList, user);
        String responseContent = gson.toJson(validationList2);
        System.out.println("response : "+""+ responseContent);
        out.println(responseContent);
    }

}
