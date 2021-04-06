<!--Fale Conosco-->
<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
        <div class="fale-conosco" id="fale-conosco">
            <div class="container center">
                <h4 class="card-title">Nosso Canal para Dúvidas, Informações e Promoções.</h4>
                <br><br>
                <div class="row">
                    <div class="col s6 formulario">
                        <f:form class="col s12" method="POST" action="${s:mvcUrl('contatoViaSite').build() }"
                            modelAttribute="contatoSiteForm">
                            <div class="row">

                                <div class="input-field col s12">
                                    <input id="nome" name="nome" type="text" class="validate">
                                    <label for="nome">Nome</label>
                                </div>

                                <div class="input-field col s12">
                                    <input id="email" name="email" type="text" class="validate">
                                    <label for="email">E-mail</label>
                                </div>

                                <div class="input-field col s12">
                                    <input id="assunto" name="assunto" type="text" class="validate">
                                    <label for="assunto">Assunto</label>
                                </div>


                                <div class="input-field col s12">
                                    <textarea id="mensagem" name="mensagem" class="materialize-textarea"></textarea>
                                    <label for="mensagem">Mensagem</label>
                                </div>


                                <div class="input-field col s12">
                                    <input type="submit" value="Enviar" class="left btn botao">
                                </div>
                            </div>
                        </f:form>
                    </div>

                    <div class="col s6">
                        <h5>Rede Sociais</h5>
                        <ul>
                            <li class="linkRedesSociais"><a href="https://www.instagram.com" target="_blank"><img src="img/insta.png" width="40"><span class="spanLinkRedesSociais">Instagram</span>  </a> </li>
                            <li class="linkRedesSociais"><a href="https://www.twiter.com" target="_blank"><img src="img/twiter.png" width="40"><span class="spanLinkRedesSociais">Twiter</span></a></li>
                            <li class="linkRedesSociais"><a href="https://www.facebook.com" target="_blank"><img src="img/face.png" width="40"><span class="spanLinkRedesSociais">Facebook</span> </a></li>
                            <li class="linkRedesSociais"><a href="https://www.linkedin.com" target="_blank"><img src="img/linkedin.png" width="40"><span class="spanLinkRedesSociais">Linkedin</span>  </a></li>
                        </ul><br><br>
                    </div>
                    <div>
                        <h5>Endereço</h5>
                        <h6>
                            Av. Ramiro Colleoni, 151 - Centro,<br> Santo André 
                             SP, CEP: 09040-160
                        </h6>
                    </div>
                </div>
            </div>
        </div>