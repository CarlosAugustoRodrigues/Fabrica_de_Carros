const PORT = 8080;
const URI = `http://localhost:${PORT}/alocacao`;
const areas = document.querySelectorAll(".area");
var listaAlocacoes = [];

areas.forEach((e) => {
    e.addEventListener("click", async () => {
        listaAutomoveis = [];
        const idArea = e.getAttribute("data-area");

        try {
            const response = await fetch(`${URI}/${idArea}`);
            const data = await response.json();

            data.forEach((alocacao) => {
                listaAlocacoes.push(alocacao);
            });

            window.localStorage.setItem('alocacoes', JSON.stringify(listaAlocacoes));
            window.localStorage.setItem('area', idArea);

            window.location.href = "http://127.0.0.1:5500/assets/pages/informacoes.html";

        } catch (error) {
            console.log("Erro ao buscar automoveis da area!", error);
        }
    });
});

function verificarCarrosNaArea() {
    areas.forEach(async (e) => {
        let listaQuantidadeCarros = [];
        let idArea = e.getAttribute("data-area");

        try {

            const response = await fetch(`${URI}/${idArea}`);
            const data = await response.json();

            data.forEach((alocacao) => {
                listaQuantidadeCarros.push(alocacao);
            });

            if (listaQuantidadeCarros.length > 0) {
                e.classList.remove("area-gray");
                e.classList.add("area-blue");

                return;
            }

            listaQuantidadeCarros = [];
        } catch (error) {
            console.log("Erro ao buscar automoveis da area!", error);

        }
    });
}