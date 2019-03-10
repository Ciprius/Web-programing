package webubb.model;

import sun.plugin.javascript.navig.Array;
import webubb.domain.Tuple;
import webubb.domain.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class DBManager {
    private Statement stmt;
    private PreparedStatement preparedStatement,preparedStatement1,preparedStatement2,preparedStatement3;


    public DBManager() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/labphp", "root", "");
            stmt = con.createStatement();
            preparedStatement = con.prepareStatement("delete from bibliographyentry where idcat=?");
            preparedStatement1 = con.prepareStatement("delete from category where id=?");
            preparedStatement2 = con.prepareStatement("insert into bibliographyentry(idcat,author,title,numberOfPages,year,cost) " +
                    " values (?, ?, ?, ?, ?, ?)");
            preparedStatement3 = con.prepareStatement("update category set numberOfEntries= ? where id=?");
        } catch(Exception ex) {
            System.out.println("eroare la connect:"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String getBiblio(String string)
    {
        ResultSet rs;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            rs = stmt.executeQuery("SELECT c.name as name,b.author as author" +
                    ",b.title as title,b.year as year,b.cost as cost from bibliographyentry " +
                    "as b inner join category as c on b.idcat = c.id ");
            while (rs.next())
            {
                if (rs.getString("title").contains(string) || rs.getString("author").contains(string))
                stringBuilder.append("Name:")
                        .append(rs.getString("name"))
                        .append(" author:")
                        .append(rs.getString("author"))
                        .append(" title:")
                        .append(rs.getString("title"))
                        .append(" year:")
                        .append(rs.getString("year"))
                        .append(" cost:")
                        .append(rs.getString("cost"))
                        .append("|");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

   public String delCat(String cat)
   {
       ResultSet rs;

       try {
           rs = stmt.executeQuery("SELECT id from category where `name`='"+cat+"'");
           rs.next();
           int id = rs.getInt("id");
           preparedStatement.setInt(1,id);
           preparedStatement1.setInt(1,id);
           preparedStatement.execute();
           preparedStatement1.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return "da";
   }

   public String addBib(String string){
        String[] strings = string.split("=");
        ResultSet rs;

        for (String str : strings){
            if (str.length() != 0)
            {
                String[] strings1 = str.split("-");
                try {
                    preparedStatement2.setInt(1,Integer.parseInt(strings1[0]));
                    preparedStatement2.setString(2,strings1[1]);
                    preparedStatement2.setString(3,strings1[2]);
                    preparedStatement2.setInt(4,Integer.parseInt(strings1[3]));
                    preparedStatement2.setInt(5,Integer.parseInt(strings1[4]));
                    preparedStatement2.setInt(6,Integer.parseInt(strings1[5]));
                    preparedStatement2.execute();

                    rs = stmt.executeQuery("SELECT numberOfEntries from category where id="+Integer.parseInt(strings1[0]));
                    rs.next();
                    int nr = rs.getInt("numberOfEntries");
                    nr++;
                    preparedStatement3.setInt(1,nr);
                    preparedStatement3.setInt(2,Integer.parseInt(strings1[0]));
                    preparedStatement3.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "da";
   }

   public String GetP(){

        return "da";
   }










//    public ArrayList<String> getLinks(String oras){
//        ResultSet rs;
//        ArrayList<String> array = new ArrayList<>();
//        try {
//            rs = stmt.executeQuery("select Id from city where Name ='"+oras+"'");
//            rs.next();
//            Integer Id = rs.getInt("Id");
//            rs = stmt.executeQuery("select Duration,Distance,C1.Name as Name1,C2.Name as Name2 " +
//                    "from link as l inner join city as C1 on l.IdCity1=C1.Id inner join city as C2 on l.IdCity2=C2.Id " +
//                    "where l.IdCity1="+Id + " or "+ "l.IdCity2="+Id);
//            while(rs.next()){
//                StringBuilder stringBuilder = new StringBuilder();
//                stringBuilder.append("Name1:")
//                        .append(rs.getString("Name1"))
//                        .append(" Name2:")
//                        .append(rs.getString("Name2"))
//                        .append(" Duration:")
//                        .append(rs.getString("Duration"))
//                        .append(" Distance:")
//                        .append(rs.getString("Distance"));
//                array.add(stringBuilder.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(array);
//        return  array;
//    }
//    public ArrayList<String> GetTests()
//    {
//        ArrayList<String> list = new ArrayList<>();
//        String test = u.getCompletedTests();
//        String[] tests = test.split(" ");
//        Integer max = 0;
//        for(String te: tests){
//            try {
//                Integer rez = getTestLevel(te);
//                if(max < rez)
//                    max = rez;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        max = max + 1;
//        ResultSet rs;
//        try {
//            rs = stmt.executeQuery("select * from test where `level` <='"+max+"'");
//            while(rs.next())
//            {
//                String string ="name:" + rs.getString("name") + " level:"+ rs.getString("level");
//                list.add(string);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    private Integer getTestLevel(String name) throws SQLException {
//        ResultSet rs;
//        rs = stmt.executeQuery("select `level` from test where name='"+name+"'");
//        rs.next();
//        return  Integer.parseInt(rs.getString("level"));
//    }
//
//    public String getGame(Integer id)
//    {
//        Tid = id;
//        ResultSet rs;
//        ans = new ArrayList<>();
//        StringBuilder answ = new StringBuilder();
//        try {
//            rs = stmt.executeQuery("select question,correct from question where tid="+id);
//            while (rs.next())
//            {
//                ans.add(rs.getString("correct"));
//                answ.append(rs.getString("question")).append("|");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return answ.toString();
//    }
//
//    public String getPoints(){
//        String[] strings = u.getCompletedTests().split(" ");
//        StringBuilder rez= new StringBuilder();
//        for (String st: strings)
//        {
//            try {
//                Integer point = getTestLevel(st);
//                rez.append(point).append(" ");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return  rez.toString();
//    }
//
//    public String getGames(){
//        return u.getCompletedTests();
//    }
//
//    public Integer checkAns(String name) {
//        String[] anss = name.split(" ");
//        System.out.println(anss.length + " "+ ans.size());
//        if (anss.length != ans.size())
//            return 0;
//        else {
//            int i=0;
//            for (String st: ans){
//                if (!st.equals(anss[i]))
//                    return 0;
//                i++;
//            }
//        }
//        ResultSet rs;
//        try {
//            rs = stmt.executeQuery("select `name` from test where tid="+Tid);
//            rs.next();
//            String string = rs.getString("name");
//            String str = u.getCompletedTests();
//            str += " " + string;
//            u.setCompletedTests(str);
//            preparedStatement.setString(1,u.getCompletedTests());
//            //preparedStatement.setString(2,u.getUsername());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 1;
//    }
//
//    public String check(Integer X, Integer Y) {
//        System.out.println("lem");
//        System.out.println(X + " " + Y);
//        Integer x, y;
//        try {
//            for(Tuple tpl : coord) {
//                if (tpl.getX().equals(X) && tpl.getY().equals(Y))
//                    return "exists";
//            }
//            Tuple tuple1 = coord.get(coord.size() - 1);
//            x = tuple1.getX();
//            y = tuple1.getY();
//            if ((Math.abs(x - X) == 1 && y.equals(Y)) || (Math.abs(y - Y) == 1 && x.equals(X))) {
//                coord.add(new Tuple(X,Y));
//                preparedStatement.setString(1, X.toString());
//                preparedStatement.setString(2, Y.toString());
//                preparedStatement.executeUpdate();
//                return "#td" + x + y;
//            } else {
//                return "toofar";
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "";
  //  }

    public void del(){
//        coord.clear();
//        coord.add(new Tuple(1,0));
    }
}