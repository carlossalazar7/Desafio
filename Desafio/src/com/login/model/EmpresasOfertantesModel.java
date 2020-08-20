
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

	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public List<EmpresasOfertantesBean> listarEmpresa() throws SQLException {
		try {
			con = DBConnection.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from empresas");

			List<EmpresasOfertantesBean> lista = new ArrayList<EmpresasOfertantesBean>();
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
				String pass = resultSet.getString("correo");
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

	public int insertarEmpresa(EmpresasOfertantesBean empresa) throws SQLException {
		try {

			int filasAfectadas = 0;
			String sql = "CALL insertarEmpresa(?,?,?,?,?,?,?,?,?)";
			cs = con.prepareCall(sql);
			cs.setString(1, empresa.getNombreEmpresa());
			cs.setFloat(2, empresa.getComision());
			cs.setString(3, empresa.getDirecciion());
			cs.setString(4, empresa.getNombrecontacto());
			cs.setString(5, empresa.getTelefono());
			cs.setString(6, empresa.getCorreo());
			cs.setInt(7, empresa.getIdRubro());
			cs.setString(8, empresa.getPassword());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}

	public int eliminarEmpresa(String codigo) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarAutor(?)";
			cs = con.prepareCall(sql);
			cs.setString(1, codigo);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}

	}

	public int modificarEmpresa(EmpresasOfertantesBean empresa) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarAutor(?,?,?)";
			cs = con.prepareCall(sql);

			cs.setString(1, empresa.getNombreEmpresa());
			cs.setFloat(2, empresa.getComision());
			cs.setString(3, empresa.getDirecciion());
			cs.setString(4, empresa.getNombrecontacto());
			cs.setString(5, empresa.getTelefono());
			cs.setString(6, empresa.getCorreo());
			cs.setInt(7, empresa.getIdRubro());
			cs.setString(8, empresa.getPassword());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}

	public EmpresasOfertantesBean obtenerEmpresa(String codigo) throws SQLException {
		try {
			String sql = "CALL sp_obtenerAutor(?)";
			cs = con.prepareCall(sql);
			cs.setString(1, codigo);
			rs = cs.executeQuery();
			if (rs.next()) {
				EmpresasOfertantesBean empresa = new EmpresasOfertantesBean();
				empresa.setIdEmpresa(rs.getString("idEmpresa"));
				empresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
				empresa.setComision(rs.getFloat("comision"));
				empresa.setDirecciion(rs.getString("direccion"));
				empresa.setNombrecontacto(rs.getString("Nombrecontacto"));
				empresa.setTelefono(rs.getString("telefono"));
				empresa.setIdRubro(rs.getInt("idRubro"));
				empresa.setPassword(rs.getString("password"));
				this.desconectar();
				return empresa;
			}
			this.desconectar();
			return null;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}

	public int totalempresas() throws SQLException {
		try {
			int totalaut = 0;
			String sql = "SELECT COUNT(idEmpresa) as totalaut FROM empresas";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				totalaut = rs.getInt("totalaut");
			}
			return totalaut;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		} finally {
			this.desconectar();
		}
	}

}
