/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adminServlets;

import exceptions.UniqueExceptionEmplementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dal.dao.OrderDAO;
import model.dal.daoImplementation.OrderDAOImpl;
import model.dto.ProductDTO;
import model.entity.Brand;
import model.entity.Category;
import model.entity.Order;
import model.entity.Product;
import model.entity.User;
import services.BrandServices;
import services.CategoryServices;
import services.OrderServices;
import services.ProductServices;
import services.StatisticsService;
import services.UserServices;

/**
 *
 * @author pc
 */
@WebServlet(value = "/admin/AdminController")
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        CategoryServices categoryServices = new CategoryServices();
        ArrayList<Category> categoryList = (ArrayList<Category>) categoryServices.getAllCategories();
        session.setAttribute("categoryList", categoryList);

        BrandServices brandServices = new BrandServices();
        ArrayList<Brand> brandList = (ArrayList<Brand>) brandServices.getAllBrands();
//        for (int i = 0; i < brandList.size(); i++) {
//            System.out.println(brandList.get(i).getName());
//        }
        session.setAttribute("brandList", brandList);

        ProductServices productServices = new ProductServices();
        ArrayList<ProductDTO> productList = (ArrayList<ProductDTO>) productServices.getAllProducts();
//        session.setAttribute("productList", productList);

        UserServices userServices = new UserServices();
        ArrayList<User> userList = (ArrayList<User>) userServices.getAllUsers();
        //session.setAttribute("userList", userList);

        OrderServices orderServices = new OrderServices();
//        orderServices.getAllOrders();
        int newOrders = orderServices.getNewOrders();
        session.setAttribute("newOrders", newOrders);

        int newOrdersWeek = orderServices.getNewOrdersWeek();
        session.setAttribute("newOrdersWeek", newOrdersWeek);

        int newProducts = productServices.getNewProducts();
        session.setAttribute("newProducts", newProducts);

        int newUsers = userServices.getNewUsers();
        session.setAttribute("newUsers", newUsers);

        //for testing
        // display new orders 
//        OrderDAO orderDAO = new OrderDAOImpl();
//        ArrayList<Order> orderList = (ArrayList<Order>) orderDAO.retreive();
//        System.out.println(orderList.get(0).getDate());
//        session.setAttribute("orderList", orderList);
        // here complete get all things cat,brand,pro,users
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);

    }
}
