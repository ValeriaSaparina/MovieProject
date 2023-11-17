function isUniqueUsername(username, errorInput) {
    $.ajax({
        url: 'checkUsername',
        type: 'POST',
        data: {username: username},
        dataType: "json",
        success: function(response) {
            if (response.isUnique) {
                $('#registrationForm').submit();
            } else {
                errorInput.textContent = "Имя пользователя уже занято"
            }
        }
    });
}