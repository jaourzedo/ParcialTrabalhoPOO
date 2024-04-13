import java.time.LocalDate;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.sql.ResultSet;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner((System.in));

        System.out.println("\n\n\n***** Seja muito bem-vindo ao sistema da Biblioteca da Universidade de Ribeirão Preto (UNAERP) ***** \n");
        System.out.println("***** Selecione o tipo de Usuário *****\n");
        System.out.println("***** 1. Administrador *****\n");
        System.out.println("***** 2. Usuário *****\n");
        

        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        Administrador novoAdmin = new Administrador("Felipe Grechi do Prado", "felipe.prado@sou.unaerp.edu.br", 16981892476L);

        switch (tipoUsuario) {
            case 1:
                loginAdministrador(scanner);
                break;

            case 2:
                exibirMenuUsuario(scanner);
                break;

            default:
                System.out.println("Opção Inválida");
        }
    }

    public static void loginAdministrador(Scanner scanner) {

        System.out.println("***** Login do Administrador *****");
        System.out.println("\nUsername: ");
        String username = scanner.nextLine(); // Igual ao scanf do C
        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        if (username.equals("admin") && senha.equals("1234")) {
            System.out.println("Login bem-sucedido! Bem-vindo, administrador.");
            exibirMenuAdmin(scanner);
        } else {
            System.out.println("Login falhou. Verifique seu nome de usuário e senha e tente novamente.");
        }

    }

    public static void exibirMenuAdmin(Scanner scanner) {
        Administrador administrador = new Administrador("Felipe Grechi do Prado", "felipe.prado@sou.unaerp.edu.br", 16981892476L);

        System.out.println("Selecione uma opção abaixo\n");
        System.out.println("1. Adicionar novo livro\n");
        System.out.println("2. Editar livro existente\n");
        System.out.println("3. Excluir livro\n");
        System.out.println("4. Adicionar novo usuário\n");
        System.out.println("5. Editar usuário existente\n");
        System.out.println("6. Excluir usuário\n");
        System.out.println("7. Atribuir Privilégios\n");
        System.out.println("8. Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // < ------ Serve pra limpar o buffer

        switch (opcao) {
            case 1:
                Livro novoLivro = new Livro();
                administrador.AddLivro(novoLivro);
                break;
            case 2:    System.out.println("***** Editar Livros *****");
                System.out.println("***** Digite o ID do livro que deseja editar: *****");
                int idLivroEditar = scanner.nextInt();
                scanner.nextLine();

                List<Livro> listalivros = administrador.pesquisarLivro();

                Livro livroExistente = administrador.pesquisarLivro().get(0);

                if (livroExistente != null) {
                    boolean continuarEdicao = true;
                    while (continuarEdicao) {
                        // Exibe as opções de edição
                        System.out.println("Escolha o que deseja editar:");
                        System.out.println("1. Título");
                        System.out.println("2. Autor");
                        System.out.println("3. Categoria");
                        System.out.println("4. ISBN");
                        System.out.println("5. Disponível");
                        System.out.println("6. Prazo de Empréstimo");
                        System.out.println("7. Voltar ao Menu Principal");

                        int opcaoEdicao = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoEdicao) {
                            case 1:
                                System.out.println("Digite o novo título:");
                                livroExistente.setTitulo(scanner.nextLine());
                                break;
                            case 2:
                                System.out.println("Digite o novo autor:");
                                livroExistente.setAutor(scanner.nextLine());
                                break;
                            case 3:
                                System.out.println("Digite a nova categoria:");
                                livroExistente.setCategoria(scanner.nextLine());
                                break;
                            case 4:
                                System.out.println("Digite o novo ISBN:");
                                livroExistente.setISBN(scanner.nextLine());
                                break;
                            case 5:
                                System.out.println("O livro está disponível? (true/false):");
                                livroExistente.setDisponivel(scanner.nextBoolean());
                                scanner.nextLine();
                                break;
                            case 6:
                                System.out.println("Digite o novo prazo de empréstimo (DD-MM-AAAA):");
                                livroExistente.setPrazo_emprestimo(LocalDate.parse(scanner.nextLine()));
                                break;
                            case 7:
                                continuarEdicao = false;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    administrador.EditLivro(idLivroEditar, livroExistente);
                } else {
                    System.out.println("Livro não encontrado!");
                }
                break;
            case 3:
                System.out.println("***** Excluir Livro *****");
                System.out.println("***** Digite o ID do livro que deseja excluir: *****");
                int idLivroExcluir = scanner.nextInt();
                scanner.nextLine();
                administrador.DeleteLivro(idLivroExcluir);
                break;
            case 4:
                System.out.println("***** Adicionar Novo Usuário *****");
                System.out.println("Digite o nome do usuário: ");
                String nomeNovoUsuario = scanner.nextLine();
                System.out.println("Digite o sobrenome do usuário: ");
                String sobrenomeNovoUsuario = scanner.nextLine();
                System.out.println("Digite o endereço do usuário: ");
                String enderecoNovoUsuario = scanner.nextLine();
                System.out.println("Digite o nome de usuário: ");
                String usernameNovoUsuario = scanner.nextLine();
                System.out.println("Digite a senha do usuário: ");
                String senhaNovoUsuario = scanner.nextLine();
                System.out.println("O usuário será um administrador? (true/false):");

                boolean isAdminNovoUsuario = scanner.nextBoolean();

                Usuarios novoUsuario = new Usuarios(nomeNovoUsuario, sobrenomeNovoUsuario, enderecoNovoUsuario, usernameNovoUsuario, senhaNovoUsuario, isAdminNovoUsuario);
                administrador.AddUser(novoUsuario);
                break;
            case 5:
                System.out.println("***** Editar Usuário *****");
                System.out.println("Digite o ID do usuário que deseja editar: ");
                int idUsuarioEditar = scanner.nextInt();
                scanner.nextLine();

                Usuarios usuarioEditar = Usuarios.recuperarUsuarioPorID(idUsuarioEditar);

                if (usuarioEditar != null) {
                    System.out.println("Digite o novo nome do usuário:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo sobrenome do usuário:");
                    String novoSobrenome = scanner.nextLine();
                    System.out.println("Digite o novo endereço do usuário:");
                    String novoEndereco = scanner.nextLine();
                    System.out.println("Digite o novo username do usuário:");
                    String novoUsername = scanner.nextLine();
                    System.out.println("Digite a nova senha do usuário:");
                    String novaSenha = scanner.nextLine();
                    System.out.println("O usuário é administrador? (true/false):");

                    boolean isAdmin = scanner.nextBoolean();
                    scanner.nextLine();

                    usuarioEditar.setNome(novoNome);
                    usuarioEditar.setSobrenome(novoSobrenome);
                    usuarioEditar.setEndereco(novoEndereco);
                    usuarioEditar.setUsername(novoUsername);
                    usuarioEditar.setSenha(novaSenha);
                    usuarioEditar.setAdmin(isAdmin);

                    administrador.EditUser(idUsuarioEditar, usuarioEditar);
                } else {
                    System.out.println("***** Usuário não encontrado. *****");
                }
                break;
            case 6:
                System.out.println("***** Digite o ID do usuário que deseja excluir: *****");
                int idUsuarioExcluir = scanner.nextInt();
                scanner.nextLine();
                administrador.DeleteUser(idUsuarioExcluir);
                break;
            case 7:

                System.out.println("***** Digite o ID do usuário: *****");
                int idUsuarioPrivilegio = scanner.nextInt();
                scanner.nextLine();

                Usuarios usuarioPrivilegio = Usuarios.recuperarUsuarioPorID(idUsuarioPrivilegio);

                if (usuarioPrivilegio != null) {
                    System.out.println("***** Digite 'true' se deseja atribuir privilégios de administrador, 'false' caso contrário: *****");
                    boolean isAdmin = scanner.nextBoolean();
                    scanner.nextLine();

                    administrador.AtribuirPrivilegios(usuarioPrivilegio, isAdmin);
                } else {
                    System.out.println("Usuário não encontrado!");
                }
                break;
            case 8:
                System.out.println("***** Saindo... *****\n");
                break;
            default:
                System.out.println("***** Opção Inválida! *****");
        }
    }
    public static void exibirMenuUsuario(Scanner scanner) {

        List<Usuarios> usuarios = (Usuarios.recuperarUsuariosDoBancoDeDados());

        System.out.println("***** Menu do Usuário *****\n");
        System.out.println("***** Selecione uma opção *****\n");
        System.out.println("***** 1. Pesquisar Livro *****\n");
        System.out.println("***** 2. Pegar Livro Emprestado *****\n");
        System.out.println("***** 3. Devolver Livro *****\n");
        System.out.println("***** 4. Sair *****");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                List<Livro> livrosEncontrados = usuarios.get(0).pesquisarLivro();
                if (livrosEncontrados.isEmpty()) {
                    System.out.println("Nenhum livro foi encontrado!\n");
                } else {
                    System.out.println("Livros Encontrados: \n");
                    for (Livro livro : livrosEncontrados) {
                        System.out.println(livro.obterDetalhes());
                    }
                }
                break;

            case 2:
                System.out.println("***** Opção de Pegar Livro Emprestado *****\n");
                System.out.println("Digite o ID do livro que deseja pegar emprestado: ");
                int idLivroEmprestimo = scanner.nextInt();
                scanner.nextLine();

                // Assumindo que o usuário atual é o primeiro da lista
                List<Livro> livrosEncontradosEmprestimo = usuarios.get(0).pesquisarLivro();
                Livro livroEmprestimo = null;
                for (Livro livro : livrosEncontradosEmprestimo) {
                    if (livro.getIdLivro() == idLivroEmprestimo) {
                        livroEmprestimo = livro;
                        break;
                    }
                }
                if (livroEmprestimo != null) {
                    usuarios.get(0).pegarEmprestado(livroEmprestimo);
                } else {
                    System.out.println("Livro não encontrado! ");
                }
                break;


            case 3:
                System.out.println("***** Opção de Devolver Livro *****\n");
                System.out.println("Digite o ID do livro que deseja devolver:");
                int idLivroDevolucao = scanner.nextInt();
                scanner.nextLine();

                // Assumindo que o usuário atual é o primeiro da lista
                List<Livro> livrosEncontradosDevolucao = usuarios.get(0).pesquisarLivro();
                Livro livroDevolucao = null;
                for (Livro livro : livrosEncontradosDevolucao) {
                    if (livro.getIdLivro() == idLivroDevolucao) {
                        livroDevolucao = livro;
                        break;
                    }
                }
                if (livroDevolucao != null) {
                    usuarios.get(0).devolverLivro(livroDevolucao);
                } else {
                    System.out.println("Livro não encontrado!");
                }
                break;

            case 4:
                System.out.println("***** Saindo... *****\n");
                break;

            default:
                System.out.println("***** Opção Inválida! *****");
        }
    }
}






