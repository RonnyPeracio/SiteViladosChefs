<%-- 
    Document   : contato
    Created on : 30/11/2020, 10:02:02
    Author     : RonnyPeracio
--%>

<jsp:include page="header.jsp" />

<%
    if (request.getAttribute("retorno") != null) {%>

<div id="message" class="alert alert-info">

    <%= request.getAttribute("retorno")%>

</div>


<%}%>

<form id="form-contato" method="post" action="contato">

    <input type="hidden" id="id" name="id" value="0">
    <input type="hidden" id="origem" name="origem" value="contato.jsp">

    <h1 id="texto">Seja bem-vindo!</h1><br>
    <div class="container">
        <h3 id="texto">Insira seus dados e entraremos em contato</h3><br></br>
        <div class="form-group">
            <label for="nome">Seu Nome:</label>
            <input type="text" class="form-control" id="nome" placeholder="Digite seu nome" name="nome" required="required">
        </div><br>  
        <div class="form-group">
            <label for="celular">Celular com WhatsApp:</label>
            <input type="tel" class="form-control" id="celular" placeholder="(XX) XXXX-XXXX" name="celular" maxlength="11" required="required">
        </div><br>
        <div class="form-group">
            <label for="email">E-Mail:</label>
            <input type="text" class="form-control" id="email" placeholder="Digite seu e-mail (opcional)" name="email">
        </div><br>
        <div class="form-group">
            <label for="senha">Senha:</label>
            <input type="password" class="form-control" id="senha" placeholder="Crie uma senha de Login (opcional)" name="senha">
        </div>
        <div> 
            <label for="opt"><input type="radio" name="remember"> Lembrar Senha</label>
            <label><input type="radio" name="remember"> Esqueci a Senha</label>
        </div><br>
        <div class="form-group">
            <label for="desejo">Conte-nos sobre a sua ideia para seu evento:</label>
            <textarea class="form-control" rows="5" id="desejo" name="desejo" placeholder="Conte-nos sobre o que você esta pensando para seu evento?" required="required"></textarea>
        </div>
        <div> <!-- Button trigger modal -->
            <label for="opt"><input type="radio" id="opt" name="tipo_entrega" data-toggle="modal" data-target="#modalEndereco"> Selecione para entrega em seu local </label>

            <label><input type="radio" name="tipo_entrega" checked="checked"> Selecione se for retirar na Vila dos Chefs</label>
        </div><br>

        <div class="d-flex justify-content-between">
            <div>
<!--                <button type="submit" class="btn btn-success"> Enviar</button>-->
                <a class="btn btn-primary" href="SendmailServlet?email=xxx@gmail.comn&desejo=sdfggfsdgdg"> Enviar Email</a>
                <i style="font-size:24px" class="fa">&#xf0fb;</i>
                <!--            <button style="font-size:20px; color: whitesmoke; background-color: firebrick">Enviar <i class="fa fa-fighter-jet"></i></button>-->
                <a class="btn btn-primary" href="servicos.jsp"> Serviços</a>
                <i style="font-size:24px" class="fa">&#xf0b1;</i>
                <!--            <button style="font-size:20px; color: whitesmoke; background-color: firebrick">Serviços <i class="fa fa-briefcase"></i></button>-->
                <a class="btn btn-primary" href="index.jsp"> Página Principal</a>
                <i style="font-size:24px" class="fa">&#xf1e5;</i>
            </div>  
            <div class="d-flex flex-1 checkbox">
                <div class="row flex justify-content-end pr-3">
                    <div class="d-flex justify-content-center align-items-center insta img-rounded text-center mr-2" >
                        <a href="https://www.instagram.com/viladoschefs/?hl=pt-br" target="__blank"> <i class="fab fa-3x fa-instagram"></i></a></div>                
                    <div class="text-green-white img-rounded p-1 text-center">
                        <a href="https://api.whatsapp.com/send?phone=5527998965150&text=Fale%20conosco" target="__blank"><i class="fab fa-3x fa-whatsapp"></i></a></div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="modalEndereco" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Por favor, preencha corretamente o seu endereço.</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="cep">Digite primeiro o seu CEP:</label>
                            <input type="text" class="form-control" id="cep" placeholder="Somente os numeros" name="cep" maxlength="8">
                        </div>
                        <p style="font-weight: bolder; text-align: center">Somente complete agora os dados de seu endereço.</p>
                        <div class="row">
                            <div class="form-group col-md-10">
                                <label for="logradouro">Logradouro:</label>
                                <input type="text" class="form-control" id="logradouro" placeholder="Seu endereço" name="logradouro">
                            </div><br>
                            <div class="form-group col-md-2">
                                <label for="numero">Número:</label>
                                <input type="text" class="form-control" id="numero" placeholder="nro" name="numero" >
                            </div><br>
                        </div>
                        <div class="form-group">
                            <label for="complemento">Complemento:</label>
                            <input type="text" class="form-control" id="complemento" placeholder="Complemento" name="complemento">
                        </div><br>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="bairro">Bairro:</label>
                                <input type="text" class="form-control" id="bairro" placeholder="Seu bairro" name="bairro">
                            </div><br>
                            <div class="form-group col-md-4">
                                <label for="cidade">Cidade:</label>
                                <input type="text" class="form-control" id="cidade" placeholder="Sua cidade" name="cidade">
                            </div><br>
                            <div class="form-group col-md-2">
                                <label for="estado">Estado:</label>
                                <input type="text" class="form-control" id="estado" placeholder="UF" name="estado" maxlength="2">
                            </div><br>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
<!--                        <button type="button" class="btn btn-primary">Salvar Dados</button>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<br>
<br>

<script>
    setTimeout(function () {
        $("#message").hide();
    }, 5000);
      
$("#cep").keyup(function (event) {

    var t = event.target.value;

    if (t.length >= 8) {
        buscarCep();
        $("#numero").focus();
    }
});      
</script>
<br>
<jsp:include page="footer.jsp"/>
