<%-- 
   Document   : index
   Created on : 25/11/2020, 10:40:58
   Author     : RonnyPeracio
--%>
<jsp:include page="header.jsp"/>
<link rel="stylesheet" type="text/css" href="css/app.css" />
<!--<img src="imagens/Imagens Layout/Banner 01 Web Page Vila dos Chefs.jpg" alt=""/>-->
<!-- <button class="btn btn-primary"><i class="fa fa-home"></i>Quem Somos</button>
   <button class="btn btn-primary"><i class="fa fa-home"></i>Missão</button>
   <button class="btn btn-primary"><i class="fa fa-home"></i>Valores</button>
-->
<br>

<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-fixed-top sticky"  role="navigation">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp"><i class="fa fa-home"></i> Inicio <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#qsmv"><i class="fa fa-info" aria-hidden="true"></i> Quem Somos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="servicos.jsp"><i class="fa fa-info" aria-hidden="true"></i> Serviços</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#galeria"><i class="fa fa-info" aria-hidden="true"></i> Galeria</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="contato.jsp"><i class="fa fa-address-card" aria-hidden="true"></i> Contato</a>
            </li>
        </ul>
    </div>
</nav>


<br>
<br>
<div  class="indice">
    <h2>VILA DOS CHEFS</h2>
    <h3>Seja muito bem-vindo</h3>
    <br>
    <h4>Prazer e comodidade em suas mãos.</h4>
    <!--    <ul>
       <li><a href="qsmv.jsp">Quem Somos / Missão / Valores</a>
       </li>
       <li><a href="servicos.jsp">Serviços</a>
       </li>
       <li><a href="contato.jsp">Contato</a>
       </li>                       
       </ul>
    -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="carousel slide" id="carousel-970679">
                    <ol class="carousel-indicators">
                        <li data-slide-to="0" data-target="#carousel-970679">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-970679" class="active">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-970679">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item">
                            <img class="d-block w-100" alt="Carousel Bootstrap First" src="img/3.jpg" />

                            <div class="carousel-caption">
                                <h4>
                                    Encomendas da Vila dos Chefs
                                </h4>
                                <p style="background-color: rgba(10,23,55,0.5);">
                                    A ideia é proporcionar experiências sensoriais compatíveis com o prazer de receber em casa ou comemorar com amigos e família. 
                                </p>
                            </div>
                        </div>
                        <div class="carousel-item active">
                            <img class="d-block w-100" alt="Carousel Bootstrap Second" src="img/4.jpg"" />
                            <div class="carousel-caption">
                                <h4>
                                    Eventos Sociais ou Corporativos
                                </h4>
                                <p style="background-color: rgba(10,23,55,0.5);">
                                    Nosso compromisso é sugerir opções harmoniosas, saborosas e específicas de pratos a fim de realizar seu evento à altura de suas expectativas.
                                </p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" alt="Carousel Bootstrap Third" src="img/1.jpg" />
                            <div class="carousel-caption">
                                <h4>
                                    Doces e Sobremesas
                                </h4>
                                <p style="background-color: rgba(10,23,55,0.5);">
                                    E, na melhor parte de seu evento, a nossa especialidade, os doces e as sobremesas, que irão deixar seus amigos e familiares apaixonados.
                                </p>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carousel-970679" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-970679" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
                </div>
            </div>
        </div>

        <br><br><br>

        <div class="row"> 
<!--            <div class="col-md-6">
                <img src="img/EntradaVila.jpg" width="90%">
            </div>-->
            <div class="col-md-6 col-md-offset-1">
                <h1>Sobre o Vila dos Chefs</h1>
                <p style="text-align: justify;" class="desc-text">O Restaurante e Vila dos Chefs é ma empresa do ramo alimentício fundada em 2012, com bases familiares sólidas , trabalhando com inovações em nossos serviços e sempre à disposição para sugestões de melhorias, em busca da satisfação dos nossos clientes.
                </p>
            </div>

            <div class="col-md-6">
                
                
                <video autoplay="false" controls="true" width="500" height="240" >
                    <source src="img/Curso.mp4" type="video/mp4" >
                    Your browser does not support the <code>video</code> tag.
                </video>
            </div>    

            <br>
<!--            <div class="col-md-6 col-md-offset-1">
                <h1>Sobre o Vila dos Chefs</h1>
                <p style="text-align: justify;" class="desc-text">O Restaurante e Vila dos Chefs é ma empresa do ramo alimentício fundada em 2012, com bases familiares sólidas , trabalhando com inovações em nossos serviços e sempre à disposição para sugestões de melhorias, em busca da satisfação dos nossos clientes.
                </p>
            </div>-->
        </div>
       
       <br><br><br><br>
       
        <h2>Galeria</h2>
        <br>
<!--        <div class="row"id="galeria">
            <div class="gallerycontainer-align">
                <div class="col-md-3"></div> 
                <div class="col-md-3 gallerycontainer d-flex flex-column" >
                    <div>
                         
                        <a class="thumbnail" href="#thumb">
                                <img src="https://image.freepik.com/foto-gratis/filete-pechuga-pollo-plancha-verdura_1339-43660.jpg" width="100px" height="66px" border="0" />
                                <span>
                                    <img src="https://image.freepik.com/foto-gratis/filete-pechuga-pollo-plancha-verdura_1339-43660.jpg" /><br />Teste 01
                                </span>
                        </a>
                        <a class="thumbnail" href="#thumb">
                            <img src="https://image.freepik.com/foto-gratis/alitas-pollo-al-horno-al-estilo-asiatico_2829-10159.jpg" width="100px" height="66px" border="0" />
                            <span><img src="https://image.freepik.com/foto-gratis/alitas-pollo-al-horno-al-estilo-asiatico_2829-10159.jpg" /><br />Teste 02</span>
                        </a>
                    </div>
                    <div>
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/vista-superior-mujeres-comiendo-alitas-pollo-barbacoa-papas-fritas-ensalada-jugo-sobre-mesa_141793-13206.jpg" width="100px" height="75px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/vista-superior-mujeres-comiendo-alitas-pollo-barbacoa-papas-fritas-ensalada-jugo-sobre-mesa_141793-13206.jpg" /><br />Teste 03</span></a> 
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/trozos-filete-cordero-salsas-pimiento-asado-ensalada-fresca-sobre-tabla-madera_140725-10580.jpg" width="100px" height="70px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/trozos-filete-cordero-salsas-pimiento-asado-ensalada-fresca-sobre-tabla-madera_140725-10580.jpg" /><br />Teste 04</span></a>
                    </div>
                    <DIV>
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/filete-ternera-tierno-jugoso-medio-raro-papas-fritas_2829-19634.jpg" width="100px" height="75px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/filete-ternera-tierno-jugoso-medio-raro-papas-fritas_2829-19634.jpg" /><br />Teste 05</span></a> 
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/filete-cerdo-rodajas-cubierto-sesamo-blanco-semillas-pimienta-frescas_1150-24777.jpg" width="100px" height="70px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/filete-cerdo-rodajas-cubierto-sesamo-blanco-semillas-pimienta-frescas_1150-24777.jpg" /><br />Teste 06</span></a>
                    </DIV>
                    <div>
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/desayuno-europeo-bruschetta-salmon-aguacate-queso_219193-3540.jpg" width="100px" height="75px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/desayuno-europeo-bruschetta-salmon-aguacate-queso_219193-3540.jpg" /><br />Teste 07</span></a> 
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/fotos-gratis/mulher-comendo-uma-tigela-de-salada_1303-23880.jpg" width="100px" height="70px" border="0" /><span><img src="https://image.freepik.com/fotos-gratis/mulher-comendo-uma-tigela-de-salada_1303-23880.jpg" /><br />Teste 08</span></a>
                    </div>
                    <div>
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/ensalada-atun-lechuga-tomates-cherry-aguacate-cebolla-morada-comida-sana-cocina-frances_2829-20268.jpg" width="100px" height="75px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/ensalada-atun-lechuga-tomates-cherry-aguacate-cebolla-morada-comida-sana-cocina-frances_2829-20268.jpg" /><br />Teste 09</span></a> 
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/penne-pasta-salsa-tomate-pollo-tomates-mesa-madera_2829-19744.jpg"  width="100px" height="70px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/penne-pasta-salsa-tomate-pollo-tomates-mesa-madera_2829-19744.jpg"  /><br />Teste 10</span></a>
                    </div>
                    <div>
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/sabrosas-almejas-caseras-frescas-apetitosas-alle-vongole-pasta-mariscos-ajo-vino-blanco-plato-cerca_1220-5487.jpg" width="100px" height="70px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/sabrosas-almejas-caseras-frescas-apetitosas-alle-vongole-pasta-mariscos-ajo-vino-blanco-plato-cerca_1220-5487.jpg" /><br />Teste 11</span></a>
                        <a class="thumbnail" href="#thumb"><img src="https://image.freepik.com/foto-gratis/espaguetis-gambas-fritas-tomates-frescos_127675-2481.jpg" width="100px" height="75px" border="0" /><span><img src="https://image.freepik.com/foto-gratis/espaguetis-gambas-fritas-tomates-frescos_127675-2481.jpg" /><br />Teste 12</span></a> 
                    </div>
                </div>
            </div>


        </div>-->

<!--        galeria 2-->







<!-- Page Content -->
<div class="container"id="galeria">

  <h1 class="font-weight-light text-center text-lg-left mt-4 mb-0"></h1>

  <hr class="mt-2 mb-5">

  <div class="row text-center text-lg-left">

    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
          <img class="img-fluid img-thumbnail" src="img/foto01.jpg" alt="">
          </a>
       
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto011.jpg" alt="">
          </a>
            </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto02.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto03.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto04.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto05.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto06.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto07.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto08.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto09.jpg" alt="">
          </a>
    </div>
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto10.jpg" alt="">
          </a>
    </div>
      
    <div class="col-lg-3 col-md-4 col-6">
      <a href="" class="d-block mb-4 h-100">
            <img class="img-fluid img-thumbnail" src="img/foto11.jpg" alt="">
          </a>
    </div>
    
  </div>

</div>
<!-- /.container -->

<!--fim galeria 2-->

<!--Inicio 3 galeria-->







<!--fim 3 galeria-->


        <br>
        <br>
        <div class="container-fluid">
            <div class="col-md-12">
                <div class="row" id="qsmv">
                    <div class="col-md-4">
                        <div class="valores">
                            <div class="card">
                                <img class="card-img-top" alt="Miniatura de bootstrap primeiro" src="https://www.layoutit.com/img/people-q-c-600-200-1.jpg" />
                                <div class="card-block">
                                    <h5  class="card-title">
                                        <br>
                                        Nossa Missão!
                                    </h5>
                                    <p style="text-align: justify;" class="card-text">
                                        Servir refeições de qualidade, tendo em vista a excelência em variedades e higiene, em um ambiente agradável, com estrutura de ponta e profissionais capacitados a prestar o melhor atendimento.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <img class="card-img-top" alt="Miniatura de bootstrap segundo" src="https://www.layoutit.com/img/city-q-c-600-200-1.jpg" />
                            <div class="card-block">
                                <h5 class="card-title">
                                    <br>
                                    Nossa Visão!
                                </h5>
                                <p  style="text-align: left;" class="card-text">
                                    Ser empresa de referência, reconhecida como a melhor opção por clientes, colaboradores, comunidade e
                                    fornecedores , pela qualidade de nossos produtos, serviços e relacionamento.
                                <br><br>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <img class="card-img-top" alt="Miniatura de bootstrap terceiro" src="https://www.layoutit.com/img/sports-q-c-600-200-1.jpg" />
                            <div class="card-block">
                                <h5 class="card-title">
                                    <br>
                                    Nossos Valores!
                                </h5>
                                <p style="text-align: left;" class="card-text">
                                                                        Trabalho em equipe;<br>
                                    Agilidade e qualidade; <br>
                                    Responsabilidade ambiental;<br>
                                    Respeito aos clientes, fornecedores e colaboradores;<br>
                                    <br>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <br>


                <div class="row">       
                    <div class="col-md-6">
                        <h3>Nossa Localização</h3>
                        <p><a href="https://www.google.com/maps/place/Vila+dos+Chefs/@-20.3009937,-40.3002407,16.24z/data=!4m5!3m4!1s0x0:0x4ff2573bb95e64d8!8m2!3d-20.3013161!4d-40.299493" target="_blank">
                                <img src="img/mapa.jpg" width="70%" height="80%"alt=""/>
                            </a></p>
                    </div>


                    <div class="col-md-6">
                        <h3>Aponte a camera do seu celular para acessar o instagram do restaurante.</h3>
                        <img src="img/qrcode.jpg" width="40%">
                    </div>
                </div>
            </div>
        </div>
        <br>  
        

    </div>
    
    
</div>
<jsp:include page="footer.jsp"/>