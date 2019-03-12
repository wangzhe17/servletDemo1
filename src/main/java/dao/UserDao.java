package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DBUtil;

import java.sql.SQLException;

public class UserDao {
    QueryRunner qr=new QueryRunner(DBUtil.getDataSource());
    public User login(String username,String password){
        String sql="select * from user where username=? and password=?";

        Object[] params={username,password};

        User user = null;
        try {
            user = qr.query(sql,new BeanHandler<User>(User.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("dao: "+user);
        return user;
    }
}
