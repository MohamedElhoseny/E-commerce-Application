/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.couponsServlets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dto.CouponDTO;
import model.dto.ProductDTO;
import services.CouponServices;
import services.ProductServices;

/**
 *
 * @author ghazallah
 */
@WebServlet(value = "/client/coupon")
public class CreateCoupon extends HttpServlet
{
    /* AS CLIENT ALLOW ONLY FOR GET PRODUCT SO NO doPost METHOD FOR CLIENT ON PRODUCTS */  
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter out = resp.getWriter();
            String action = req.getParameter("action");
            //create a service that resposible for getting data from dataStore and wrapping it to beans
            CouponServices couponServices = new CouponServices();
            //Fill products to list of beans to be used by jsp page to initialize products
            List<CouponDTO> allCoupons =  couponServices.getAllCoupons();  

            //check for the request action ?
            //if action is asynch that means client send an asynchronize request that require more products .. the response will be in json format
             if (action.equals("asynch"))
             {                          
                    GsonBuilder builder = new GsonBuilder(); 
                    builder.setPrettyPrinting(); 
                    Gson gson = builder.create();       
                    resp.setContentType("application/json");
                    out.println(gson.toJson(allCoupons));               
             }
              //this action means that forward request need data to be set as attributes to be used by jsp page to initialize its content
             else if (action.equals("init"))
             {
                    req.setAttribute("coupons", allCoupons);
                    req.getRequestDispatcher("app.jsp").forward(req, resp);  //temp forward just for test
             }
    }
      
}
