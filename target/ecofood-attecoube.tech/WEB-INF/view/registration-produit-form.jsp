<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head
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

        <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/boutique.css" />

    </head>

    <body>

        <div class="container">
            <header class="blog-header py-3">
                <div class="row flex-nowrap justify-content-between align-items-center">
                    <div class="col-4 pt-1">
                        <a class="blog-header-logo text-dark" href="${pageContext.request.contextPath}/" style="font-size: 15px" >Attecoube.net::.. Tout au sujet de notre commune!</a>

                    </div>
                   
                                <div class="col-4 d-flex justify-content-end align-items-center">
                                    <a class="text-muted" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24" focusable="false"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>
                                    </a>

                                    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/produit/formulaireCreationProduit">Ajout produit</a>
                                </div>
                                </div>
                                </header>



                                <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark" >
                                    <div class="col-md-6 px-0">
                                        <h1 class="display-4 font-italic">ÉcoFood</h1>
                                        <p class="lead my-3">Désormais, vous avez la possibilité  de faire des économies sur l'achat de vos produits périssables.</p>

                                    </div>
                                </div>

                                
                                 <!--  Display form to save a new produit and details boutique  -->
                                
                                 <div class="row mb-2" >
                                     
                                     <!-- Begin display formaulaire to save produit -->
                                     <div class="col-md-8" >
                                         
                                         <form:form action="${pageContext.request.contextPath}/produit/saveProduit" 
                                               modelAttribute="produit" method="POST"
                                               cssClass="">
                                        <form:hidden path="id" />
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Nom produit:</label>
                                                    <div class="col-sm-10">
                                                        <form:input path="produit_nom" cssClass="form-control" />
                                                    </div>
                                                </div>
                                                                                     
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Type Produit:</label>
                                                    <div class="col-sm-10">
                                                        <form:input path="produit_type" cssClass="form-control" />
                                                    </div>
                                                </div>
                                                
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Quantite:</label>
                                                    <div class="col-sm-10">
                                                        <form:input path="produit_quantite" cssClass="form-control" />
                                                    </div>
                                                </div>
                                                
                                                    
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Date Peremption:</label>
                                                    <div class="col-sm-10" >
                                                        <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                                                            <form:input path="produit_date_peremption"  cssClass="form-control"  
                                                                                class="form-control datetimepicker-input" data-target="#datetimepicker1" />
                                                            <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                                                                <div class="input-group-text"><i class="icon fa-twitter"></i></div>
                                                            </div>
                                                            <script type="text/javascript">
                                                              $(function () {
                                                              $('#datetimepicker1').datetimepicker();
                                                              });
                                                            </script>
                                                        </div>

                                                    </div>
                                                </div>
                                               
                                                    
                                                    
                                                  

                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Prix normal:</label>
                                                    <div class="col-sm-10" >
                                                        <form:input path="produit_prix_normal" cssClass="form-control" />
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Prix promotion:</label>
                                                    <div class="col-sm-10">
                                                        <form:input path="produit_prix_promotion" cssClass="form-control" />
                                                    </div>
                                                </div>
                                                
                                              
                                                <form:hidden  path="produit_vendeur" cssClass="form-control"  value="${user.userName}" />
                                                <form:hidden  path="produit_vendeur_telephone" cssClass="form-control" value="${user.telephone_boutique}" />                                              
                                                <form:hidden  path="produit_vendeur_quartier" cssClass="form-control" value="${user.quartier_boutique}"/>
                                             

                                                <button type="submit" class="btn btn-sm btn-outline-secondary" >Enregistrer produit</button>
                                        
                                          </form:form>    
                                    
                                     </div><!-- End display formaulaire to save produit -->
                                     
                                     
                                     
                                     
                                      <!-- Begin display details Boutique -->
                                     <div class="col-md-4" >
                                         
                                          <div class="card" style="width: 18rem;" >
                                                <img src="https://cnlvc.ci/wp-content/uploads/2018/06/boutique-paysanne.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <strong class="d-inline-block mb-2 text-success">${user.nom_proprietaire_boutique}</strong>
                                                    <h6 class="mb-0">Quartier: ${user.quartier_boutique}</h6>
                                                    <div class="mb-1 text-muted">Cel: ${user.telephone_boutique}</div>
                                                        <form:form action="${pageContext.request.contextPath}/logout" 
                                                                       method="POST">
                                                            <input class="btn btn-secondary" type="submit" value="Deconnexion" />
                                                        </form:form>
                                                </div>
                                         </div>
                                     </div><!-- End display details Boutique -->
                                     
                                 </div> <!-- End row mb-2 -->
                                
                                                           
                   
            </div>    
                 
              <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
              <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
    </body>

</html>

