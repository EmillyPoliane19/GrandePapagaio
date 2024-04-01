import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nome;
    private List<String> posts;
    private LocalDateTime dataDaPostagem;
    private List<String> usuariosSequindo;

    public Usuario(String nome) {
        this.nome = nome;
        this.posts = new ArrayList<>();
        this.usuariosSequindo = new ArrayList<>();
    }

    public void criarPost(String mensagem) {
        this.dataDaPostagem = LocalDateTime.now().withSecond(0).withNano(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String mensagemFormatada = getNome() + " --> " + mensagem + "(" + dataDaPostagem.format(formatter) + ")";

        posts.add(mensagemFormatada);
    }

    public void seguirUsuarios(Usuario usuario) {
        usuariosSequindo.add(usuario.getNome());
    }
    public String getNome() {
        return nome;
    }

    public List<String> getPosts() {
        return posts;
    }

    public List<String> getUsuariosSequindo() {
        return usuariosSequindo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(posts, usuario.posts) && Objects.equals(dataDaPostagem, usuario.dataDaPostagem) && Objects.equals(usuariosSequindo, usuario.usuariosSequindo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, posts, dataDaPostagem, usuariosSequindo);
    }

    @Override
    public String toString() {
        return nome;
    }
}
