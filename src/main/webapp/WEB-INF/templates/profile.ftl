<#include "macro/base.ftl">

<#macro page_head>
    <title>Profile</title>
    <link href="${path}/css/profile.css" rel="stylesheet">
</#macro>

<#macro content>
    <div class="text-center">
        <div class="row">
            <div class="col-md-8 mx-auto">
                <div class="container py-5">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card mb-4">
                                <div class="card-body text-center">
                                    <img id="img-tooltip" data-bs-target="#exampleModal"
                                         src="${path}${user.photoPath!}"
                                         alt="avatar"
                                         class="rounded-circle img-fluid" data-bs-toggle="modal"
                                         data-bs-placement="bottom"
                                         title="Посмотреть фото" style="width: 150px;">
                                    <h5 class="my-3">${user.firstname} ${user.lastname}</h5>
                                    <p class="text-muted mb-4">${user.bio!}</p>
                                    <div class="d-flex justify-content-center mb-2">
                                        <a href="${path}/edit_profile"><input type="submit"
                                                                              class="btn btn-primary"
                                                                              value="Edit profile"></a>
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
                                            <p class="text-muted mb-0">${user.firstname}</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Lastname</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">${user.lastname}</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Gender</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">${user.gender!}</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Date Of Birth</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">${user.dateOfBirth!}</p>
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


        <!-- Модальное окно -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <form method="post" enctype="multipart/form-data">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">${user.firstname} ${user.lastname}</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Закрыть"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <img id="img-tooltip" data-bs-target="#exampleModal"
                                     src="${path}${user.photoPath!}"
                                     alt="avatar"
                                     class="rounded-circle img-fluid" data-bs-toggle="modal" data-bs-placement="bottom"
                                     style="max-width: 400px">
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </div>
    </div>

    <script>
        var exampleEl = document.getElementById('img-tooltip')
        var tooltip = new bootstrap.Tooltip(exampleEl, 'show')
    </script>

</#macro>
<@display_page/>