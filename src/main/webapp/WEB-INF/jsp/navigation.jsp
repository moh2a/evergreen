<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="boite-simple sticky-top menu">
    <div class="row justify-content-between">
        <div class="logo col-4 col-sm-2 col-md-12 ">
            <a href="index">
                <img src="assets/LOGO-SITE.png" alt="logo" width="100" height="100">
            </a>
        </div>
        <div class=" d-md-none col-4 col-sm-2 col-md-12 conteneurHam">
            <div class="containerHamburger" onclick="myFunction(this)">
                <div class="bar1"></div>
                <div class="bar2"></div>
                <div class="bar3"></div>
            </div>
        </div>
    </div>


    <div id="myNav" class="nav flex-column d-none d-md-block">
        <ul class="fa-ul nav flex-column">
            <li class="nav-item"><span class="fa-li"><i class="fa fa-home nav-link"></i></span><a class="nav-link" href="index">Accueil</a></li>
            <li class="nav-item"><span class="fa-li "><i class="fa fa-user-o nav-link"></i></span><a class="nav-link" href="profil">Profil</a></li>
            <li class="nav-item"><span class="fa-li "><i class="fa fa-calendar-o nav-link"></i></span><a class="nav-link" href="event">Evènements</a></li>
            <li class="nav-item"><span class="fa-li "><i class="fa fa-comments-o nav-link"></i></span><a class="nav-link" href="forum">Forum</a></li>
            <li class="nav-item"><span class="fa-li "><i class="fa fa-pencil-square-o nav-link"></i></span><a class="nav-link" href="event">Blog</a></li>

        </ul>
    </div>
</div>
<script>
    function myFunction(x) {
        x.classList.toggle("change");
        var y = document.getElementById("myNav");
        y.classList.toggle('d-none');
    }
</script>