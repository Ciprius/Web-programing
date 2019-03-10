package webubb.controller;

import jdk.nashorn.internal.runtime.Debug;
import sun.security.pkcs11.Secmod;
import webubb.model.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestController extends HttpServlet
{
    public TestController() {super();}

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action.equals("gettests"))
        {
            System.out.println("lemn");
            DBManager dbManager = new DBManager();
            ArrayList<String> list= new ArrayList<>(); //dbManager.GetTests();
            System.out.println(list.toString());
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(list);
            printWriter.flush();
        }
        if (action.equals("getgame")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            DBManager dbManager = new DBManager();
            String string =""; //dbManager.getGame(id);
            System.out.println(string);
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }

        if (action.equals("getpoints")){
            DBManager dbManager = new DBManager();
            String string ="lemng"; //dbManager.getPoints();
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }
        if (action.equals("getgames")){
            DBManager dbManager = new DBManager();
            String string ="sdf"; //dbManager.getGames();
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }
        if (action.equals("checkans")){
            String ans = req.getParameter("name");
            DBManager dbManager = new DBManager();
            Integer string =0; //dbManager.checkAns(ans);
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher;
        requestDispatcher = req.getRequestDispatcher("/lemn.jsp");
        requestDispatcher.forward(req, resp);
    }
}
