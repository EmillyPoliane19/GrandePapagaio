import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    public void criarUsuario() {
        usuario1 = new Usuario("João");
        usuario2 = new Usuario("Maria");
    }

    /* Verifica se o método está passando o nome certo*/
    @Test
    public void testGetNome() {
        String nome = "João";

        assertEquals(nome, usuario1.getNome());
        assertNotEquals(nome, usuario2.getNome());
    }

    /*  Verifica se o método criarPost adiciona uma mensagem a lista de posts do usuário.*/
    @Test
    public void testCriarPost() {
        String post = "Oi entrei na rede social";

        usuario1.criarPost(post);
        List<String> posts = usuario1.getPosts();

        assertFalse(posts.isEmpty());
        assertEquals(1, posts.size());
    }

    /* Testa se o método seguirUsuarios adiciona corretamente o nome do usuário seguido à lista de usuários seguidos pelo usuário principal.*/
    @Test
    public void testSeguirUsuario() {
        usuario1.seguirUsuarios(usuario2);

        List<String> usuarioSeguindo = usuario1.getUsuariosSequindo();

        assertEquals(1, usuarioSeguindo.size());
        assertTrue(usuarioSeguindo.contains("Maria"));
    }

}