import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskManager {

    public ArrayList<Task> taskList = new ArrayList<Task>();

    public void addTask(Task task) {
        task.setId(this.taskList.size());
        this.taskList.add(task);

        System.out.println("\nTask " + task.getNome() + " criada com sucesso!");
    }

    public int quantidadeTasks() {
        return taskList.size();
    }

    public ArrayList<Task> tasks() {
        return this.taskList;
    }

    public void printTask(Task task) {

        if (task == null) {
            System.out.println("\n | ID | Nome | Prioridade | Status | Descrição | Categoria | Data de término | ");
            System.out.println(" | -- | ------ | ---------- | ------ | --------- | --------- | ---------------- | ");
        } else {
            System.out.print(" | ");
            System.out.print(task.getId());
            System.out.print(" | ");
            System.out.print(task.getNome());
            System.out.print(" | ");
            System.out.print(task.getPrioridade());
            System.out.print(" | ");
            System.out.print(task.getStatus());
            System.out.print(" | ");
            System.out.print(task.getDescricao());
            System.out.print(" | ");
            System.out.print(task.getCategoria());
            System.out.print(" | ");
            System.out.print(task.getDataTermino());
            System.out.println(" | ");
        }
    }

    public void listAllTasks(int listingFor) {

        if (listingFor == 1) { this.taskList.sort(Comparator.comparing(Task::getPrioridade).reversed()); }
        else if (listingFor == 2) { this.taskList.sort(Comparator.comparing(Task::getCategoria)); }
        else if (listingFor == 3) { this.taskList.sort(Comparator.comparing(Task::getStatus)); }

        printTask(null);
        for (Task t : this.taskList) {
            printTask(t);
        }
    }

    public void removeTask(int id) {
        for (int i = 0; i < quantidadeTasks(); i++) {
            if (this.taskList.get(i).getId() == id) {
                System.out.println("Task \"" + this.taskList.get(i).getNome() + "\" removida com sucesso!");
                this.taskList.remove(i);
                break;
            }
        }
    }

    public void visualizeTask(int id) {
        for (int i = 0; i < quantidadeTasks(); i++) {

            Task t = taskList.get(i);

            if (t.getId() == id) {
                System.out.println("\nTask: " + t.getNome() + " -> ID " + t.getId() + " {");
                System.out.println("\tDescrição: " + t.getDescricao());
                System.out.println("\tStatus: " + t.getStatusString());
                System.out.println("\tPrioridade: " + t.getPrioridade());
                System.out.println("\tCategoria: " + t.getCategoria());
                System.out.println("\tData de termino: " + t.getDataTermino());
                System.out.println("}");

                break;
            }
        }
    }

    public int menu() {

        System.out.println("\n0 - Sair");
        System.out.println("1 - Adicionar");
        if (quantidadeTasks() > 0) {
            System.out.println("2 - Remover");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Listar\n");
        }

        Scanner option = new Scanner(System.in);
        return option.nextInt();
    }
}
