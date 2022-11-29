function cargarReporteHistorial6Meses(ejeY,ejeYSilver,ejeYGold,ejeYDiamond) {
    const labelsWau = ejeY.split(",");
    const dataWAU = {
        labels: labelsWau,
        datasets: [
            {
                label: labelsWau,
                backgroundColor: 'rgb(209,227,252,0.5)',
                data: ejeYDiamond.split(","),
                fill: true,
                borderColor: 'rgb(136,182,247)',
                tension: 0.2
            }]

    };

    const configWAU = {
        type: 'line',
        data: dataWAU,
        options: {maintainAspectRatio: false,}
    };


    if (graphWAU) {
        graphWAU.destroy();
    }

    graphWAU= new Chart(
        document.getElementById('graphWAU'),
        configWAU
    );
    graphWAU.canvas.parentNode.style.height = '300px';
    graphWAU.update();
}