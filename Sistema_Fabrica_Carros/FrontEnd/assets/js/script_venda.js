const PORT = 8080;
const URI = `http://localhost:${PORT}`;
const automovel = JSON.parse(window.localStorage.getItem("automovel"));
const area = window.localStorage.getItem('area');
const main = document.querySelector('main');
var listaClientes = [];
var listaConcessionaria = [];

function cardVenda() {
    main.innerHTML = `
        <div class="card-venda">
            <div class="info-automovel">
                <h2>${automovel.modelo}</h2>
                <h3>R$ ${automovel.preco.toFixed(2)}</h3>
            </div>

            <select name="concessionaria" id="concessionarias">
                <option value="">Selecione a concessionária</option>
            </select>

            <select name="cliente" id="clientes">
                <option value="">Selecione o cliente</option>
            </select>

            <button onclick="vender()">Concluir venda</button>
        </div>
    `
}

async function fetchClientes() {
    try {
        const response = await fetch(`${URI}/cliente`);
        const clientes = await response.json();

        await clientes.forEach((cliente) => {
            listaClientes.push(cliente);
        })

        inserirClientes();
    } catch(error) {
        console.log("Erro ao buscar clientes!")
    }
}

async function fetchConcessionarias() {
    try {

        const response = await fetch(`${URI}/concessionaria`);
        const concessionarias = await response.json();

        await concessionarias.forEach((concessionaria) => {
            listaConcessionaria.push(concessionaria);
        })
        inserirConcessionarias();
    } catch(error) {
        console.log("Erro ao buscar concessionárias!")
    }
}

function inserirClientes() {
    const selectCliente = document.querySelector('#clientes');

    listaClientes.forEach((cliente) => {
        selectCliente.innerHTML += `<option value="${cliente.nome}">${cliente.nome}</option>`;
    });
}

function inserirConcessionarias() {
    const selectConcessionaria = document.querySelector('#concessionarias');

    listaConcessionaria.forEach((concessionaria) => {
        selectConcessionaria.innerHTML += `<option value="${concessionaria.concessionaria}">${concessionaria.concessionaria}</option>`;
    });
}

async function vender() {
    try {

        const response = await fetch(`${URI}/alocacao/${area}/${automovel.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if(confirm("Automovel vendido com sucesso!")) {
            window.location.href = "http://127.0.0.1:5500/index.html";
        }

    } catch(error) {
        console.log("Erro ao vender automovel!")
    }
}

function limparLocalStorage() {
    window.localStorage.clear();
}

document.addEventListener("DOMContentLoaded", async (e) => {
    cardVenda();
    await fetchConcessionarias();
    await fetchClientes();
})
