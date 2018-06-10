/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Francisco Chaves
 * 
 */
package controller;

import dao.UsuarioDAO;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioController {

    UsuarioDAO dao = new UsuarioDAO();

    //Buscar os usuário e verificar se o login existe
    public boolean verificarLogin(String login, String senha) {

        ArrayList<Usuario> u = dao.recuperarUsuario();

        for (Usuario usuario : u) {

            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;

    }

    public boolean cadastrar(Usuario usuario) {

        ArrayList<Usuario> u = dao.recuperarUsuario();

        for (Usuario usuer : u) {
            if (usuer.getLogin().equals(usuario.getLogin())) {
                return false;
            }
        }

        u.add(usuario);

        dao.salvarUsuarios(u);

        return true;
    }

    public Usuario pesquisar(String login) {
        ArrayList<Usuario> u = dao.recuperarUsuario();

        for (Usuario usuario : u) {

            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }

        return null;
    }

    public boolean atualizar(Usuario user, String loginOriginal) {

        ArrayList<Usuario> u = dao.recuperarUsuario();
        for (Usuario usuario : u) {

            if (usuario.getLogin().equals(loginOriginal)) {
                u.remove(usuario);
                u.add(user);
                dao.salvarUsuarios(u);
                return true;
            }
        }

        return false;
    }

    public boolean deleta(String login) {
        ArrayList<Usuario> u = dao.recuperarUsuario();

        for (Usuario usuario : u) {

            if (usuario.getLogin().equals(login)) {
                u.remove(usuario);
                dao.salvarUsuarios(u);
                return true;
            }
        }

        return false;
    }

}
