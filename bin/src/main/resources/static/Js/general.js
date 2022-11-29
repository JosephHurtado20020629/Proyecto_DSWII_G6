//Declarando variables
var cjbusqueda = document.getElementById("caja-busqueda");
var text = document.getElementById("buscador");
var btnbusqueda = document.getElementById("btn-buscar");
var resultados = document.getElementById("resultados");
var user = document.getElementById("btn-usuario");
var username = document.getElementById("usuario");
var nom = document.getElementById("nombre");
var Producto = document.getElementsByClassName("btn-compras");
var c = document.getElementById("ncompras");
var cont = 0;
var carrito=document.getElementById("carrito")
var hombre = document.getElementById("hombre");
var mujer = document.getElementById("mujer");
var mensaje=document.getElementById("msj")

//Llamando Funciones
btnbusqueda.addEventListener("click", abrir);
btnbusqueda.addEventListener("click", userup);
btnbusqueda.addEventListener("dblclick", Cerrar);
text.addEventListener("keyup", buscar);
user.addEventListener("click", userdown);
user.addEventListener("click", Cerrar);
user.addEventListener("dblclick", userup);
carrito.addEventListener("click", mostrar);
productos();
//Abrir y cerrar el Buscador
function abrir() {
  btnbusqueda.style.color = "#475267";
  btnbusqueda.style.background = "white";
  text.style.width = "300px";
  text.style.padding = "0 6px";
  cjbusqueda.style.background = "#303d56";
}
function Cerrar() {
  btnbusqueda.style.color = "";
  btnbusqueda.style.background = "";
  text.style.width = "";
  text.style.padding = "";
  cjbusqueda.style.background = "";
  resultados.style.display = "";
  text.value = "";
}
//Funcion Buscar
function buscar() {
  filter = text.value.toUpperCase();
  h2 = resultados.getElementsByTagName("div");
  for (i = 0; i < h2.length; i++) {
    a = h2[i].getElementsByTagName("h2")[0];
    textValue = a.textContent || a.innerText;
    if (textValue.toUpperCase().indexOf(filter) > -1) {
      h2[i].style.display = "";
      resultados.style.display = "block";
      if (text.value==="" ) {
        resultados.style.display = "none";
      }
    } else {
      h2[i].style.display = "none";
    }
  }
}
function userdown() {
  username.style.display = "block";
}
function userup() {
  username.style.display = "none";
}


//Funcion de Suma de Productos
function productos() {
  for (let i = 0; i < Producto.length; i++) {
    Producto[i].onclick = function () {
      cont++;
      c.innerText = "" + cont;
    };
  }
}
function mostrar() {
  a = c.innerHTML;
  if (a == 0) {
    alert("Usted no ha comprado aun");
  } else {
    alert(
      "Usted ha comprado " +
        a +
        " Productos" +
        "\n" +
        "Gracias por su Compra " +sessionStorage.nom+
        " (•‿•) "
    );
  }
}

//menu con JQuery
$(".btn").click(function () {
  $(this).toggleClass("click");
  $(".sidebar").toggleClass("show");
});

$(".sidebar-btn").click(function () {
  $("aside ul .sublist-show").addClass("show").siblings().removeClass("show");
  $("aside ul .fa-caret-down").toggleClass("rotate");
  $("aside ul .tiendas-show").removeClass("show1");
});



$("aside ul li").click(function () {
  $(this).addClass("active").siblings().removeClass("active");
});
