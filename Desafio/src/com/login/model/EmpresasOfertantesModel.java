
package com.login.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.login.bean.*;
import com.login.util.DBConnection;

public class EmpresasOfertantesModel extends DBConnection {
	public List<EmpresasOfertantesBean> listar() throws SQLException {
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			con = DBConnection.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from empresas");
			
			List<EmpresasOfertantesBean> lista = new ArrayList<>();
			while (resultSet.next()) {				
				EmpresasOfertantesBean empresa = new EmpresasOfertantesBean();
				empresa.setIdEmpresa(resultSet.getString("idEmpresa"));
				empresa.setNombreEmpresa(resultSet.getString("nombreEmpresa"));
				empresa.setComision(resultSet.getFloat("comision"));
				empresa.setDirecciion(resultSet.getString("direccion"));
				empresa.setNombrecontacto(resultSet.getString("Nombrecontacto"));
				empresa.setTelefono(resultSet.getString("telefono"));
				empresa.setCorreo(resultSet.getString("correo"));
				empresa.setIdRubro(resultSet.getInt("idRubro"));
				empresa.setPassword(resultSet.getString("password"));
				 String pass = resultSet.getString("password");
				lista.add(empresa);
				 System.out.println(pass);
			}
			this.desconectar();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}
	
	

	}

