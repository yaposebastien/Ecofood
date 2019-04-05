<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  



<!doctype html>
<html lang="en">

    <head>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="Attecoube.net" content="ÉcoFood, Désormais, vous avez la possibilité de faire des économies sur l'achat de vos produits périssables">
        <meta name="generator" content="Jekyll v3.8.5">
        <title>ÉcoFood::.. Boutique en ligne de produits périssable</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />

        <!-- Bootstrap core CSS -->
        <link type="text/css"
              href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous" />


        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


    </head>

    <body>

        <div class="container">
            <header class="blog-header py-3">
                <div class="row flex-nowrap justify-content-between align-items-center">
                    <div class="col-4 pt-1">
                        <a class="blog-header-logo text-dark" href="${pageContext.request.contextPath}/" style="font-size: 15px" >Attecoube.net::.. Tout au sujet de notre commune!</a>
                    </div>
                    <div class="col-4 d-flex justify-content-end align-items-center">


                        <form action="${pageContext.request.contextPath}/authenticateTheUser" 
                              method="POST" class="form-horizontal">
                            <div>
                                <!-- Check for login error -->
                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        Votre nom utilisateur ou mot de passe est invalide!
                                    </div>
                                </c:if>

                                <!-- Check for logout -->

                                <c:if test="${param.logout != null}">

                                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                        Vous etes maintenant deconnectes.
                                    </div>

                                </c:if>

                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <input type="text" name="username"  class="form-control" placeholder="Nom utilisateur" width="15px" style="font-size: 14px">
                                </div>
                                <div class="col">
                                    <input type="password" name="password"  class="form-control" placeholder="Mot de passe" style="font-size: 14px" width="15px">
                                </div>

                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                                <button type="submit" class="btn btn-outline-success btn-sm">Connecter</button>

                            </div>
                        </form>
                    </div>
                </div>
            </header>

            <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark" >
                <div class="col-md-6 px-0">
                    <h1 class="display-4 font-italic">ÉcoFood</h1>
                    <p class="lead my-3">Désormais, vous avez la possibilité  de faire des économies sur l'achat de vos produits périssables.</p>
                    <div>
                        <a href="${pageContext.request.contextPath}/boutique/formulaireCreationBoutique" class="btn btn-primary" role="button" aria-pressed="true">Créer gratuitement votre boutique virtuelle maintenant!</a>
                    </div>
                </div>
            </div>


            <div>

                <div class="panel panel-primary">

                    <div class="panel-heading">
                        <div class="panel-title">Enregistrer votre boutique</div>
                    </div>

                    <div  class="panel-body">

                        <!-- Registration Form -->
                        <form:form action="${pageContext.request.contextPath}/boutique/processRegistrationForm" 
                                   modelAttribute="crmUser"
                                   class="form-horizontal">

                            <!-- Place for messages: error, alert etc ... -->
                            <div class="form-group">
                                <div class="col-xs-15">
                                    <div>

                                        <!-- Check for registration error -->
                                        <c:if test="${registrationError != null}">

                                            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                                ${registrationError}
                                            </div>

                                        </c:if>

                                    </div>
                                </div>
                            </div>







                            <!-- User name -->
                            <div class="form-group row">
                                <label for="username" class="col-sm-2 col-form-label">Nom utilisateur(*) </label>
                                <div class="col-sm-6">
                                    <form:errors path="userName" cssClass="error" />
                                    <form:input path="userName" placeholder="Nom utilisateur (*)" class="form-control" />
                                </div>
                            </div>

                            <!-- Password -->
                            <div class="form-group row">
                                <label for="motdepasse" class="col-sm-2 col-form-label">Mot de passe(*) </label>
                                <div class="col-sm-6"> 
                                    <form:errors path="password" cssClass="error" />
                                    <form:password path="password" placeholder="mot de passe (*)" class="form-control" />
                                </div>
                            </div>

                            <!-- Confirm Password -->
                            <div class="form-group row">
                                <label for="confirmermotdepasse" class="col-sm-2 col-form-label">Confirmez Mot de passe(*) </label>
                                <div class="col-sm-6"> 
                                    <form:errors path="matchingPassword" cssClass="error" />
                                    <form:password path="matchingPassword" placeholder="confirmez votre mot de passe (*)" class="form-control" />
                                </div>
                            </div>


                            <!-- Nom Boutique -->
                            <div class="form-group row">
                                <label for="nomboutique" class="col-sm-2 col-form-label">Nom de votre boutique(*) </label>
                                <div class="col-sm-6"> 
                                    <form:errors path="nom_boutique" cssClass="error" />
                                    <form:input path="nom_boutique" placeholder="Saisir le nom de votre boutique (*)" class="form-control" />
                                </div>
                            </div>

                            <!-- Nom du proprietaire de la Boutique -->
                            <div class="form-group row">
                                <label for="nomproprietaire" class="col-sm-2 col-form-label">Nom du proprietaire  </label>
                                <div class="col-sm-6"> 
                                    <form:errors path="nom_proprietaire_boutique" cssClass="error" />
                                    <form:input path="nom_proprietaire_boutique" placeholder="Saisir le nom du proprietaire (*)" class="form-control" />
                                </div>
                            </div>

                            <!-- Telephone de la boutique -->
                            <div class="form-group row">
                                <label for="telephone" class="col-sm-2 col-form-label">Telephone mobile(*)  </label>
                                <div class="col-sm-6"> 
                                    <form:errors path="telephone_boutique" cssClass="error" />
                                    <form:input path="telephone_boutique" placeholder="telephone (*)" class="form-control" />
                                </div>
                            </div>

                            <!-- Email -->
                            <div class="form-group row">
                                <label for="email" class="col-sm-2 col-form-label">Email(*)  </label>
                                <div class="col-sm-6"> 
                                    <form:errors path="email_boutique" cssClass="error" />
                                    <form:input path="email_boutique" placeholder="email (*)" class="form-control" />
                                </div>
                            </div>



                            <!-- Quartier -->



                            <div class="form-group row">
                                <label for="email" class="col-sm-2 col-form-label">Quartier(*)  </label>
                                <div class="col-sm-6"> 
                                    <form:errors path="quartier_boutique" cssClass="error" />
                                    <form:select path="quartier_boutique" placeholder="quartier (*)" class="form-control" >
                                        <form:option value="Choisir" label="Choisir..."/>  
                                        <form:option value="Rive droite" label="Rive droite"/>
                                        <form:option value="Agban Attié" label="1- Agban Attié"/>  
                                        <form:option value="Attécoubé 3" label="2- Attécoubé 3"/>  
                                        <form:option value="Djéné Ecaré" label="3- Djéné Ecaré"/>  
                                        <form:option value="Santé Ecole" label="4- Santé Ecole"/>  
                                        <form:option value="Santé 3 Résidentiel 1" label="5- Santé 3 Résidentiel 1"/>  
                                        <form:option value="Santé 3 Résidentiel 2" label="6- Santé 3 Résidentiel 2"/>  
                                        <form:option value="Santé 3 Extension" label="7- Santé 3 Extension"/>  
                                        <form:option value="Fromager" label="8- Fromager"/>  
                                        <form:option value="Déindé" label="9- Déindé"/>  
                                        <form:option value="Asapsu" label="10- Asapsu"/>  
                                        <form:option value="Awa" label="11. Awa"/>  
                                        <form:option value="Jean-Paul 2" label="12. Jean-Paul 2"/>  
                                        <form:option value="Santé Carrefour" label="13. Santé Carrefour"/>  
                                        <form:option value="Akélié" label="14. Akélié"/>  
                                        <form:option value="Lackman" label="15. Lackman"/>  
                                        <form:option value="Douagoville" label="16.Douagoville"/>  
                                        <form:option value="Camp Douane" label="17. Camp Douane"/>  
                                        <form:option value="Jérusalem Résidentiel" label="18. Jérusalem Résidentiel"/>  
                                        <form:option value="Jérusalem 1" label="19. Jérusalem 1"/> 
                                        <form:option value="Akélié" label="14. Akélié"/>  
                                        <form:option value="Lackman" label="15. Lackman"/>  
                                        <form:option value="Douagoville" label="16.Douagoville"/>  
                                        <form:option value="Camp Douane" label="17. Camp Douane"/>  
                                        <form:option value="Jérusalem 2" label="20. Jérusalem 2"/>  
                                        <form:option value="Jérusalem 3" label="21. Jérusalem 3"/>
                                        <form:option value="Rive gauche" label="Rive droite"/>
                                        <form:option value="Sebroko" label="1- Sebroko"/>  
                                        <form:option value="La Paix" label="2- La Paix"/>  
                                        <form:option value="Lagune" label="3- Lagune"/>  
                                        <form:option value="Espoir" label="4- Espoir"/>  
                                        <form:option value="Mosquée" label="5- Mosquée"/>  
                                        <form:option value="Saint-Joseph" label="6- Saint-Joseph"/>  
                                        <form:option value="Ecole" label="7- Ecole"/>  
                                        <form:option value="Gbebouto" label="8- Gbebouto"/>  
                                        <form:option value="Cantonnement Forestier" label="9- Cantonnement Forestier"/>  
                                        <form:option value="Cité Fairmont 1" label="10- Cité Fairmont 1"/>  
                                        <form:option value="Cité Fairmont 2" label="11- Cité Fairmont 2"/>  
                                        <form:option value="Ecole Forestière" label="12-Ecole Forestière"/>  
                                        <form:option value="Bidjanté " label="13-Bidjanté "/>  
                                    </form:select> 

                                </div>
                            </div>


                            <!-- Register Button -->
                            <div style="margin-top: 10px" class="form-group">						
                                <div class="col-sm-6 controls">
                                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                                </div>
                            </div>

                        </form:form>

                    </div>

                </div>

            </div>



        </div>

    </body>
</html>