package com.login.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.login.bean.LoginBean;
import com.login.util.DBConnection;

public class LoginDao {

	public String authenticateUser(LoginBean loginBean) {
		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";

		try {
			con = DBConnection.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from empleados");

			while (resultSet.next()) {
				userNameDB = resultSet.getString("usuarioEmpleado");
				passwordDB = resultSet.getString("claveEmpleado");
				roleDB = resultSet.getString("codigoTipoEmpleado");

				if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("1"))
					return "1";
				else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("2"))
					return "2";
				else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("3"))
					return "3";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}
}