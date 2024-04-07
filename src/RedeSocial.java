import java.util.Scanner;

public class RedeSocial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CRIAR_CONTA = 1;
        final int LOGAR_NA_CONTA = 2;
        final int CRIAR_POST = 1;
        final int SEGUIR_USUARIO = 2;
        final int EXIBIR_MURAL = 3;

        int opcao = 1;
        String nomeUsuario = "";

        Mural mural = new Mural();
        System.out.println("BEM VINDO AO GRANDE PAPAGAIO");
        do {
            menuInicial();

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == CRIAR_CONTA) {
                System.out.println("Digite seu nome:");
                String nome = sc.nextLine();

                Usuario novoUsuario = new Usuario(nome);
                String criarConta = mural.criarUsuarios(novoUsuario);

                System.out.println(criarConta);

            } else if (opcao == LOGAR_NA_CONTA) {
                System.out.println("Digite seu nome:");
                nomeUsuario = sc.nextLine();
                try {
                    Usuario usuarioAtual = mural.logarUsuario(nomeUsuario);
                    if (usuarioAtual.getNome().equalsIgnoreCase(nomeUsuario)) {
                        System.out.println("Usuário Encontrado!");

                        do {
                            menuOpcoes();
                            opcao = sc.nextInt();
                            sc.nextLine();

                            switch (opcao) {
                                case CRIAR_POST:
                                    System.out.println("Digite seu post:");
                                    String post = sc.nextLine();

                                    String adicionaPost = mural.postarNoMural(usuarioAtual, post);
                                    System.out.println(adicionaPost);

                                    break;

                                case SEGUIR_USUARIO:
                                    System.out.println("Digite o nome do usuário:");
                                    String seguirUsuario = sc.nextLine();

                                    String seguir = mural.seguirUsuarios(usuarioAtual, seguirUsuario);
                                    System.out.println(seguir);
                                    break;

                                case EXIBIR_MURAL:
                                    StringBuilder exibir = mural.lerMural(usuarioAtual);
                                    System.out.println(exibir);
                                    break;

                                case 4:
                                    System.out.println("Você saiu da sua conta.");
                                    usuarioAtual = null;
                                    break;
                            }

                        } while (opcao != 4);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (opcao != 3);
    }
    public static void menuInicial() {
        System.out.println("Digite uma das opções para continuar:");
        System.out.println("1 - Criar uma conta. \n2 - Logar em uma conta.");
        System.out.println("3 - Para sair");
    }
    public static void menuOpcoes() {
        System.out.println("Digite uma das opções para continuar:");
        System.out.println("1 - Criar Post\n2 - Seguir Pessoas ");
        System.out.println("3 - Exibir Mural \n4 - Para sair");
    }
}
