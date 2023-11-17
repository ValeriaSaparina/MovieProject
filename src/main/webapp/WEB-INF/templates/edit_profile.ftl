<#include "macro/base.ftl">
<#macro page_head>
    <title>Edit Profile</title>
    <link href="${path}/css/profile.css" rel="stylesheet">
    <script src="${path}/js/validateData.js" type="application/javascript"></script>
    <script src="${path}/js/countingCharacters.js" type="application/javascript"></script>
</#macro>

<#macro content>
    <div class="text-center">
        <form method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <div class="container py-5">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card mb-4">
                                    <div class="card-body text-center">
                                        <img src="<#if user.photoPath??>${path}${user.photoPath!}</#if>"
                                             alt="avatar"
                                             class="rounded-circle img-fluid" style="width: 150px;">
                                        <div class="mb-3">
                                            <label for="formFile" class="form-label">Выберите фото</label>
                                            <input class="form-control" name="photo" type="file"
                                                   accept=".jpg, .jpeg" id="formFile">
                                        </div>
                                        <p class="my-3 text-muted mb-4"><textarea name="bio" id="bio"
                                                                                  oninput="counting()">${user.bio!}</textarea>
                                        </p>
                                        <p class="my-3 text-muted mb-4" id="counter">
                                        </p>
                                        <div class="d-flex justify-content-center mb-2">
                                            <input type="submit" class="btn btn-primary" id="submitBtn" value="Save">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Username</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">${user.username}</p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Firstname</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0"><input type="text"
                                                                                  onblur="validateFirstname()"
                                                                                  id="inputName" name="firstname"
                                                                                  value="${user.firstname}"></p>
                                                <p class="error" id="errorFirstname"></p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Lastname</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0"><input type="text" id="inputSurname"
                                                                                  onblur="validateLastname()"
                                                                                  name="lastname"
                                                                                  value="${user.lastname}"></p>
                                                <p class="error" id="errorLastname"></p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Gender</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">
                                                    <select name="gender">
                                                        <option value="male" <#if user.gender??> <#if user.gender == "male">selected</#if></#if>>
                                                            Male
                                                        </option>
                                                        <option value="female" <#if user.gender??> <#if user.gender == "female">selected</#if></#if>>
                                                            Female
                                                        </option>
                                                        <option value="other" <#if user.gender??> <#if user.gender == "other">selected</#if></#if>>
                                                            Other
                                                        </option>
                                                    </select>
                                                </p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Date Of Birth</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0"><input type="date" name="dateOfBirth"
                                                                                  value="${user.dateOfBirth}"></p>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <p class="mb-0">Favorite genres</p>
                                            </div>
                                            <div class="col-sm-9">
                                                <p class="text-muted mb-0">There will be genres</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</#macro>
<@display_page/>