package webubb.controller;

import webubb.model.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RouteController extends HttpServlet
{
    public RouteController() {super();}

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action.equals("getCities"))
        {
            DBManager dbManager = new DBManager();
            String string =""; //dbManager.getCities();
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }
        if (action.equals("getLinks"))
        {
            DBManager dbManager = new DBManager();
            ArrayList<String> string =new ArrayList<>(); //dbManager.getLinks(req.getParameter("city"));
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }

    }
}
