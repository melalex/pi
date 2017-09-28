<?php
include_once("config.php");

$username = null;
$password = null;

if (isset($_POST['submit'])) {
    $errors = array();

    $username = mysqli_real_escape_string($mysqli, $_POST['username']);
    $password = mysqli_real_escape_string($mysqli, $_POST['password']);

    if (empty($username)) {
        array_push($errors, "Username field can't be empty");
    }

    if (empty($password)) {
        array_push($errors, "Password field can't be empty");
    }

    $result = mysqli_query($mysqli, "SELECT * FROM application_user WHERE username = ? AND password = ?");

    if (mysql_fetch_array($result) === false) {
        array_push($errors, "User doesn't exist");
    }

    if (empty($errors)) {
        setcookie("user", $username, (86400 * 30));
        header("Location: patientList.php");
        die();
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="css/bootstrap.min.css">
    <link rel='stylesheet'
          href='css/bootstrap-grid.min.css'>
    <link rel="stylesheet"
          href="css/font-awesome.min.css">
    <link rel='stylesheet'
          href='css/custom.css'>

    <title>Php</title>
</head>
<body>
<nav class="navbar navbar-toggleable-sm navbar-inverse bg-inverse">
    <a class="navbar-brand" href="patientList.php">Hospital</a>

    <ul class="nav navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="patientList.php">
                Patients
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="doctorList.php">
                Doctors
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="dutiesList.php">
                Duties
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="function.php">
                Function
            </a>
        </li>
    </ul>

    <ul>
        <li class="nav-item">
            <a class="nav-link" href="logout.php">
                Logout
            </a>
        </li>
    </ul>
</nav>

<?php
if (!empty($errors)) {
    foreach ($errors as $error) {
        echo "<div class='alert alert-danger' role='alert'>";
        echo '<strong>Error</strong>'. $error;
        echo "</div>";
    }
}
?>

<div class="container margit-top">
    <div class="text-center">
        <h1 class="title">Sign in</h1>
        <hr/>
    </div>

    <div class="row main">
        <div class="main-login main-center">
            <form action="signIn.php" accept-charset="UTF-8" method="post">

                <div class="form-group">
                    <label for="username">
                        Username
                    </label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="username" id="username"
                                   placeholder="Username"
                                   value="<?php echo $username ?>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password">
                        Password
                    </label>
                    <div>
                        <div class="input-group">
                            <input type="password"
                                   class="form-control"
                                   name="password"
                                   id="password"
                                   placeholder="Password"/>
                        </div>
                    </div>
                </div>

                <input class="btn btn-primary btn-lg btn-block login-button" type="submit" name="submit"
                       value="Submit">
            </form>
            <a href="signUp.php">
                Sign Up
            </a>
        </div>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>