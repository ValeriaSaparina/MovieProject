function validateUsername() {
    const usernameInput = document.getElementById('inputUsername');
    const errorInput = document.getElementById('errorUsername');
    const usernameRegex = /^[a-zA-Z0-9_]{6,30}$/;

    validateData(usernameInput, errorInput, usernameRegex);
    isUniqueUsername(usernameInput.value, errorInput)

}

function validateFirstname() {
    const nameInput = document.getElementById('inputName');
    const errorInput = document.getElementById('errorFirstname')
    const nameRegex = /((^[A-Z])(([a-z]){1,20})|(^[А-Я])(([а-я]){1,20}))$/
    validateData(nameInput, errorInput, nameRegex)
}

function validateLastname() {
    const nameInput = document.getElementById('inputSurname');
    const errorInput = document.getElementById('errorLastname')
    const nameRegex = /((^[A-Z])(([a-z]){1,20})|(^[А-Я])(([а-я]){1,20}))$/
    validateData(nameInput, errorInput, nameRegex)
}

function validatePassword() {
    const passwordInput = document.getElementById('inputPassword');
    const errorInput = document.getElementById('errorPassword')
    const passwordRegex = /(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/g


    validateData(passwordInput, errorInput, passwordRegex);
}

function hasError() {
    const errors = document.getElementsByClassName('error')
    const myInputs = document.getElementsByClassName('myInput')
    for (let input of myInputs) {
        if (input.value === '') return true;
    }
    for (let error of errors) {
        if (error.textContent !== '') return true;
    }
    return false
}

function validateData(input, errorInput, regex) {
    const btn = document.getElementById('submitBtn');
    const text = input.value;

    var minS = 6;
    var maxS = 20;
    var message = "Может содержать только A-Z a-z _ ."

    if (input.id === 'inputSurname' || input.id === 'inputName') {
        minS = 2;
        message = "Может содержать только буквы русского или латинского алфавитов и начинаться с заглавной буквы"
    }
    if (input.id === 'inputPassword') message = "Должно содержать минимум 1 заглавную букву, 1 символ и 1 цифр; только латинские буквы"

    if (!regex.test(text)) {
        if (text.length < minS || text.length > maxS)
            errorInput.textContent = `Длина дожна быть ${minS}-${maxS} симоволов.`;
        else
            errorInput.textContent = message;
    } else {
        errorInput.textContent = "";
    }

    if (hasError()) btn.setAttribute('disabled', '')
    else btn.removeAttribute('disabled')

}