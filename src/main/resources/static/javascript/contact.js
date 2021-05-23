let submitButton = document.getElementById("submit-button");
submitButton.addEventListener("click", validateForm);

function validateForm(event) {
    let lastName = document.getElementById("contact-form-nom");
    let firstName = document.getElementById("contact-form-prénom");
    let email = document.getElementById("contact-form-mail");
    let message = document.getElementById("contact-form-message");

    if (firstName.value === "" || lastName.value === "" || email.value === "" || message.value === "") {
        alert("Merci de remplir tous les champs");
        event.preventDefault();
    }

    else {
        if (!checkEmail(email)) {
            alert("L'adresse mail n'a pas le bon format");
            event.preventDefault();
        }
    }
}

function checkEmail(email) {
    let mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    return !!mailformat.test(email.value);
}
