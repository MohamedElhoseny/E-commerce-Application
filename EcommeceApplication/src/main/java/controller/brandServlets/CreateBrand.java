/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.brandServlets;

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
import model.entity.Brand;
import model.entity.Category;
import services.BrandServices;
import services.CategoryServices;

/**
 *
 * @author Abd Elkarim
 */
@WebServlet(value = "/admin/CreateBrand")
public class CreateBrand extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        BrandServices brandServices = new BrandServices();
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);

        if (action.equals("addBrand")) {

            try {
                int categoryValue = Integer.parseInt(request.getParameter("categoryName"));
                String brandName = request.getParameter("brandName");
                brandServices.setCategoryName(brandName, categoryValue);

                ArrayList<Brand> brandList = (ArrayList<Brand>) brandServices.getAllBrands();

                session.setAttribute("brandList", brandList);
                request.setAttribute("operation", "success");
                RequestDispatcher dispatcher = request.getRequestDispatcher("add-brand.jsp");
                dispatcher.forward(request, response);
                //response.sendRedirect("admin/add-brand.jsp");
            } catch (UniqueExceptionEmplementation ex) {
                request.setAttribute("operation", "fail");
                RequestDispatcher dispatcher = request.getRequestDispatcher("add-brand.jsp");
                dispatcher.forward(request, response);
            }
        } else if (action.equals("Update")) {
            try {
                int brandID = Integer.parseInt(request.getParameter("brandID"));
                int categoryValue = Integer.parseInt(request.getParameter("categoryName"));
                String brandName = request.getParameter("brandName");
                brandServices.updateCategoryName(brandID, brandName, categoryValue);
                ArrayList<Brand> brandList = (ArrayList<Brand>) brandServices.getAllBrands();
                session.setAttribute("brandList", brandList);
                request.setAttribute("operation", "success");
                RequestDispatcher dispatcher = request.getRequestDispatcher("manage-brands.jsp");
                dispatcher.forward(request, response);
            } catch (UniqueExceptionEmplementation ex) {
                request.setAttribute("operation", "fail");
                RequestDispatcher dispatcher = request.getRequestDispatcher("manage-brands.jsp");
                dispatcher.forward(request, response);
            }
        } else if (action.equals("Delete")) {
            int brandID = Integer.parseInt(request.getParameter("brandID"));
            try {
                brandServices.deleteCategory(brandID);
//                out.print("Data Saved successfully :)");
                ArrayList<Brand> brandList = (ArrayList<Brand>) brandServices.getAllBrands();
                session.setAttribute("brandList", brandList);
                request.setAttribute("operation", "success");
                RequestDispatcher dispatcher = request.getRequestDispatcher("manage-brands.jsp");
                dispatcher.forward(request, response);
            } catch (UniqueExceptionEmplementation ex) {
                request.setAttribute("operation", "fail");
                RequestDispatcher dispatcher = request.getRequestDispatcher("manage-brands.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//        CategoryServices categoryServices = new CategoryServices();
        String action = request.getParameter("action");

        if (action.equals("addBrand")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("add-brand.jsp");
            dispatcher.forward(request, response);
//            response.sendRedirect("admin/add-brand.jsp");
        } else if (action.equals("manageBrand")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("manage-brands.jsp");
            dispatcher.forward(request, response);
//            response.sendRedirect("admin/manage-brands.jsp");
        }

    }
}
