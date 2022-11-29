//Banner
var img = document.getElementById("img-baner");
var arrimg = ["Banner1.svg", "Banner2.svg", "Banner3.svg"];
var indice = document.getElementsByClassName("indice");
var categoria=document.getElementsByClassName("cat")
var contador=0;

function carrusel() {
  let tiempo;
  img.setAttribute("src", ruta+"icons/" + arrimg[contador]);
  for (let i = 0; i < indice.length; i++) {
    indice[i].style.color = "darkgray";
    indice[i].onclick = function () {
      img.setAttribute("src",ruta+"icons/" + arrimg[i]);
    };
  }
  indice[contador].style.color = "#384358";
  contador++;
  if (contador >= 3) contador = 0;
  tiempo = setTimeout("carrusel()", 2000);
}
carrusel();





