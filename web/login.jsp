<%-- 
    Document   : login
    Created on : 17/12/2020, 11:44:45
    Author     : RonnyPeracio
--%>
<jsp:include page="header.jsp"/>

<div class="jumbotron text-center flex-column">
    <h1> Acesso Administrativo</h1>
    <h3>Entrada Restrita</h3>    
</div>

<% if (request.getAttribute("retorno") != null) {%>
<div class="alert alert-info"><%= request.getAttribute("retorno")%></div>
<%}%>

<div class="d-flex justify-content-center">
    <form class="" method="post" action="Auth">
        <div class="card mt-4" style="width: 500px">    
            <div class="card-header">
                <div class="card-title text-center">
                    Autenticação Requerida            
                </div>
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label for="email">E-Mail</label>
                    <input class="form-control" name="email" id="email" type="email" required="required">
                </div>
                <div class="form-group">
                    <label for="senha">Senha</label>
                    <input class="form-control" name="senha" id="senha" type="password" required="required">
                </div>
            </div>
            <div class="card-footer">
                <button type="submit" class="btn btn-success" href="admin.jsp">Entrar</button>
                <a type="button" class="btn btn-info" href="index.jsp">Voltar</a>
            </div>    
        </div>
    </form>
</div>
<br>
<jsp:include page="footer.jsp"/>

