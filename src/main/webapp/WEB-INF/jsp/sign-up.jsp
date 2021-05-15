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
        <title>Evergreen - Inscription</title>
    </head>

    <body id="sign-up-body">
        <div id="sign-up-row-1">
            <div>
                <a href="login"><p class="back"><img src="assets/icon/arrow-left.svg" alt="back-icon" width="16px" /> Retour</p></a>
            </div>
        </div>

        <div id="sign-up-row-2">
            <div>
                <img src="assets/logo/evegreen-logo-site.svg" alt="logo-evergreen" width="50px" />
                <h2>Créer votre compte</h2>
                <form id="sign-up-form" action="addUser" method="POST">
                    <input type="text" name="lastname" id="sign-up-form-nom" placeholder="Nom" required>
                    <input type="text" name="firstname" id="sign-up-form-prénom" placeholder="Prénom" required>
                    <input type="text" name="email" id="sign-up-form-mail" placeholder="Adresse mail" required>
                    <input type="password" name="password" id="sign-up-form-password" placeholder="Mot de passe" required>
                    <input type="password" name="password-confirmation" id="sign-up-form-password-confirmation" placeholder="Confirmation du mot de passe" required>
                    <span id = "sign-up-form-birthdate-bloc">
                                <label for="sign-up-form-birthdate">Date de naissance</label><br/>
                                <input type="date" id="sign-up-form-birthdate" name="birthdate" max="2018-12-31" required>
                            </span>
                    <p><input type="checkbox" id="sign-up-form-terms" name="conditionsutilisation" required>J'accepte les conditions d'utilisation</p>

                    <input type="submit" value="Je m'inscris" class="green-button"/>

                </form>
            </div>
        </div>

        <div id="sign-up-row-3">
            <div>
                <a href="#">À propos</a>
                ・
                <a href="#">Conditions d'utilisation</a>
                ・
                <a href="#">Politique de confidentialité</a>
                ・
                <a href="contact-us">Nous contacter</a>
            </div>
        </div>
    </body>
</html>