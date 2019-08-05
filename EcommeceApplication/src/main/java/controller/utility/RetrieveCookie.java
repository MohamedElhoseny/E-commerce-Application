/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.utility;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ghazallah
 */
@WebServlet(value = "/retreiveCookie")
public class RetrieveCookie extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        Cookie cookie = null;
        Cookie[] cookies = null;

        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
        boolean checkCookie = false;
        if (cookies == null) {
            out.println("please enable cookies in your browser");
        } else {

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("myCookieName")) {
                    checkCookie = true;
                    break;
                }

            }
            if (checkCookie) {
                response.sendRedirect("Welcome");
            } else {
                out.println("please enable cookies in your browser");
            }
        }
    }

}
