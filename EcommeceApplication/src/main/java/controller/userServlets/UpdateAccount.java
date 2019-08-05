/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.userServlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.User;
import model.entity.UserCredit;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import services.UserServices;

/**
 *
 * @author solo
 */
public class UpdateAccount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        try {
            User user = (User) request.getSession().getAttribute("user");
            UserServices service = new UserServices();
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
                            user.setName(value);
                            break;
                        case "email":
                            user.setEmail(value);
                            break;
                        case "phone":
                            user.setPhone(value);
                            break;
                        case "new-password":
                            if (!value.equals("")) {
                                user.setPassword(value);
                            }
                            break;
                        case "creditcardnumber":
                            if (!value.equals("")) {
                                // if the user hasen't linked an account before

                                UserCredit userCredit = new UserCredit();
                                userCredit.setCreditcard(value);
                                if (user.getUserCredit() == null) {
                                    user.setUserCredit(userCredit);
                                    service.createUserCredit(user, userCredit);

                                } else {

                                    service.updateUserCredit(user, userCredit);
                                }
                                user.getUserCredit().setCreditcard(value);
                                

                            } 
                            break;
                            case"wallet":
                                if(!value.equals("") && user.getUserCredit() != null){
                                    UserCredit userCredit = new UserCredit();
                                    userCredit.setCreditcard(user.getUserCredit().getCreditcard());
                                    userCredit.setWallet(Integer.parseInt(value.replaceAll("\\D+","")));
                                    service.updateUserCredit(user, userCredit);
                                }
                                    
                                    
                                

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
                            File targetFile = new File(request.getServletContext().getRealPath("") + "/client/images/users_image/" + user.getPhone() + "." + extention);
                            user.setPicture(user.getPhone() + "." + extention);
                            if (targetFile.exists())
                                targetFile.delete();
                            item.write(targetFile);
                        } else {
                            user.setPicture(user.getPicture());
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

            service.updateUser(user);

        } catch (FileUploadException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("Welcome");

    }

}
