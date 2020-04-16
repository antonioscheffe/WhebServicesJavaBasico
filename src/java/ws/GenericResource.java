/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Dao.UsuarioDao;
import com.google.gson.Gson;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author anton
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetUsuario")
    public String getUsuario() {       
       
        UsuarioDao usuariodao = new UsuarioDao();
        return usuariodao.getListaUsuario();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getusuario(id)/{id}")
    public void getUsuarioid(@PathParam("id") Integer xx){
        UsuarioDao dao =  new UsuarioDao();        
//        return dao.getListaUsuarioId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("SetUsuario")
    public String setUsuario(@PathParam("id") Integer id) {
        //TODO return proper representation object
        
//        ArrayList<Usuario> lista  =  new ArrayList();
        Usuario u1 = new Usuario();
        u1.setNome("Julio");
//        lista.add(u1);
        Usuario usu = new Usuario();
        usu.setId(1);
        usu.setCpf("28839339");
        usu.setNome("Antonio Carlos Scheffmacher");
//        lista.add(usu);
        Gson g = new Gson();
        UsuarioDao usuariodao = new UsuarioDao();

        return g.toJson(usuariodao.getListaUsuario());
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
