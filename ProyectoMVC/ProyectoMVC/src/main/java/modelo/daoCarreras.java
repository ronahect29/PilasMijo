/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsCarreras;
import controlador.clsFacultades;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCarreras {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM siu.carreras";
    private static final String SQL_INSERT = "INSERT INTO siu.carreras(nombre_carrera, estatus_carrera) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE siu.carreras SET nombre_carrera=?, estatus_carrera=? WHERE codigo_carrera = ?";
    private static final String SQL_DELETE = "DELETE FROM siu.carreras WHERE codigo_carrera=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM siu.carreras WHERE nombre_carrera = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM siu.carreras WHERE codigo_carrera = ?";    

    public List<clsCarreras> consultaCarreras() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCarreras> carreras = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoc = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                int codigof = rs.getInt("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                clsCarreras carrera = new clsCarreras();
                carrera.setCodigoCarrera(codigoc);
                carrera.setNombreCarrera(nombre);
                carrera.setCodigoFacultad(codigof);
                carrera.setEstatusCarrera(estatus);
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return carreras;
    }

    public int ingresaCarreras(clsCarreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carreras.getNombreCarrera());
            stmt.setString(2, carreras.getEstatusCarrera());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaCarreras(clsCarreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, carreras.getNombreCarrera());
            stmt.setString(2, carreras.getEstatusCarrera());
            stmt.setInt(3, carreras.getCodigoCarrera());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarCarreras(clsCarreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, carreras.getCodigoCarrera());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsCarreras consultaCarrerasPorNombre(clsCarreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carreras);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, carreras.getCodigoCarrera());            
            stmt.setString(1, carreras.getNombreCarrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoc = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                int codigof = rs.getInt("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");

                clsFacultades facultades = new clsFacultades();
                carreras.setCodigoCarrera(codigoc);
                carreras.setNombreCarrera(nombre);
                facultades.setCodigoFacultad(codigof);
                carreras.setEstatusCarrera(estatus);
                System.out.println(" registro consultado: " + carreras);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return carreras;
    }
    public clsCarreras consultaCarrerasPorCodigo(clsCarreras carreras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carreras);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, carreras.getCodigoCarrera());            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoc = rs.getInt("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                int codigof = rs.getInt("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                
                clsFacultades facultades = new clsFacultades();
                carreras.setCodigoCarrera(codigoc);
                carreras.setNombreCarrera(nombre);
                facultades.setCodigoFacultad(codigof);
                carreras.setEstatusCarrera(estatus);
                System.out.println(" registro consultado: " + estatus);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return carreras;
    }    
}
