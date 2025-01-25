# TODO List - Java Application

## Descrição
Esta é uma aplicação de gerenciamento de tarefas desenvolvida em Java, com um foco no backend. Permite ao usuário adicionar, remover, visualizar e listar tarefas, organizando-as por prioridades, categorias ou status.

A aplicação também permite a criação de tarefas com os seguintes atributos:
- Nome
- Descrição
- Data de término
- Nível de prioridade (1 a 5)
- Categoria
- Status (ToDo, Doing, Done)


## Funcionalidades

1. **Adicionar Tarefa**
   - Solicita informações como nome, descrição, categoria, prioridade e data de término.
   - Valida os dados antes de adicionar a tarefa.

2. **Remover Tarefa**
   - Remove uma tarefa com base no ID informado.

3. **Visualizar Tarefa**
   - Exibe os detalhes de uma tarefa específica pelo ID.

4. **Listar Tarefas**
   - Lista todas as tarefas com opções de ordenação:
     - Por Prioridade
     - Por Categoria
     - Por Status

5. **Sair**
   - Encerra a aplicação.


## Modo de Uso
1. Compile os arquivos Java:
   ```bash
   javac Main.java Task.java TaskManager.java
   ```

2. Execute o programa:
   ```bash
   java Main
   ```

3. Navegue pelas opções do menu exibido no terminal:
   - **0**: Sair
   - **1**: Adicionar nova tarefa
   - **2**: Remover tarefa existente
   - **3**: Atualizar (Funcionalidade futura)
   - **4**: Visualizar uma tarefa específica
   - **5**: Listar tarefas (ordenar por prioridade, categoria ou status)


## Exemplo de Entrada e Saída

### Adicionar Tarefa
```plaintext
Nome da task: Estudar Java
Categoria: Estudos
Descrição: Ler sobre coleções
Prioridade (1 - 5): 3
Data de termino (yyyy/MM/dd HH:mm): 2025/01/30 14:00
Task Estudar Java criada com sucesso!
```

### Listar Tarefas
```plaintext
1 - Prioridade
2 - Categoria
3 - Status
Escolha: 1
| ID | Nome           | Prioridade | Status   | Descrição               | Categoria | Data de término    |
| -- | -------------- | ---------- | -------- | --------------------- | --------- | ---------------- |
| 0  | Estudar Java   | 3          | ToDo     | Ler sobre coleções    | Estudos   | 2025/01/30 14:00 |
```

### Remover Tarefa
```plaintext
Digite o ID da task: 0
Task "Estudar Java" removida com sucesso!
```


## Estrutura do Projeto
- **Main.java**: Contém a lógica principal e o loop do programa.
- **Task.java**: Define a classe Task, seus atributos e métodos.
- **TaskManager.java**: Gerencia as tarefas, incluindo adição, remoção, listagem e visualização.


## Limitações
- Atualização de tarefas ainda não está implementada.
- Os dados não são persistidos após o encerramento do programa.


## Melhorias Futuras
- Implementar a funcionalidade de atualização de tarefas.
- Persistir dados em arquivo (.txt, .json, etc.).
- Implementar filtros adicionais, como por data de término.


