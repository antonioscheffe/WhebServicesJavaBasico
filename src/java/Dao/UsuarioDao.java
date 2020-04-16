/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.google.gson.Gson;
import conexao.Connexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author anton
 */
public class UsuarioDao {

    public String getListaUsuario() {
        String sql = "Select * from usuario";
        List<Usuario> lista = new ArrayList<>();

        try {
            PreparedStatement ps = Connexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setNome(rs.getString("nome"));
                usu.setCpf(rs.getString("cpf"));
                lista.add(usu);
            }
        } catch (SQLException ex) {
            System.out.println("passando");
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Transformando em Json
        Gson g = new Gson();
        return g.toJson(lista);
    }

    public String getListaUsuarioId(Integer id) {
        String sql = "Select * from usuario where id  = " + String.valueOf(id);
        List<Usuario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = Connexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
//          
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setNome(rs.getString("nome"));
                usu.setCpf(rs.getString("cpf"));
                lista.add(usu);
            }
        } catch (SQLException ex) {
            System.out.println("passando");
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Transformando em Json
        Gson g = new Gson();
        return g.toJson(lista);
    }

}
