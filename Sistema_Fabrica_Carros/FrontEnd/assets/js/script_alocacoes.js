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
            const veiculos = await response.json();

            veiculos.forEach((veiculo) => {
                listaAutomoveis.push(veiculo);
            });

            console.log(listaAutomoveis);
        } catch(error) {
            console.log("Erro ao buscar automoveis da area!" ,error);
        }
    })
})