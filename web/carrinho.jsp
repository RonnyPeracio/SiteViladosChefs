<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Carrinho de Compras</title>
        <style>

            /*
      To change this license header, choose License Headers in Project Properties.
      To change this template file, choose Tools | Templates
      and open the template in the editor.
            */
            /* 
                Created on : 04/03/2021, 18:31:33
                Author     : Thiago
            */

            /*charset "utf-8";*/

            @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700,600);

            html,
            html a {
                -webkit-font-smoothing: antialiased;
                text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.004);
            }

            body {
                background-color: #fff;
                color: #666;
                font-family: 'Open Sans', sans-serif;
                font-size: 62.5%;
                margin: 0 auto;
            }

            a {
                border: 0 none;
                outline: 0;
                text-decoration: none;
            }

            strong {
                font-weight: bold;
            }

            p {
                margin: 0.75rem 0 0;
            }

            h1 {
                font-size: 0.75rem;
                font-weight: normal;
                margin: 0;
                padding: 0;
            }

            input,
            button {
                border: 0 none;
                outline: 0 none;
            }

            button {
                background-color: #666;
                color: #fff;
            }

            button:hover,
            button:focus {
                background-color: #555;
            }

            img,
            .basket-module,
            .basket-labels,
            .basket-product {
                width: 100%;
            }

            input,
            button,
            .basket,
            .basket-module,
            .basket-labels,
            .item,
            .price,
            .quantity,
            .subtotal,
            .basket-product,
            .product-image,
            .product-details {
                float: left;
            }

            .price:before,
            .subtotal:before,
            .subtotal-value:before,
            .total-value:before,
            .promo-value:before {
                content: 'R$';
            }

            .hide {
                display: none;
            }

            main {
                clear: both;
                font-size: 0.75rem;
                margin: 0 auto;
                overflow: hidden;
                padding: 1rem 0;
                width: 960px;
            }

            .basket,
            aside {
                padding: 0 1rem;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            .basket {
                width: 70%;
            }

            .basket-module {
                color: #111;
            }

            label {
                display: block;
                margin-bottom: 0.3125rem;
            }

            .promo-code-field {
                border: 1px solid #ccc;
                padding: 0.5rem;
                text-transform: uppercase;
                transition: all 0.2s linear;
                width: 48%;
                -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
                -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
                -o-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
                box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            }

            .promo-code-field:hover,
            .promo-code-field:focus {
                border: 1px solid #999;
            }

            .promo-code-cta {
                border-radius: 4px;
                font-size: 0.625rem;
                margin-left: 0.625rem;
                padding: 0.6875rem 1.25rem 0.625rem;
            }

            .basket-labels {
                border-top: 1px solid #ccc;
                border-bottom: 1px solid #ccc;
                margin-top: 1.625rem;
            }

            ul {
                list-style: none;
                margin: 0;
                padding: 0;
            }

            li {
                color: #111;
                display: inline-block;
                padding: 0.625rem 0;
            }

            li.price:before,
            li.subtotal:before {
                content: '';
            }

            .item {
                width: 55%;
            }

            .price,
            .quantity,
            .subtotal {
                width: 15%;
            }

            .subtotal {
                text-align: right;
            }

            .remove {
                bottom: 1.125rem;
                float: right;
                position: absolute;
                right: 0;
                text-align: right;
                width: 45%;
            }

            .remove button {
                background-color: transparent;
                color: #777;
                float: none;
                text-decoration: underline;
                text-transform: uppercase;
            }

            .item-heading {
                padding-left: 4.375rem;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            .basket-product {
                border-bottom: 1px solid #ccc;
                padding: 1rem 0;
                position: relative;
            }

            .product-image {
                width: 35%;
            }

            .product-details {
                width: 65%;
            }

            .product-frame {
                border: 1px solid #aaa;
            }

            .product-details {
                padding: 0 1.5rem;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            .quantity-field {
                background-color: #ccc;
                border: 1px solid #aaa;
                border-radius: 4px;
                font-size: 0.625rem;
                padding: 2px;
                width: 3.75rem;
            }

            aside {
                float: right;
                position: relative;
                width: 30%;
            }

            .summary {
                background-color: #eee;
                border: 1px solid #aaa;
                padding: 1rem;
                position: fixed;
                width: 250px;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            .summary-total-items {
                color: #666;
                font-size: 0.875rem;
                text-align: center;
            }

            .summary-subtotal,
            .summary-total {
                border-top: 1px solid #ccc;
                border-bottom: 1px solid #ccc;
                clear: both;
                margin: 1rem 0;
                overflow: hidden;
                padding: 0.5rem 0;
            }

            .subtotal-title,
            .subtotal-value,
            .total-title,
            .total-value,
            .promo-title,
            .promo-value {
                color: #111;
                float: left;
                width: 50%;
            }

            .summary-promo {
                -webkit-transition: all .3s ease;
                -moz-transition: all .3s ease;
                -o-transition: all .3s ease;
                transition: all .3s ease;
            }

            .promo-title {
                float: left;
                width: 70%;
            }

            .promo-value {
                color: #8B0000;
                float: left;
                text-align: right;
                width: 30%;
            }

            .summary-delivery {
                padding-bottom: 3rem;
            }

            .subtotal-value,
            .total-value {
                text-align: right;
            }

            .total-title {
                font-weight: bold;
                text-transform: uppercase;
            }

            .summary-checkout {
                display: block;
            }

            .checkout-cta {
                display: block;
                float: none;
                font-size: 0.75rem;
                text-align: center;
                text-transform: uppercase;
                padding: 0.625rem 0;
                width: 100%;
            }

            .summary-delivery-selection {
                background-color: #ccc;
                border: 1px solid #aaa;
                border-radius: 4px;
                display: block;
                font-size: 0.625rem;
                height: 34px;
                width: 100%;
            }

            @media screen and (max-width: 640px) {
                aside,
                .basket,
                .summary,
                .item,
                .remove {
                    width: 100%;
                }
                .basket-labels {
                    display: none;
                }
                .basket-module {
                    margin-bottom: 1rem;
                }
                .item {
                    margin-bottom: 1rem;
                }
                .product-image {
                    width: 40%;
                }
                .product-details {
                    width: 60%;
                }
                .price,
                .subtotal {
                    width: 33%;
                }
                .quantity {
                    text-align: center;
                    width: 34%;
                }
                .quantity-field {
                    float: none;
                }
                .remove {
                    bottom: 0;
                    text-align: left;
                    margin-top: 0.75rem;
                    position: relative;
                }
                .remove button {
                    padding: 0;
                }
                .summary {
                    margin-top: 1.25rem;
                    position: relative;
                }
            }

            @media screen and (min-width: 641px) and (max-width: 960px) {
                aside {
                    padding: 0 1rem 0 0;
                }
                .summary {
                    width: 28%;
                }
            }

            @media screen and (max-width: 960px) {
                main {
                    width: 100%;
                }
                .product-details {
                    padding: 0 1rem;
                }
            }

/*            body {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background-color: black;
}*/

/*.deconstructed {
  position: relative;
  margin: auto;
  height: 0.71em;
  color: transparent;
  font-family: 'Cambay', sans-serif;
  font-size: 10vw;
  font-weight: 700;
  letter-spacing: -0.02em;
  line-height: 1.03em;
}

.deconstructed > div {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  color: #ffff64;
  pointer-events: none;
}

.deconstructed > div:nth-child(1) {
  -webkit-mask-image: linear-gradient(black 25%, transparent 25%);
  mask-image: linear-gradient(black 25%, transparent 25%);
  animation: deconstructed1 5s infinite;
}

.deconstructed > div:nth-child(2) {
  -webkit-mask-image: linear-gradient(transparent 25%, black 25%, black 50%, transparent 50%);
  mask-image: linear-gradient(transparent 25%, black 25%, black 50%, transparent 50%);
  animation: deconstructed2 5s infinite;
}

.deconstructed > div:nth-child(3) {
   -webkit-mask-image: linear-gradient(transparent 50%, black 50%, black 75%, transparent 75%);
  mask-image: linear-gradient(transparent 50%, black 50%, black 75%, transparent 75%);
  animation: deconstructed3 5s infinite;
}

.deconstructed > div:nth-child(4) {
   -webkit-mask-image: linear-gradient(transparent 75%, black 75%);
  mask-image: linear-gradient(transparent 75%, black 75%);
  animation: deconstructed4 5s infinite;
}

@keyframes deconstructed1 {
  0% {
    transform: translateX(100%);
  }
  26% {
    transform: translateX(0%);
  }
  83% {
    transform: translateX(-0.1%);
  }
  100% {
    transform: translateX(-120%);
  }
}

@keyframes deconstructed2 {
  0% {
    transform: translateX(100%);
  }
  24% {
    transform: translateX(0.5%);
  }
  82% {
    transform: translateX(-0.2%);
  }
  100% {
    transform: translateX(-125%);
  }
}

@keyframes deconstructed3 {
  0% {
    transform: translateX(100%);
  }
  22% {
    transform: translateX(0%);
  }
  81% {
    transform: translateX(0%);
  }
  100% {
    transform: translateX(-130%);
  }
}

@keyframes deconstructed4 {
  0% {
    transform: translateX(100%);
  }
  20% {
    transform: translateX(0%);
  }
  80% {
    transform: translateX(0%);
  }
  100% {
    transform: translateX(-135%);
  }*/

        </style>


    </head>

    <body>
        
        <main>       
            
            <div class="basket">
                <div class="basket-module">
                    <label for="promo-code">Entre com o código Promocional</label>
                    <input id="promo-code" type="text" name="promo-code" maxlength="5" class="promo-code-field">
                    <button class="promo-code-cta">Aplicar</button>
                    
                    <a class="btn btn-success" href="index.jsp"> Página Principal</a> 
                    
                </div>
                <div class="basket-labels">
                    <ul>
                        <li class="item item-heading">Item</li>
                        <li class="price">Preço</li>
                        <li class="quantity">Quantidade</li>
                        <li class="subtotal">Subtotal</li>
                    </ul>
                </div>
                <div class="basket-product">
                    <div class="item">
                        <div class="product-image">
                             
                            <img src="img/Carrosel 1 Web 100.jpg" alt="Placholder Image 2" class="product-frame">
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">0</span> x COMIDA 01 </strong> XxXxXxX</h1>
                            <p><strong>Serve 2 pessoas</strong></p>
                            <p>Código do produto - 232321939</p>
                        </div>
                    </div>
                    <div class="price">46.00</div>
                    <div class="quantity">
                        <input type="number" value="0" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">00.00</div>
                    <div class="remove">
                        <button>Remover</button>
                    </div>
                </div>
                
                <div class="basket-product">
                    <div class="item">
                        <div class="product-image">
                             
                            <img src="img/Carrosel 0 Web 100.jpg" alt="Placholder Image 2" class="product-frame">
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">0</span> x Comida 02</strong> XxXxXxX</h1>
                            <p><strong>Serve 4 pessoas</strong></p>
                            <p>Código do produto - 232321939</p>
                        </div>
                    </div>
                    <div class="price">26.00</div>
                    <div class="quantity">
                        <input type="number" value="0" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">00.00</div>
                    <div class="remove">
                        <button>Remover</button>
                    </div>
                </div>
                
                <div class="basket-product">
                    <div class="item">
                        <div class="product-image">
                             
                            <img src="img/Carrosel 13 Web 100.jpg" alt="Placholder Image 2" class="product-frame">
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">0</span> x Comida 03</strong> XxXxXxX</h1>
                            <p><strong>Server 3 pessoas</strong></p>
                            <p>Código do produto - 232321939</p>
                        </div>
                    </div>
                    <div class="price">26.00</div>
                    <div class="quantity">
                        <input type="number" value="0" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">00.00</div>
                    <div class="remove">
                        <button>Remover</button>
                    </div>
                </div>
                
                <div class="basket-product">
                    <div class="item">
                        <div class="product-image">
                             
                            <img src="img/Carrosel 14 Web 100.jpg" alt="Placholder Image 2" class="product-frame">
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">0</span> x Comida 04</strong> XxXxXxX</h1>
                            <p><strong>Serve 06 pessoas</strong></p>
                            <p>Código do produto - 232321939</p>
                        </div>
                    </div>
                    <div class="price">85.00</div>
                    <div class="quantity">
                        <input type="number" value="0" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">00.00</div>
                    <div class="remove">
                        <button>Remover</button>
                    </div>
                </div>
                
                <div class="basket-product">
                    <div class="item">
                        <div class="product-image">
                             
                            <img src="img/Carrosel 4 Web 100.jpg" alt="Placholder Image 2" class="product-frame">
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">0</span> x Comida 05</strong>XxXxXxX</h1>
                            <p><strong>Serve 10 pessoas</strong></p>
                            <p>Código do produto - 232321939</p>
                        </div>
                    </div>
                    <div class="price">140.00</div>
                    <div class="quantity">
                        <input type="number" value="0" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">00.00</div>
                    <div class="remove">
                        <button>Remover</button>
                    </div>
                </div>
                
                <div class="basket-product">
                    <div class="item">
                        
                        <div class="product-image">
                            <img src="img/Carrosel 17 Web 100.jpg" alt="Placholder Image 2" class="product-frame">
<!--                            <img src="http://placehold.it/120x166" alt="Placholder Image 2" class="product-frame">-->
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">0</span> x Comida 06</strong> XxXxXxX</h1>
                            <p><strong>Serve 02 pessoas</strong></p>
                            <p>Código do produto - 232321939</p>
                        </div>
                    </div>
                    <div class="price">26.00</div>
                    <div class="quantity">
                        <input type="number" value="0" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">00.00</div>
                    <div class="remove">
                        <button>Remover</button>
                    </div>
                </div>
                
                <div class="basket-product">
                    <div class="item">
                        <div class="product-image">
                             
                            <img src="img/Carrosel 3 Web 100.jpg" alt="Placholder Image 2" class="product-frame">
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">0</span> x Comida 07</strong> XxXxXxX</h1>
                            <p><strong>Serve 02 pessoas</strong></p>
                            <p>Código do produto - 232321939</p>
                        </div>
                    </div>
                    <div class="price">44.00</div>
                    <div class="quantity">
                        <input type="number" value="0" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">00.00</div>
                    <div class="remove">
                        <button>Remover</button>
                    </div>
                </div>
            </div>
            
            
            
            <aside>
                <div class="summary">
                    <div class="summary-total-items"><span class="total-items"></span> Itens em sua bolsa</div>
                    <div class="summary-subtotal">
                        <div class="subtotal-title">Subtotal</div>
                        <div class="subtotal-value final-value" id="basket-subtotal">00.00</div>
                        <div class="summary-promo hide">
                            <div class="promo-title">Promoção</div>
                            <div class="promo-value final-value" id="basket-promo"></div>
                        </div>
                    </div>
                    <div class="summary-delivery">
                        <select name="delivery-collection" class="summary-delivery-selection">
                            <option value="0" selected="selected">Selecionar retirada ou entrega</option>
                            <option value="collection">Collection</option>
                            <option value="first-class">Royal Mail 1st Class</option>
                            <option value="second-class">Royal Mail 2nd Class</option>
                            <option value="signed-for">Royal Mail Special Delivery</option>
                        </select>
                    </div>
                    <div class="summary-total">
                        <div class="total-title">Total</div>
                        <div class="total-value final-value" id="basket-total">00.00</div>
                    </div>
                    <div class="summary-checkout">
                        <button class="checkout-cta">Finalizar Carrinho</button>
                    </div>
                    <br>
<!--                    <a class="btn btn-success" href="index.jsp"> Página Principal</a> -->
<!--                    <button type="submit" class="btn btn-success" > Página Principal</button>-->
                    <a class="btn btn-primary" href="agradecimento.jsp"> Página Principal</a>
                  
                </div>
                
                
            </aside>
        </main>

        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script type="text/javascript">
            /* 
             * To change this license header, choose License Headers in Project Properties.
             * To change this template file, choose Tools | Templates
             * and open the template in the editor.
             */


            /* Set values + misc */
            var promoCode;
            var promoPrice;
            var fadeTime = 300;

            /* Assign actions */
            $('.quantity input').change(function () {
                updateQuantity(this);
            });

            $('.remove button').click(function () {
                removeItem(this);
            });

            $(document).ready(function () {
                updateSumItems();
            });

            $('.promo-code-cta').click(function () {

                promoCode = $('#promo-code').val();

                if (promoCode == '10off' || promoCode == '10OFF') {
                    //If promoPrice has no value, set it as 10 for the 10OFF promocode
                    if (!promoPrice) {
                        promoPrice = 10;
                    } else if (promoCode) {
                        promoPrice = promoPrice * 1;
                    }
                } else if (promoCode != '') {
                    alert("Invalid Promo Code");
                    promoPrice = 0;
                }
                //If there is a promoPrice that has been set (it means there is a valid promoCode input) show promo
                if (promoPrice) {
                    $('.summary-promo').removeClass('hide');
                    $('.promo-value').text(promoPrice.toFixed(2));
                    recalculateCart(true);
                }
            });

            /* Recalculate cart */
            function recalculateCart(onlyTotal) {
                var subtotal = 0;

                /* Sum up row totals */
                $('.basket-product').each(function () {
                    subtotal += parseFloat($(this).children('.subtotal').text());
                });

                /* Calculate totals */
                var total = subtotal;

                //If there is a valid promoCode, and subtotal < 10 subtract from total
                var promoPrice = parseFloat($('.promo-value').text());
                if (promoPrice) {
                    if (subtotal >= 10) {
                        total -= promoPrice;
                    } else {
                        alert('Order must be more than £10 for Promo code to apply.');
                        $('.summary-promo').addClass('hide');
                    }
                }

                /*If switch for update only total, update only total display*/
                if (onlyTotal) {
                    /* Update total display */
                    $('.total-value').fadeOut(fadeTime, function () {
                        $('#basket-total').html(total.toFixed(2));
                        $('.total-value').fadeIn(fadeTime);
                    });
                } else {
                    /* Update summary display. */
                    $('.final-value').fadeOut(fadeTime, function () {
                        $('#basket-subtotal').html(subtotal.toFixed(2));
                        $('#basket-total').html(total.toFixed(2));
                        if (total == 0) {
                            $('.checkout-cta').fadeOut(fadeTime);
                        } else {
                            $('.checkout-cta').fadeIn(fadeTime);
                        }
                        $('.final-value').fadeIn(fadeTime);
                    });
                }
            }

            /* Update quantity */
            function updateQuantity(quantityInput) {
                /* Calculate line price */
                var productRow = $(quantityInput).parent().parent();
                var price = parseFloat(productRow.children('.price').text());
                var quantity = $(quantityInput).val();
                var linePrice = price * quantity;

                /* Update line price display and recalc cart totals */
                productRow.children('.subtotal').each(function () {
                    $(this).fadeOut(fadeTime, function () {
                        $(this).text(linePrice.toFixed(2));
                        recalculateCart();
                        $(this).fadeIn(fadeTime);
                    });
                });

                productRow.find('.item-quantity').text(quantity);
                updateSumItems();
            }

            function updateSumItems() {
                var sumItems = 0;
                $('.quantity input').each(function () {
                    sumItems += parseInt($(this).val());
                });
                $('.total-items').text(sumItems);
            }

            /* Remove item from cart */
            function removeItem(removeButton) {
                /* Remove row from DOM and recalc cart total */
                var productRow = $(removeButton).parent().parent();
                productRow.slideUp(fadeTime, function () {
                    productRow.remove();
                    recalculateCart();
                    updateSumItems();
                });
            }
        </script>
    </body>
    <br>
</html>
