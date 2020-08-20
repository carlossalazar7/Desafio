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
import com.login.util.*;



public class OfertasModel extends DBConnection {
	
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	
	public List<OfertasBean> listar() throws SQLException{
		
		try {
			
			con = DBConnection.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from empresas");
		
		

			List<OfertasBean> lista = new ArrayList<>();
			while (rs.next()) {
				OfertasBean oferta = new OfertasBean();
				oferta.setidPromocion(rs.getInt("idPromocion"));
				oferta.setNombreOferta(rs.getString("titulo"));
				oferta.setPrecioNormal(rs.getFloat("PrecioRegular"));
				oferta.setPrecioOferta(rs.getFloat("PrecioOferta"));
				oferta.setFechaInicio(rs.getString("FechaInicio"));
				oferta.setFechaFinal(rs.getString("FechaFinal"));
				oferta.setCantidadCupones(rs.getInt("CantidadCupones"));
				oferta.setDescripcion(rs.getString("Descripcion"));
				oferta.setEstado(rs.getString("estado"));
				oferta.setFechaLimite(rs.getString("fechaLimite"));
				oferta.setJustificacion(rs.getString("justificacion"));
				oferta.setIdEmpresa(rs.getString("idEmpresa"));
				
			
				lista.add(oferta);
			
			}
			this.desconectar();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(OfertasModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}
		
		public int insertar(OfertasBean oferta) throws SQLException {
			try {

				int filasAfectadas = 0;
				String sql = "CALL insertarOferta(?,?,?,?,?,?,?,?,?,?,?)";
				cs = conexion.prepareCall(sql);
				cs.setString(1, oferta.getNombreOferta());
				cs.setFloat(2, oferta.getPrecioNormal());
				cs.setFloat(3, oferta.getPrecioOferta());
				cs.setString(4, oferta.getFechaInicio());
				cs.setString(5, oferta.getFechaFinal());
				cs.setInt(6, oferta.getCantidadCupones());
				cs.setString(7, oferta.getDescripcion());
				cs.setString(8, oferta.getEstado());
				cs.setString(9, oferta.getFechaLimite());
				cs.setString(10, oferta.getJustificacion());
				cs.setString(11, oferta.getIdEmpresa());
				filasAfectadas = cs.executeUpdate();
				this.desconectar();
				return filasAfectadas;
			} catch (SQLException ex) {
				Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
				this.desconectar();
				return 0;
			}
		}
		
		
		
	}
			
		
		
	


