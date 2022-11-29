//Banner
var img = document.getElementById("img-baner");
var arrimg = ["Banner1.svg", "Banner2.svg", "Banner3.svg"];
var indice = document.getElementsByClassName("indice");
var contador = 0;
var selector = document.getElementsByClassName("selector");
var items = document.getElementsByClassName("compras");
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

for (let i = 0; i < selector.length; i++) {
  selector[i].onclick = function () {
    let a = this.innerHTML;
    let select = document.getElementsByClassName(a);
    for (let i = 0; i < items.length; i++) {
      items[i].style.display = "none";
    }
    for (let i = 0; i < select.length; i++) {
      select[i].style.display = "inline-block";
    }
  };
}
