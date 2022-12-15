/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.CarDAO;
import pe.CarDTO;
import pe.CarErrorDTO;

/**
 *
 * @author hohon
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String SUCCESS = "carList.jsp";
    private static final String ERROR = "carList.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price;
            int speed;

            CarDAO dao = new CarDAO();
            boolean validate = true;
            CarErrorDTO error = new CarErrorDTO();

            //check string
            if (id.length() < 5 || id.length() > 20) {
                error.setId("id length must [5,20]");
                validate = false;
            }

            if (dao.checkDuplicate(id)) {
                error.setId("id is duplicated!");
                validate = false;

            }

            if (name.length() < 5 || name.length() > 20) {
                error.setName("name length must [5,20]");
                validate = false;
            }

            if (description.length() < 5 || description.length() > 20) {
                error.setDescription("description length must [5,20]");
                validate = false;
            }

            // check number double
            try {
                price = Double.valueOf(request.getParameter("price"));
                if (price < 0) {
                    validate = false;
                    error.setPrice("price must is positive number");
                }
            } catch (Exception e) {
                error.setPrice("price must is number");
                price = -1;
                validate = false;
            }
            //-------------------------------------------------------------------------------

            // check number int
            try {
                speed = Integer.valueOf(request.getParameter("speed"));
                if (speed < 0) {
                    validate = false;
                    error.setSpeed("speed must is positive number");
                }
            } catch (Exception e) {
                error.setSpeed("speed must is number");
                speed = -1;
                validate = false;
            }
//-------------------------------------------------------------------------------
            if (validate) {
                CarDTO car = new CarDTO(id, name, description, price, speed, true);
                boolean checkInsert = dao.insert(car);
                if (checkInsert) {
                    request.setAttribute("MESSAGE", "Create successfully!");
                }
            } else {
                request.setAttribute("ERROR", error);
            }

        } catch (Exception e) {
            log("Error at Update Controller: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
