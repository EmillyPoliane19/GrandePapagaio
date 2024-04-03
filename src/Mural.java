import java.util.ArrayList;
import java.util.List;

public class Mural {
    private StringBuilder muralCompleto;
    private List<Usuario> usuariosAtivos;


    public Mural() {
        this.usuariosAtivos = new ArrayList<>();
    }

    public String criarUsuarios(Usuario usuario) {
        usuariosAtivos.add(usuario);

        return "Usuário " + usuario.getNome() + " criado com sucesso";
    }

    public Usuario logarUsuario(String nomeLogin) throws Exception{
        if (!usuariosAtivos.contains(nomeLogin)) {
            throw new Exception("Usuário não existe!");
        }

        for (Usuario usuario : usuariosAtivos) {
            if (usuario.getNome().equalsIgnoreCase(nomeLogin)) {
                return usuario;
            }
        }

        return null;
    }

    public String postarNoMural (Usuario usuario, String post) {
        usuario.criarPost(post);
        if (!usuario.getPosts().isEmpty()) {
            return "Post realizado com sucesso no mural de " + usuario.getNome();
        } else {
            return "Usuário inválido";
        }
    }

    public String seguirUsuarios(Usuario usuarioAtual, String usuarioSeguir) {
        for (Usuario usuario : usuariosAtivos) {
            if (usuario.getNome().equalsIgnoreCase(usuarioSeguir)) {
                usuarioAtual.seguirUsuarios(usuario);

                return usuarioAtual.getNome() + " agora você segue " + usuario.getNome();
            }
        }
        return "Usuário não encontrado!";
    }

    public StringBuilder lerMural(Usuario usuario) {
        muralCompleto = new StringBuilder();

        muralCompleto.append("Mural de ").append(usuario.getNome()).append("\n");

        for (String post : usuario.getPosts()) {
            muralCompleto.append(post).append("\n");
        }

        for (String nomeSeguido : usuario.getUsuariosSequindo()) {
            for (Usuario usuarioSeguido : usuariosAtivos) {
                if (usuarioSeguido.getNome().equalsIgnoreCase(nomeSeguido)) {
                    for (String post : usuarioSeguido.getPosts()) {
                        muralCompleto.append(post).append("\n");
                    }
                    break;
                }
            }
        }
        return muralCompleto;
    }
}
