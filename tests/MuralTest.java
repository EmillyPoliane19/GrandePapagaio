import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MuralTest {
    private Mural mural;
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    public void criarMurarlUsuarios() {
        mural = new Mural();
        usuario1 = new Usuario("João");
        usuario2 = new Usuario("Maria");
    }

    /* Verifica se o método criarUsuarios adiciona corretamente um usuário à lista de usuários ativos no mural.*/
    @Test
    public void testCriarUsuario() {
        String criarUsuario = mural.criarUsuarios(usuario1);
        assertEquals(criarUsuario,"Usuário João criado com sucesso");
        assertTrue(mural.getUsuariosAtivos().contains(usuario1));
    }

    /* Testa se o método logarUsuario retorna o usuário correto com base no nome de login fornecido.*/
    @Test
    public void testLogarUsuario() throws Exception {
        mural.criarUsuarios(usuario2);

        Usuario usuarioEncontrado = mural.logarUsuario("Maria");
        assertEquals(usuarioEncontrado,usuario2);
        assertNotNull(usuarioEncontrado);

        Usuario usuarioNaoEncontrado = mural.logarUsuario("Felipe");
        assertNull(usuarioNaoEncontrado);
        assertNotEquals(usuarioNaoEncontrado,usuario1);
    }

    /*Verifica se o método postarNoMural permite que um usuário poste uma mensagem no mural e se a mensagem é formatada corretamente.*/
    @Test
    public void testPostarNoMural() {
        mural.criarUsuarios(usuario1);
        Usuario usuarioInvalido = new Usuario("Felipe");

        String resultadoCerto = mural.postarNoMural(usuario1, "Mensagem no mural");
        assertEquals(resultadoCerto, "Post realizado com sucesso no mural de João");

        String resultadoInvalido = mural.postarNoMural(usuarioInvalido, "Teste");
        assertEquals("Usuário inválido", resultadoInvalido);
    }

    /*Testa se o método seguirUsuarios permite que um usuário siga outro usuário e se a ação é registrada corretamente.*/
    @Test
    public void testSguirUsuario() {
        mural.criarUsuarios(usuario1);
        mural.criarUsuarios(usuario2);

        String encontrado = mural.seguirUsuarios(usuario1, "Maria");
        assertEquals(encontrado, "João agora você segue Maria");

        String naoEncontrado = mural.seguirUsuarios(usuario1, "Felipe");
        assertEquals(naoEncontrado, "Usuário não encontrado!");

    }

    /*Verifica se o método lerMural retorna o mural completo de um usuário, incluindo os próprios posts e posts dos usuários que está seguindo.*/
    @Test
    public void testLerMural() {
        mural.criarUsuarios(usuario1);
        mural.criarUsuarios(usuario2);

        usuario1.criarPost("Post de João");

        mural.seguirUsuarios(usuario1, "Maria");
        usuario2.criarPost("Post de Maria");

        StringBuilder muralCompletoUsuario1 = mural.lerMural(usuario1);
        assertNotNull(muralCompletoUsuario1);
        assertTrue(muralCompletoUsuario1.toString().contains("Post de João"));
        assertTrue(muralCompletoUsuario1.toString().contains("Post de Maria"));

        StringBuilder muralCompletoUsuario2 = mural.lerMural(usuario2);
        assertNotNull(muralCompletoUsuario2);
        assertFalse(muralCompletoUsuario2.toString().contains("Post de João"));
        assertTrue(muralCompletoUsuario2.toString().contains("Post de Maria"));
    }
}