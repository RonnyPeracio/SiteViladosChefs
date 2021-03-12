<%-- 
    Document   : adminjsp
    Created on : 14/12/2020, 10:19:56
    Author     : RonnyPeracio
--%>


<jsp:include page="header.jsp"/>
<link rel="stylesheet" type="text/css" href="css/app.css" />
<%
    String mensagem = "";
    if (request.getAttribute("retorno") != null) {
        mensagem = request.getAttribute("retorno").toString();
    }

//    if (isAuth){
//        mensagem = "Seja bem-vindo" + request.getAttribute("usuario_nome");
//    }
%>
<%=mensagem%>

<div class="jumbotron bg-danger text-white">
    <h1>Área Administrativa</h1>
    <p>Acesso Restrito</p>    
</div>

<div class="container-fluid justify-content-start" >
    <div class="list-group w-50">
        <div class="list-group-item">
            <a href="clientes.jsp">Administrar Clientes</a>
        </div><br>
        <div class="list-group-item">
            <a href="produtos.jsp">Administrar Produtos</a>
        </div>
    </div><br>
<a class="btn btn-success" href="index.jsp"> Voltar para Página Principal</a>
</div>

<script>
    document.addEventListener("DOMContentyLoaded", function (event) {

        if (sessionStorage.getItem("Autenticado")) {

            $.post("auth", {
                email: <%=request.getParameter("email")%>,
                senha: <%=request.getParameter("senha")%>,
            }).done(function (resp) {
                console.log(resp);
            });
        } else {
            location.href = "login.jsp";
        }

    });

</script>

<br><br><br>


<jsp:include page="footer.jsp"/>

</body>
</html>

