<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="persistencia.Conexao"%>
<jsp:include page="header.jsp"/>


<%

    Conexao conexao = new Conexao();
    String sql = "select * from clientes";

    Statement stm = conexao.conectar().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet rs = stm.executeQuery(sql);

%>

<div class="container">

    <fieldset>
        <legend>
            Administração de Clientes            
        </legend>
        <div class="card card-body">
            <form action="contato" method="post" id="form-cliente">
                <input type="hidden" id="origem" name="origem" value="clientes.jsp">
                <div class="row">
                    <div class="form-group col-md-2">
                        <label for="id">Id</label>
                        <input type="number" class="form-control" id="id" name="id" readonly="readonly" value="0" >
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control"  id="nome" name="nome"  >
                    </div>
                    <div class="form-group col-md-4">
                        <label for="celular">Celular</label>
                        <input type="tel" class="form-control"  id="celular" name="celular" maxlength="11" size="11" placeholder="Somente Numeros"  >
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-8">
                        <label for="email">E-Mail</label>
                        <input type="email" class="form-control"  id="email" name="email"  >
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cep">CEP</label>
                        <input type="text" class="form-control"  id="cep" name="cep"  >
                    </div>
                    <div class="form-group col-md-2">
                        <label for="numero">Número</label>
                        <input type="text" class="form-control"  id="numero" name="numero" >
                    </div>
                </div>  
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="logradouro">Logradouro</label>
                        <input type="text" class="form-control"  id="logradouro" name="logradouro"  >
                    </div>
                    <div class="form-group col-md-2">
                        <label for="complemento">Complemento</label>
                        <input type="text" class="form-control"  id="complemento" name="complemento"  >
                    </div>
                    <div class="form-group col-md-2">
                        <label for="bairro">Bairro</label>
                        <input type="text" class="form-control"  id="bairro" name="bairro"  >
                    </div>
                    <div class="form-group col-md-2">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control"  id="cidade" name="cidade"  >
                    </div>
                </div>
                <div class="btn-group">
                    <button type="submit" class="btn btn-success mr-2 rounded"><i class="fa fa-save"></i> Salvar</button>
                    <button type="reset" id="reset" onclick="reset()" class="btn btn-success rounded"><i class="fa fa-recycle"></i> Limpar</button>
                    <a class="btn btn-success ml-2 rounded" href="index.jsp"> Voltar</a> 
                </div>
            </form>

        </div>

    </fieldset>


    <table class="table table-striped table-hover">

        <thead>
            <tr>
                <th>
                    Id
                </th>
                <th>
                    Nome
                </th>
                <th>
                    E-Mail
                </th>
                <th width="100">
                    Opções
                </th>
            </tr>

        </thead>
        <tbody>
            <% while (rs.next()) {%>  

            <tr data-cliente_id="<%=rs.getString("cliente_id")%>" 
                data-cliente_nome="<%=rs.getString("cliente_nome")%>"
                data-cliente_celular="<%=rs.getString("cliente_celular")%>"
                data-cliente_email="<%=rs.getString("cliente_email")%>"
                data-cliente_cep="<%=rs.getString("cliente_cep")%>"
                data-cliente_numero="<%=rs.getString("cliente_numero")%>"
                data-cliente_logradouro="<%=rs.getString("cliente_logradouro")%>"
                data-cliente_complemento="<%=rs.getString("cliente_complemento")%>"
                data-cliente_bairro="<%=rs.getString("cliente_bairro")%>"
                data-cliente_cidade="<%=rs.getString("cliente_cidade")%>"

                >
                <td>
                    <%=rs.getString("cliente_id")%> 
                </td>
                <td>
                    <%=rs.getString("cliente_nome")%> 
                </td>
                <td>
                    <%=rs.getString("cliente_email")%>
                </td>
                <td width="100">
                    <div class="d-flex justify-content-center">
                        <button type="button" onclick="editar(parentElement.parentElement.parentElement)" class="btn btn-success"><i class="fa fa-edit"></i> Editar</button>
                        <form action="contato" method="POST">
                            <input type="hidden" name="_method" value="DELETE" />
                            <input type="hidden" name="id" value="<%=rs.getString("cliente_id")%>" />
                            <button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i> Excluir</button>                        
                        </form>
                    </div>
                </td>
            </tr>

            <%}%>
        </tbody>

    </table>

</div>


<script>
    document.addEventListener("DOMContentLoaded", function (event) {

//        document.getElementById("form-cliente").addEventListener("submit", function (evt) {
//
//            //evt.preventDefault();
//            //submit();
//        });

    });

    function submit() {
        console.log(document.forms[0].id.value);
    }
    ;

    function reset() {

        document.getElementById("reset").value = "0";

    }
    function editar(el) {


        document.getElementById("id").value = el.getAttribute("data-cliente_id");
        document.getElementById("nome").value = el.getAttribute("data-cliente_nome");
        document.getElementById("celular").value = el.getAttribute("data-cliente_celular");
        document.getElementById("email").value = el.getAttribute("data-cliente_email");
        document.getElementById("cep").value = el.getAttribute("data-cliente_cep");
        document.getElementById("numero").value = el.getAttribute("data-cliente_numero");
        document.getElementById("logradouro").value = el.getAttribute("data-cliente_logradouro");
        document.getElementById("complemento").value = el.getAttribute("data-cliente_complemento");
        document.getElementById("bairro").value = el.getAttribute("data-cliente_bairro");
        document.getElementById("cidade").value = el.getAttribute("data-cliente_cidade");


        window.scrollTo(0, 0);
    }



</script>



<br>
<jsp:include page="footer.jsp"/>
