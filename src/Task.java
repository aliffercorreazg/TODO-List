import java.time.LocalDateTime;

public class Task {

    private String nome, descricao, categoria;
    private LocalDateTime dataTermino;
    private Status status = Status.ToDo;
    private int prioridade;
    private int id;

    public enum Status {
        ToDo,
        Doing,
        Done;
    }

    public Task(
            String nome,
            String descricao,
            String categoria,
            LocalDateTime dataTermino,
            int prioridade
    ) {

        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return this.status;
    }
    public String getStatusString() {

        String status = "";

        if (this.status == Task.Status.ToDo) {
            status = " A fazer ";
        } else if (this.status == Task.Status.Doing) {
            status = " Fazendo ";
        } else if (this.status == Task.Status.Done) {
            status =  " Concluído ";
        }

        return status;

    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getDataTermino() {
        return this.dataTermino;
    }
    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getPrioridade() {
        return this.prioridade;
    }
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }
}
