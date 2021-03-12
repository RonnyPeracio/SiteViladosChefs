<%-- 
    Document   : animation
    Created on : 12/03/2021, 08:41:04
    Author     : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="profile" href="https://gmpg.org/xfn/11" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            html,body{
                height:100%;
            }
            body{
                overflow:hidden;
            }
            .box{
                max-width:70vw;
                width:100%;
                padding:30px;
                position:relative;
                top:50%;
                font-size:30px;
                line-height: 1.5;
                transform:translateY(-50%);
                margin:0 auto;
            }

        </style>
    </head>
    <body>
<!--        <h1>Agradecimos</h1>-->
        
        
            <div class="box">
                <br>
<!--        <p class="split">Animation is the process of creating the illusion of motion 
            and shape change by means of the rapid display of a sequence of static images 
            that minimally differ from each other. The illusion—as in motion pictures in 
            general—is thought to rely on the phi phenomenon. Animators are artists who 
            specialize in the creation of animation. Animation is the process of creating the 
            illusion of motion and shape change by means of the rapid display of a sequence of 
            static images that minimally differ from each other. The illusion—as in motion pictures 
            in general—is thought to rely on the phi phenomenon. Animators are artists who specialize 
            in the creation of animation.</p>-->
        
        <p class="split">
            Uma jornada começa com um simples passo, até mesmo num engatinhar, mas o retorno geralmente vem em um passo gigante.
        </p>
        <br> <br>
    </div>
         <br> <br> <br>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/gsap/1.15.0/TweenMax.min.js"></script>
    <script type="text/javascript" src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/SplitText3.min.js"></script>
        
        <script>
            $(function () {
                var text = $('.split');
                var split = new SplitText(text);
                function random(min, max) {
                    return (Math.random() * (max - min)) + min;
                }
                $(split.chars).each(function (i) {
                    TweenMax.from($(this), 3.5, {
                        opacity: 0,
                        x: random(-1500, 1500),
                        y: random(-1500, 1500),
                        z: random(-1500, 1500),
                        scale: .2,
                        delay: i * .01,
                        yoyo: true,
                        repeat: -1,
                        repeatDelay: 5
                    });
                });
            });
        </script>
    </body>
</html>
