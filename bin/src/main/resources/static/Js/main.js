$('input').on('keypress', function () {
  $('#error').text('')
})

$('.input').on('focus', function () {
  let parent = this.parentNode.parentNode;
  parent.classList.add("focus");
})

$('.input').on('blur', function () {
  let parent = this.parentNode.parentNode;
  if (this.value == "") {
    parent.classList.remove("focus");
  }
});


 
