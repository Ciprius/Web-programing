package webubb.controller;

import webubb.model.DBManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuizController extends HttpServlet {

    public QuizController() {super();}
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if (action.equals("getQuestions")){
            Integer nr = Integer.parseInt(req.getParameter("nr"));
            System.out.println("1 "+nr);
            DBManager dbManager = new DBManager();
            String string =""; //dbManager.getQuestions(nr);
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }
        if (action.equals("results")){
            String ans = req.getParameter("string");
            DBManager dbManager = new DBManager();
            String string = "";//dbManager.getResults(ans);
            PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
            printWriter.println(string);
            printWriter.flush();
        }

    }
}
