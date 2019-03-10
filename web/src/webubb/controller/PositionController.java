package webubb.controller;

import webubb.model.DBManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PositionController extends HttpServlet
{
    public  PositionController() {super();}

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action.equals("pos")) {
            Integer X = Integer.parseInt(req.getParameter("X"));
            Integer Y = Integer.parseInt(req.getParameter("Y"));
            DBManager dbManager = new DBManager();
            String rez =""; //dbManager.check(X, Y);
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            if (rez.equals("exists")) {
                printWriter.println(100);
            } else {
                if (rez.equals("toofar")) {
                    printWriter.println(50);
                } else
                    printWriter.println(rez);
            }
            printWriter.flush();
        }
        if (action.equals("delete")){
            DBManager dbManager = new DBManager();
            dbManager.del();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher;
        requestDispatcher = req.getRequestDispatcher("/lemn.jsp");
        requestDispatcher.forward(req, resp);
    }
}
