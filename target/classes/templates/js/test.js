if (sec:authorize="hasAuthority('ADMIN')"){
 $("div.admin").show();
}

  var x = document.getElementById("admin");
  if (x.sec:authorize="hasAuthority('ADMIN')") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }