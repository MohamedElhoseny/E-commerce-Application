/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.userServlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import services.UserServices;

/**
 *
 * @author ghazallah
 */
public class Register extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            User newUser = new User();

            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            // ietrate for first type for form fields
            for (FileItem item : items) {
                if (item.isFormField()) {
                    //processFormField(item);
                    String name = item.getFieldName();
                    String value = item.getString();
                    switch (name) {
                        case "name":
                            newUser.setName(value);
                            break;
                        case "email":
                            newUser.setEmail(value);
                            break;
                        case "gender":
                            newUser.setGender(value);
                            break;
                        case "phone":
                            newUser.setPhone(value);
                            break;
                        case "password":
                            newUser.setPassword(value);
                            break;
                        default:
                            break;
                    }

                }
            }
            // iterate for the second time for files
            for (FileItem item : items) {
                // processUploadedFile(item);
                if (!item.isFormField()) {
                    try {

                        new File(request.getServletContext().getRealPath("") + "/client/images/users_image").mkdirs();
                        String extention = FilenameUtils.getExtension(item.getName());
                        if (extention != "") {
                            File targetFile = new File(request.getServletContext().getRealPath("") + "/client/images/users_image/" + newUser.getPhone() + "." + extention);
                            newUser.setPicture(newUser.getPhone() + "." + extention);
                            item.write(targetFile);
                        } else {
                            newUser.setPicture(newUser.getGender()+".png");
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

            UserServices service = new UserServices();
            newUser.setRole(0);
            newUser.setRegisterationDate(new Date());
            service.createUser(newUser);
        } catch (FileUploadException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("Welcome");

    }

}
