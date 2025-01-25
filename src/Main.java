import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        Scanner scanner = new Scanner(System.in);

        testTasks(taskManager);

        while (true) {

            int option = taskManager.menu();

            if (option == 0) {
                System.out.println("Encerrando programa ...");
                System.exit(0);
            } else if (option == 1) {

                System.out.print("Nome da task: ");
                String nome = scanner.nextLine();
                if (nome.isBlank()) {
                    System.out.println("Nome inválido");
                    System.exit(0);
                }

                System.out.print("Categoria: ");
                String categoria = scanner.nextLine();

                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();

                System.out.print("Prioridade (1 - 5): ");
                int prioridade = scanner.nextInt();
                if (prioridade < 1 || prioridade > 5) {
                    System.out.println("Prioridade deve estar entre 1 e 5");
                    System.exit(0);
                }

                System.out.print("Data de termino (yyyy/MM/dd HH:mm): ");
                scanner.nextLine();

                String data = scanner.nextLine();
                LocalDateTime dataTermino = null;

                try {
                    dataTermino = LocalDateTime.parse(data, formatter);

                    if (dataTermino.isBefore(LocalDateTime.now())) {
                        System.out.println("A data de expiração da tarefa é inválida");
                        System.exit(0);
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido");
                    System.exit(0);
                }

                Task task = new Task(nome, descricao, categoria, dataTermino, prioridade);
                taskManager.addTask(task);
            }

            if (taskManager.quantidadeTasks() > 0) {
                if (option == 2) {
                    System.out.print("Digite o ID da task: ");
                    int id = scanner.nextInt();
                    taskManager.removeTask(id);
                } else if (option == 3) {
                    System.out.println("\nEssa funcionalidade será adicionada em breve ...");

                } else if (option == 4) {
                    System.out.print("Digite o ID da task: ");
                    int id = scanner.nextInt();
                    taskManager.visualizeTask(id);

                } else if (option == 5) {
                    System.out.println("\n1 - Prioridade");
                    System.out.println("2 - Categoria");
                    System.out.println("3 - Status");
                    int listingFor = scanner.nextInt();

                    taskManager.listAllTasks(listingFor);
                }
            }

            if (option > 5 || option < 0) {
                System.out.println("Opção inválida");
            }

            System.out.println("\nPressione Enter para continuar...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }

            clearConsole();
        }
    }

    static public void testTasks(TaskManager taskManager) {

        // Função usada para criar tasks de teste

        taskManager.addTask(new Task(
                "Comprar suprimentos",
                "Comprar materiais para o projeto de software",
                "Projeto",
                LocalDateTime.of(2025, 2, 10, 14, 0),
                1
            )
        );

        taskManager.addTask(new Task(
                "Revisar relatório",
                "Ler e corrigir o relatório final",
                "Trabalho",
                LocalDateTime.of(2025, 1, 30, 10, 30),
                2
            )
        );

        taskManager.addTask(new Task(
                "Planejar reunião",
                "Definir agenda para a reunião com a equipe",
                "Organização",
                LocalDateTime.of(2025, 2, 5, 16, 0),
                3
            )
        );

        taskManager.addTask(new Task(
                "Atualizar documentação",
                "Atualizar o manual do usuário com novas funções",
                "Documentação",
                LocalDateTime.of(2025, 2, 15, 12, 0),
                2
            )
        );

        taskManager.addTask(new Task(
                "Testar funcionalidades",
                "Executar testes nas novas funcionalidades implementadas",
                "Qualidade",
                LocalDateTime.of(2025, 1, 28, 15, 0),
                1
            )
        );
    }

    static public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


