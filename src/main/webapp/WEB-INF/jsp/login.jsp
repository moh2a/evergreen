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
        <title>Evergreen - Accueil</title>
    </head>
    <body id = "homepage-body">
        <div id="guest-homepage-row-1">
            <div>
                <h2>Déjà un compte ? Bon retour parmi nous !</h2>
                <form id="login-form" action="#">
                        <span class="login-form-input-container">
                            <input type="text" name="mail" id="login-form-mail" placeholder="Adresse mail" required>
                        </span>
                    <span class="login-form-input-container">
                            <input type="password" name="mot_de_passe" id="login-form-mdp" placeholder="Mot de passe" required><br>
                            <p id="login-form-password-forgotten">Mot de passe oublié ?</p>
                        </span>
                    <span class="login-form-input-container">
                            <input type="submit" value="Se connecter" class="green-button"/>
                        </span>
                </form>
            </div>
        </div>

        <div id="guest-homepage-row-2">
            <div>
                <img src="assets/logo/evegreen-logo-site.svg" alt="logo-evergreen" width="50px" />
                <h1>Pas encore de compte ?</h1>
                <h2>Rejoignez Evergreen dès aujourd'hui</h2>
                <a href="sign-up"><button class=green-button>Je m'inscris</button></a>
        </div>
        </div>

        <div id="guest-homepage-row-3">
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