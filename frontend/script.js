class Status {
    static todo = "A fazer";
    static doing = "Fazendo";
    static done = "Pronto";
}

class Task {

    constructor(id, nome, status, datalimite) {
        this._id = id;
        this._nome = nome;
        this._status = status;
        this._datalimite = datalimite
    }

    get id() {
        return this._id
    }

    set id(newId) {
        this._id = newId
    }

    get name() {
        return this._nome
    }

    set name(newNome) {
        this._nome = newNome
    }

    get status() {
        return this._status
    }

    set status(newStatus) {
        this._status = newStatus
    }

    get datalimite() {
        return this._datalimite
    }

    set datalimite(newDatalimite) {
        this._datalimite = newDatalimite
    }
}

let tasks = []

function loadTasks() {

    document.getElementById("todo").innerHTML = ''
    document.getElementById("doing").innerHTML = ''
    document.getElementById("done").innerHTML = ''

    tasks.forEach(t => {

        let tag = `<div id="${t.id}">
                        <ul>
                            <li class="task-info">${t.name}</li>
                            <li class="task-info">${t.datalimite}</li>
                        </ul>
                        <div id="actions">
                            <button onclick=editar(${t.id}) class="rud" id="edit-button">Editar</button>
                            <button onclick=visualizar(${t.id}) class="rud" id="visualize-button">Visualizar</button>    
                            <button onclick=remover(${t.id}) class="rud" id="remove-button">Remover</button>
                        </div>
                    </div>
                    <hr>`


        if (t.status == Status.todo) {
            document.querySelector("#todo").innerHTML += tag
        } else if (t.status == Status.doing) {
            document.querySelector("#doing").innerHTML += tag
        } else if (t.status == Status.done) {
            document.querySelector("#done").innerHTML += tag
        }
        
        
    });
}

function adicionar() {

    const nome = document.querySelector("#nometask");
    const datalimite = document.querySelector("#datalimite")
    const statustag = document.querySelector("#status")

    if (nome.value.trim().length > 0 && datalimite.value) {

        let task = new Task(tasks.length, nome.value, statustag.value, datalimite.value)
        tasks.push(task)

        nome.value = ''
        datalimite.value = ''
        statustag.value = "A fazer"

        loadTasks();
    } else {
        window.alert("Preencha todos os campos!")
    }
    
}

function remover(id) {
    
    document.getElementById(id).remove()
    tasks.splice(id, 1)

    for (let i = 0; i < tasks.length; i++) {
        tasks[i].id = i; 
    }

    loadTasks();
}

function editar(id) {
    const form = document.querySelector("#add-task-area")
    const nome = document.querySelector("#nometask");
    const datalimite = document.querySelector("#datalimite")
    const statustag = document.querySelector("#status")
    const save_btn = document.getElementById("save-button")
    const cancel_btn = document.getElementById("cancelar")
    const add_btn = document.getElementById("add-button")

    const idtag = document.createElement("input");
    idtag.hidden = true
    idtag.type = "number"
    idtag.id = "savetask"
    idtag.value = id
    form.appendChild(idtag)

    save_btn.hidden = false
    cancel_btn.hidden = false
    add_btn.hidden = true

    
    nome.value = tasks[id].name
    datalimite.value = tasks[id].datalimite
    statustag.value = tasks[id].status

    loadTasks();
}

function visualizar(id) {

    const modal = document.getElementById("modal-info")
    const content = document.getElementsByClassName("modal-content")[0]
    const span = document.getElementsByClassName("close")[0];
    
    const task = tasks[id]
    const info = `
                <h2>Informações da tarefa:</h2>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;Nome: ${task.name}</span>
                <br>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;Status: ${task.status}</span>
                <br>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;Data de termino: ${task.datalimite}</span>
                <br>`


    modal.style.display = "block";
    content.innerHTML = info

    span.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal)
            modal.style.display = "none";
    }
    
}

function salvar() {
    const idtag = document.querySelector(`#savetask`)
    const nome = document.querySelector("#nometask");
    const datalimite = document.querySelector("#datalimite")
    const statustag = document.querySelector("#status")
    const save_btn = document.getElementById("save-button")
    const cancel_btn = document.getElementById("cancelar")
    const add_btn = document.getElementById("add-button")

    if (nome.value.trim().length > 0 && datalimite.value) {

        let task = new Task(tasks.length, nome.value, statustag.value, datalimite.value)
        tasks[idtag.value] = task
        
        for (let i = 0; i < tasks.length; i++) {
            tasks[i].id = i; 
        }

        nome.value = ''
        datalimite.value = ''
        statustag.value = "A fazer"

        loadTasks();
    } else {
        window.alert("Preencha todos os campos!")
    }

    save_btn.hidden = true
    cancel_btn.hidden = true
    add_btn.hidden = false
}

function cancelar() {
    const nome = document.querySelector("#nometask");
    const datalimite = document.querySelector("#datalimite")
    const statustag = document.querySelector("#status")
    const save_btn = document.getElementById("save-button")
    const cancel_btn = document.getElementById("cancelar")
    const add_btn = document.getElementById("add-button")

    save_btn.hidden = true
    cancel_btn.hidden = true
    add_btn.hidden = false 

    nome.value = ''
    datalimite.value = ''
    statustag.value = ''

    loadTasks();
}
