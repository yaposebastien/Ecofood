<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="Attecoube.net" content="ÉcoFood, Désormais, vous avez la possibilité de faire des économies sur l'achat de vos produits périssables">
        <meta name="generator" content="Jekyll v3.8.5">
        <title>ÉcoFood::.. Boutique en ligne pour la promotion de produits périssable</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />

        <!-- Bootstrap core CSS -->
        <link type="text/css"
              href="${pageContext.request.contextPath}/resources/css/boutique.css"
              rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous" />

        <!-- Bootstrap core CSS -->
        <link type="text/css"
              href="${pageContext.request.contextPath}/resources/css/boutique.css"
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
                </div>
            </header>


            <!-- Jumbotron Bootstrap -->
            <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark" >
                <div class="col-md-6 px-0">
                    <h1 class="display-4 font-italic">ÉcoFood</h1>
                    <p class="lead my-3">Désormais, vous avez la possibilité  de faire des économies sur l'achat de vos produits périssables.</p>

                </div>
            </div>

            <!--  Adding Search box to load owner's produit and Create New Produit -->
            <div >
                
                <!--  add a search box -->
                <form:form action="search" method="POST">

                    <input type="submit" value="Voir vos produits" class="btn btn-sm btn-outline-secondary" />
                    <input type="hidden" name="theSearchName" value="${user.userName}"/>
                    
                    <!-- Adding Button to Create New Produit -->
                    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/produit/formulaireCreationProduit">Ajout produit</a>

                </form:form>
                
            </div>
            
            


            <div class="row mb-2">
                <!-- Table to display the liste of Produits  -->
                <div class="col-md-8"  >
                    <table class="table table-hover">
                        <tr>
                            <th>Produit</th>
                            <th>Qte</th>
                            <th>Peremption</th>
                            <th>Vendeur</th>
                            <th>Contact</th>
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


                               
                                     <!-- This condition helps only the connected user to delete his own produit. -->
                                     <c:set var = "userConnected" scope = "session" value = "${user.userName}"/>
                                     <c:set var = "nameVendeurProduit" scope = "session" value = "${tempProd.produit_vendeur}"/>
                                     <c:if test = "${userConnected == nameVendeurProduit}">
                                            
                                            
                                    <td> ${tempProd.produit_nom}</td>                   
                                    <td> ${tempProd.produit_quantite}</td>
                                    <td> ${tempProd.produit_date_peremption}</td>
                                    <td> ${tempProd.produit_vendeur}</td>
                                    <td> ${tempProd.produit_vendeur_telephone}</td>

                                    <td> 

                                        
                                        <a href="${deleteLink}"
                                           onclick="if (!(confirm('Voulez-vous supprimer ce produit ${tempProd.produit_nom} ?')))
                                                       return false" >Supprimer</a>  

                                    </c:if>


                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>    



                <div class="col-md-4">
                    <div class="card" style="width: 18rem;" >
                        <img src="https://cnlvc.ci/wp-content/uploads/2018/06/boutique-paysanne.jpg" class="card-img-top" alt="...">

                        <div class="card-body">
                            <strong class="d-inline-block mb-2 text-success">Votre Fiche boutique</strong>
                            <br>

                            <h7 class="mb-0"><strong>Boutique: </strong>${user.userName}</h7>
                            <br>
                            <h7 class="mb-0"><strong>Proprietaire: </strong>${user.nom_proprietaire_boutique}</h7>
                            <br>
                            <h7 class="mb-0"><strong>Quartier: </strong>${user.quartier_boutique}</h7>
                            <br>
                            <h7 class="mb-0"><strong>Telephone: </strong>${user.telephone_boutique}</h7>
                            <br>
                            <h7 class="mb-0"><strong>Email: </strong>${user.email_boutique}</h7>
                            <br>
                            <br>

                            <form:form action="${pageContext.request.contextPath}/logout" 
                                       method="POST">
                                <center><input class="btn-sm btn-danger" type="submit" value="Deconnexion" /></center>
                                </form:form>
                        </div>
                    </div>
                </div>
            </div>



        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
