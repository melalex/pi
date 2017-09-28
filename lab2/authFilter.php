<?php

if (!isset($_COOKIE['user'])) {
    header("Location: signIn.php");
    die();
}