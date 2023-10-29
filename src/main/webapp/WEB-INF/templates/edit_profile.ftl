<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJ" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>

    <style>
        html,
        body {
            height: 100%;
        }

        body {
            -ms-flex-align: center;
            -ms-flex-pack: center;
            -webkit-box-align: center;
            align-items: center;
            justify-content: center;
            background-color: #f5f5f5;
        }
    </style>
</head>
<body class="text-center">
<form method="post" enctype="multipart/form-data">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <div class="container py-5">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <img data-bs-toggle="modal" data-bs-target="#exampleModal"
                                     src="${req.getContextPath()}/avatars/test.jpg"
                                     alt="avatar"
                                     class="rounded-circle img-fluid" style="width: 150px;">
                                <div class="mb-3">
                                    <label for="formFile" class="form-label">Choose a new photo</label>
                                    <input class="form-control" type="file" id="formFile">
                                </div>
                                <p class="my-3 text-muted mb-4"><input type="text" name="bio"
                                                                       value="${user.bio!}">
                                </p>
                                <div class="d-flex justify-content-center mb-2">
                                    <input type="submit" class="btn btn-primary" value="Save">
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
                                        <p class="text-muted mb-0"><input type="text" name="firstname"
                                                                          value="${user.firstname}"></p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Lastname</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0"><input type="text" name="lastname"
                                                                          value="${user.lastname}"></p>
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
                                                <option value="male" <#if user.gender??> <#if user.gender == "Male">selected</#if></#if>>
                                                    Male
                                                </option>
                                                <option value="female" <#if user.gender??> <#if user.gender == "Female">selected</#if></#if>>
                                                    Female
                                                </option>
                                                <option value="other" <#if user.gender??> <#if user.gender == "Other">selected</#if></#if>>
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
                                                                          value="${user.dateOfBirth!}"></p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Favorite genres</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">There is will be genres</p>
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

<!-- Модальное окно -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form method="post" enctype="multipart/form-data">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Upload a new photo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                </div>
                <div class="modal-body">

                    <div class="mb-3">
                        <label for="formFile" class="form-label">Choose a new photo</label>
                        <input class="form-control" type="file" id="formFile">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    </form>

</div>

</body>
</html>