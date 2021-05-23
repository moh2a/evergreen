<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/loginSignUpContact.css">
        <script type="text/javascript" src="javascript/contact.js" async></script>
        <title>Evergreen - Nous contacter</title>
    </head>
    <body id="contact-body">
        <c:if test="${confirmation}">
            <script async>
                window.alert("${confirmationMessage}");
            </script>
        </c:if>

        <div id="contact-row-1">
            <div>
                <a href="login"><p class="back"><img src="assets/icon/arrow-left.svg" alt="back-icon" width="16px" /> Retour</p></a>
            </div>
        </div>

        <div id="contact-row-2">
            <div>
                <img src="assets/logo/evegreen-logo-site.svg" alt="logo-evergreen" width="50px" />
                <h2>Nous contacter</h2>
                <form id="contact-form" action="send-email" method="POST">
                    <input type="text" name="lastname" id="contact-form-nom" placeholder="Nom" required>
                    <input type="text" name="firstname" id="contact-form-prénom" placeholder="Prénom" required>
                    <input type="text" name="email" id="contact-form-mail" placeholder="Adresse mail" required>
                    <textarea name="message" id="contact-form-message" placeholder="Message"></textarea>

                    <input type="submit" value="Envoyer le message" id="submit-button" class="green-button"/>

                </form>
            </div>
        </div>

        <div id="contact-row-3">
            <div>
                <a href="#">À propos</a>
                ・
                <a href="#">Conditions d'utilisation</a>
                ・
                <a href="#">Politique de confidentialité</a>
                ・
                <a href="contact">Nous contacter</a>
            </div>
        </div>
    </body>
</html>