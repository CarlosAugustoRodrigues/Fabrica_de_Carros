const PORT = 8080;
const URI = `http://localhost:${PORT}/alocacao`;
const areas = document.querySelectorAll(".area");
var listaAutomoveis = [];

areas.forEach((e) => {
    e.addEventListener("click", async () => {
        listaAutomoveis = [];
        const idArea = e.getAttribute("data-area");
        
        try {
            const response = await fetch(`${URI}/${idArea}`);
            const data = await response.json();

            data.forEach((veiculo) => {
                listaAutomoveis.push(veiculo);
            });

            window.localStorage.setItem('veiculos', JSON.stringify(listaAutomoveis));
            window.localStorage.setItem('area', idArea);
        
            window.location.href = "http://127.0.0.1:5500/assets/pages/informacoes.html";

        } catch(error) {
            console.log("Erro ao buscar automoveis da area!" ,error);
        }
    });
});

function verificarCarrosNaArea() {
    areas.forEach( async (e) => {
        let listaQuantidadeCarros = [];
        let idArea = e.getAttribute("data-area");

        try {

            const response = await fetch(`${URI}/${idArea}`);
            const veiculos = await response.json();

            veiculos.forEach((veiculo) => {
                listaQuantidadeCarros.push(veiculo);
            });

            if (listaQuantidadeCarros.length > 0) {
                e.classList.remove("area-gray");
                e.classList.add("area-blue");

                return;
            }

            listaQuantidadeCarros = [];
        } catch (error) {
            console.log("Erro ao buscar automoveis da area!" ,error);

        }
    });
}