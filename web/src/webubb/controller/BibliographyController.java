package webubb.controller;

import webubb.model.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BibliographyController extends HttpServlet
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");
        DBManager db = new DBManager();

        if (action.equals("getB")){
            String str = req.getParameter("string");
            String string= db.getBiblio(str);
            System.out.println(string+" lemn");
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }

        if (action.equals("del")){
            String str = req.getParameter("category");
            String string= db.delCat(str);
            System.out.println(string+" lemn");
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }

        if (action.equals("addbib")){
            String str = req.getParameter("add");
            String string= db.addBib(str);
            System.out.println(string+" lemn");
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }

        if (action.equals("show")){
            String string= db.GetP();
            System.out.println(string+" lemn");
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }
    }
}
