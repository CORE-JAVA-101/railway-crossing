package com.railway.app.servlet;

import com.railway.app.dao.RailwayCrossingDAO;
import com.railway.app.model.RailwayCrossing;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PublicRailwayServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
    List<RailwayCrossing> crossings = crossingDAO.getAllRailwayCrossings();

    // Set the list as an attribute in the request
    request.setAttribute("crossings", crossings);

    // Forward the request to the JSP for rendering
    request.getRequestDispatcher("public/railway-list.jsp").forward(request, response);
  }
}
