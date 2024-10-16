const divCards = document.querySelector(".div-cards-automoveis");
const area = window.localStorage.getItem('area');
const areaTexto = document.querySelector("#area");
var listaAlocacoes = JSON.parse(window.localStorage.getItem('alocacoes'));

function numArea() {
    areaTexto.innerHTML = area;
}

function criarCards() {
    if (listaAlocacoes == 0) {
        divCards.innerHTML = "<h1>Nenhum carro alocado nesta área!</h1>"
        divCards.style.justifyContent = "center";
        return;
    }
    
    listaAlocacoes.forEach((e) => {
        const dataVeiculo = {
            id: e.automovel.id,
            modelo: e.automovel.modelo,
            preco: e.automovel.preco,
            quantidade: e.quantidade
        }
        
        const card = `
            <div class="card-automovel">
                    <div class="div-automovel">
                        <p>Modelo: <span>${dataVeiculo.modelo}</span></p>
                        <p>Preço: <span>R$ ${dataVeiculo.preco.toFixed(2)}</span></p>
                        <p>Quantidade: <span>${dataVeiculo.quantidade}</span></p>
                    </div>
    
                    <button class="btn-vender" onclick="vender(${dataVeiculo.id}, '${dataVeiculo.modelo}', ${dataVeiculo.preco})">Vender</button>
                </div>
        `
        divCards.innerHTML += card;
    });
}

function limparLocalStorage() {
    window.localStorage.clear();
}

function vender(id, modelo, preco) {
    const dataVeiculo = {
        id: Number(id),
        modelo: modelo,
        preco: parseFloat(preco)
    }

    window.localStorage.setItem("automovel", JSON.stringify(dataVeiculo));
    window.location.href = "./venda.html";
}

console.log(listaAlocacoes);