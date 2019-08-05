/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.userServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.User;
import services.UserServices;

/**
 *
 * @author ghazallah
 */
@WebServlet(value = "/client/wishlist")
public class WishList extends HttpServlet {
    
    UserServices userServices = new UserServices();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);

        // get current  user
        User user = (User) session.getAttribute("user");
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        userServices.addToWishList(user, productId);
    }
    
     @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // get current  user
        User user = (User) session.getAttribute("user");

        String pid = request.getParameter("productId");
        System.out.println("Product to remove : "+pid);
        int productId = Integer.parseInt(pid);

        userServices.deleteFromWishList(user, productId);
    }
    
}
