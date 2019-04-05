<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="Attecoube.net" content="ÉcoFood, Désormais, vous avez la possibilité de faire des économies sur l'achat de vos produits périssables">
        <meta name="generator" content="Jekyll v3.8.5">
        <title>ÉcoFood :::... Votre boutique en ligne des produits périssable</title>

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

            <!-- Caroussel -->
            <div class="bd-example" >
                <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                        <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fi.huffpost.com%2Fgen%2F1924836%2Fimages%2Fo-BIOGAS-FOOD-WASTE-facebook.jpg&f=1" class="d-block w-100" alt="..." style="height:300px">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Désormais, vous avez la possibilité  de faire des économies sur l'achat de vos produits périssables.</h5>
                                <div>
                                    <a href="${pageContext.request.contextPath}/boutique/formulaireCreationBoutique" class="btn btn-primary" role="button" aria-pressed="true">Créer gratuitement votre boutique virtuelle maintenant!</a>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia4.s-nbcnews.com%2Fj%2Fnewscms%2F2017_49%2F2250466%2F171205-food-waste-compost-ac-421p_77851c253c01aa3afddce30c1f631583.1200%3B630%3B7%3B70%3B5.jpg&f=1" class="d-block w-100" alt="..." style="height:300px">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Second slide label</h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fi.huffpost.com%2Fgen%2F1924836%2Fimages%2Fo-BIOGAS-FOOD-WASTE-facebook.jpg&f=1" class="d-block w-100" alt="..." style="height:300px">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Third slide label</h5>
                                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <!-- End Carousel -->


            
            <!--  add a search box by Produit Quartier -->
            <div>
                <form:form action="searchProduit" method="POST">

                    <input type="text" name="theSearchName" placeholder="Nom produit, Type ou Quartier." />

                    <input type="submit" value="Rechercher" class="btn btn-sm btn-outline-secondary" />
                    <br>


                </form:form>
            </div>  

            <!--  adding Box for newsletter-->
            <div>

            </div>





            <!-- Table to display the liste of Produits  -->
            <div class="row mb-2"  >
                <table class="table table-hover">
                    <tr>
                        <th>Produit</th>
                        <th>Type</th>
                        <th>Quantite</th>
                        <th>Date Peremption</th>
                        <th>Vendeur</th>
                        <th>Contact</th>
                        <th>Quartier</th>
                        <th>Action</th>


                    </tr>
                    <!-- Boucle pour afficher Produits -->
                    <!-- Code pour afficher un Produit a modifier -->
                    <c:forEach var="tempProd" items="${produits}">

                        <!-- Debut du code du formulaire de mise a jour -->
                        <c:url var="updateLink" value="/produit/showFormForUpdate">
                            <c:param name="produitId" value="${tempProd.id}" />
                        </c:url>

                        <!-- Debut du code du formulaire pour la suppression -->
                        <c:url var="deleteLink" value="/produit/delete">
                            <c:param name="produitId" value="${tempProd.id}" />
                        </c:url>
                        <tr>
                            <td> ${tempProd.produit_nom}</td>
                            <td> ${tempProd.produit_type}</td>
                            <td> ${tempProd.produit_quantite}</td>
                            <td id="date_peremption"> ${tempProd.produit_date_peremption}</td>
                            <td> ${tempProd.produit_vendeur}</td>
                            <td> ${tempProd.produit_vendeur_telephone}</td>
                            <td> ${tempProd.produit_vendeur_quartier}</td>
                            <td> 
                                <a class="btn btn-sm btn-outline-secondary" href="#">Commander</a> 
                            </td>



                        </tr>

                    </c:forEach>
                </table>



            </div>    




    </body>
</html>