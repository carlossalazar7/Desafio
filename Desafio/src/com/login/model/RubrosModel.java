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

public class RubrosModel extends DBConnection {
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public List<RubroBean> listar() throws SQLException {

		try {
			con = DBConnection.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from rubro");

			List<RubroBean> lista = new ArrayList<>();
			while (resultSet.next()) {
				RubroBean rubro = new RubroBean();
				rubro.setIdRubro(resultSet.getInt("idRubro"));
				rubro.setNombreRubro(resultSet.getString("nombreRubro"));
				String nombre = resultSet.getString("nombreRubro");
				lista.add(rubro);
				System.out.println(nombre);
			}
			this.desconectar();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(RubrosModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}

	public int insertarRubro(RubroBean rubro) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL insertarRubro(?,?)";
			cs = con.prepareCall(sql);
			cs.setInt(1, rubro.getIdRubro());
			cs.setString(2, rubro.getNombreRubro());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(RubrosModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}

	public int eliminarRubro(String codigo) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarRubro(?)";
			cs = con.prepareCall(sql);
			cs.setString(1, codigo);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(RubrosModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}

	}

	public int modificarRubro(RubroBean rubro) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarRubro(?,?)";
			cs = con.prepareCall(sql);
			cs.setString(1, rubro.getNombreRubro());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(RubrosModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}

	public RubroBean obtenerRubro(String codigo) throws SQLException {
		try {
			String sql = "CALL sp_obtenerAutor(?)";
			cs = con.prepareCall(sql);
			cs.setString(1, codigo);
			rs = cs.executeQuery();
			if (rs.next()) {
				RubroBean rubro = new RubroBean();
				rubro.setIdRubro(rs.getInt("idRubro"));
				rubro.setNombreRubro(rs.getString("nombreRubro"));
				this.desconectar();
				return rubro;
			}
			this.desconectar();
			return null;
		} catch (SQLException ex) {
			Logger.getLogger(RubrosModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}

	public int totalRubros() throws SQLException {
		try {
			int total = 0;
			String sql = "SELECT COUNT(idRubro) as totalrubro FROM rubro";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				total = rs.getInt("totalrubro");
			}
			return total;
		} catch (SQLException ex) {
			Logger.getLogger(RubrosModel.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		} finally {
			this.desconectar();
		}
	}

}