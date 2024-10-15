const divCards = document.querySelector(".div-cards-automoveis");
const area = window.localStorage.getItem('area');
const areaTexto = document.querySelector("#area");
var listaAutomoveis = JSON.parse(window.localStorage.getItem('veiculos'));

function numArea() {
    areaTexto.innerHTML = area;
}

function criarCards() {
    listaAutomoveis.forEach((e) => {
        const modelo = e.modelo;
        const preco = e.preco;
        const card = `
            <div class="card-automovel">
                    <div class="div-automovel">
                        <p>Modelo: <span>${modelo}</span></p>
                        <p>Preço: <span>R$ ${preco.toFixed(2)}</span></p>
                    </div>
    
                    <button class="btn-vender">Vender</button>
                </div>
        `
        divCards.innerHTML += card;
    });
}