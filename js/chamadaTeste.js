/* function chamarMetodoJava() {
    // Cria um objeto XMLHttpRequest
    var xhttp = new XMLHttpRequest();
    
    // Define o callback para processar a resposta da chamada AJAX
    xhttp.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
          // Processa a resposta em formato JSON
          var resultado = JSON.parse(this.responseText);
          
          // Faz algo com o resultado
          console.log(resultado);
       }
    };
    
    // Faz a chamada AJAX para o servlet Java
    xhttp.open("GET", "/meuservlet", true);
    xhttp.send();
 } */