let submitButton = document.getElementById("submit-button");
submitButton.addEventListener("click", validateForm);

function validateForm(event) {
    let lastName = document.getElementById("sign-up-form-nom");
    let firstName = document.getElementById("sign-up-form-prénom");
    let email = document.getElementById("sign-up-form-mail");
    let password = document.getElementById("sign-up-form-password");
    let passwordConfirmation = document.getElementById("sign-up-form-password-confirmation");
    let birthdate = document.getElementById("sign-up-form-birthdate");
    let terms = document.getElementById("sign-up-form-terms");

    if (firstName.value === "" || lastName.value === "" || email.value === "" || password.value === "" || passwordConfirmation.value === "" || birthdate.value === "") {
        alert("Merci de remplir tous les champs");
        event.preventDefault();
    }

    else {
        if (!terms.checked) {
            alert("Merci d'accepter les conditions d'utilisation");
        }

        else {
            let missingFields = "Des erreurs sont présentes : ";
            let count = 0;

            if (!checkEmail(email)) {
                missingFields += "\n\t- L'adresse mail n'a pas le bon format";
                count += 1;
            }

            if (!checkPassword(password, passwordConfirmation)) {
                missingFields += "\n\t- Les mots de passe ne correspondent pas";
                count += 1;
            }

            if (!checkBirthdate(birthdate.value)) {
                missingFields += "\n\t- Vous n'avez pas l'âge requis pour vous inscrire";
                count += 1;
            }

            if (count !== 0) {
                alert(missingFields);
                event.preventDefault();
            }
        }
    }
}

function checkEmail(email) {
    let mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    return !!mailformat.test(email.value);
}

function checkPassword(password, passwordConfirmation) {
    return password.value === passwordConfirmation.value;
}

function checkBirthdate(birthdate) {
    let dateEntered = new Date(birthdate);
    let ageDifMs = Date.now() - dateEntered.getTime();
    let ageDate = new Date(ageDifMs);
    return (Math.abs(ageDate.getUTCFullYear() - 1970) >= 18);
}
