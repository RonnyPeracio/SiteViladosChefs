
document.addEventListener('DOMContentLoaded', function (event) {


    const btnCep = $("#btn-cep");

    $("#cep").change(function () {
        buscarCep();
    });


    btnCep.addEventListener('click', function (event) {
        buscarCep();
    });

    //tudo que quiser que seja inicializado quando a pagina carregar....

});

const buscarCep = function () {

    const cep = document.getElementById("cep").value;
    //alert(cep);

    $.getJSON(`http://cep.republicavirtual.com.br/web_cep.php?cep=${cep}&formato=json`, function (resp) {

        const tipo_logradouro = resp.tipo_logradouro;
        const logradouro = resp.logradouro;
        const numero = resp.numero;
        const bairro = resp.bairro;
        const cidade = resp.cidade;
        const estado = resp.uf;

        $("#logradouro").val(tipo_logradouro + " " + logradouro);
        $("#numero").val(numero);
        $("#complemento").val();
        $("#bairro").val(bairro);
        $("#cidade").val(cidade);
        $("#estado").val(estado.toUpperCase());
    });
};
const editar = function (el) {

};



