<%--
  Created by IntelliJ IDEA.
  User: ken-dia
  Date: 23/05/2024
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
    <style>

    </style>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Inscription</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
        <div class="login-form">
            <form class="sign-in-htm" method="post" action="">
                <div class="group">
                    <label for="user" class="label">Prénom</label>
                    <input id="first_name" type="text" class="input" name="first_name" placeholder="Entrer votre prénom">
                </div>
                <div class="group">
                    <label for="user" class="label">Nom</label>
                    <input id="last_name" type="text" class="input" name="last_name" placeholder="Entrer votre nom">
                </div>
                <div class="group">
                    <label for="user" class="label">Email</label>
                    <input id="user" type="text" class="input" name="email" placeholder="Entrer votre email">
                </div>
                <div class="group">
                    <label for="pass" class="label">Mot de passe</label>
                    <input id="pass" type="password" class="input" data-type="password" name="password" placeholder="Entrer votre mot de passe">
                </div>

                <div class="group">
                    <input type="submit" class="button" value="Créer un compte">
                </div>

                <div class="hr"></div>
                <div class="foot-lnk">
                    <a href="login">Se connecter</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
