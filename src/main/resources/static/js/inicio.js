
let obj = {};

let graphWAU = new Chart(
    document.getElementById('graphWAU'),
    {
        type: 'line',
        data: null,
        options: {maintainAspectRatio: false,}
    }
);

function obtenerTipoCambio() {
    $.ajax({
            url: window.location.origin + "/obtenerTipoCambio",
            success: function (data) {
                console.log(data)
                obj = data
                $('#compra-value').text(data.compra);
                $('#venta-value').text(data.venta);
            }
        }
    )
}

obtenerTipoCambio();

$('#input-envias').on('input', function () {
    $('#input-recibes').val(($(this).val() / obj.compra ?? 0).toFixed(2));
    $('#orientador').text('Estas comprando dolares')
})

$('#input-recibes').on('input', function () {
    $('#input-envias').val(($(this).val() * obj.venta ?? 0).toFixed(2))
    $('#orientador').text('Estas vendiendo dolares')
})


function obtenerHistorial() {
    $.ajax({
            url: window.location.origin + "/obtenerHistorial",
            success: function (data) {
                console.log(data)

                const buyList=[]
                const sellList=[]
                const dateList=[]
                $.each(data.history,function (index,value){
                    buyList.push(value.buy)
                    sellList.push(value.sell)
                    dateList.push(value.date)
                })

                const dataWAU = {
                    labels: dateList,
                    datasets: [
                        {
                            label: 'Venta',
                            backgroundColor:'rgb(151,206,192,0.5)',
                            data: sellList,
                            fill: true,
                            borderColor: 'rgb(84,176,149)',
                            tension: 0.2
                        },
                        {
                            label: 'Compra',
                            backgroundColor: 'rgb(246,214,135,0.5)',
                            data: buyList,
                            fill: true,
                            borderColor: 'rgb(241,188,73)',
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
                graphWAU.update();
            }
        }
    )
}


obtenerHistorial()