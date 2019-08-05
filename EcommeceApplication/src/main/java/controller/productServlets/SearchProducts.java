/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.productServlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dal.daoImplementation.ProductDAOImpl;
import model.dto.ProductDTO;
import model.entity.Product;
import services.ProductServices;

/**
 *
 * @author Azza
 */
@WebServlet(value = "/client/searchProducts")
public class SearchProducts extends HttpServlet {

    static List<Product> AllMsg = new ArrayList<Product>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ProductServices productServices = new ProductServices();
        String req = request.getParameter("search-product");
        List<ProductDTO> allProducts = productServices.getResultsProducts(req);
        request.setAttribute("result", allProducts);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
 
        out.print(gson.toJson(allProducts));
    }
    
     
}
