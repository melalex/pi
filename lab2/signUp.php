<?php
include_once("config.php");

$username = null;
$password = null;
$retryPassword = null;
$firstName = null;
$lastName = null;
$secession = null;

if (isset($_POST['submit'])) {
    $errors = array();

    $username = mysqli_real_escape_string($mysqli, $_POST['username']);
    $password = mysqli_real_escape_string($mysqli, $_POST['password']);
    $retryPassword = mysqli_real_escape_string($mysqli, $_POST['retryPassword']);
    $firstName = mysqli_real_escape_string($mysqli, $_POST['firstName']);
    $lastName = mysqli_real_escape_string($mysqli, $_POST['lastName']);
    $secession = mysqli_real_escape_string($mysqli, $_POST['secession']);

    if (empty($username)) {
        array_push($errors, "Username field can't be empty");
    } else {
        $result = mysqli_query($mysqli, "SELECT * FROM application_user WHERE username = $username");

        if (!$result) {
            die(mysqli_error($mysqli));
        }

        if (mysqli_num_rows($result) > 0) {
            array_push($errors, "User already exists");
        }
    }

    if (empty($password)) {
        array_push($errors, "Password field can't be empty");
    } else if ($password == $retryPassword) {
        array_push($errors, "Passwords did not matched");
    }

    if (empty($firstName)) {
        array_push($errors, "First name field can't be empty");
    }

    if (empty($lastName)) {
        array_push($errors, "Last name field can't be empty");
    }

    if (empty($secession)) {
        array_push($errors, "Secession field can't be empty");
    }

    if (empty($errors)) {
        $result = mysqli_query($mysqli, "INSERT INTO application_user (username, password) VALUES ('$username', '$password')");

        if (!$result) {
            die(mysqli_error($mysqli));
        }

        $result = mysqli_query($mysqli, "INSERT INTO doctor (application_user, first_name, last_name, secession) VALUES ('$username', '$firstName', '$lastName', '$secession')");

        if (!$result) {
            die(mysqli_error($mysqli));
        }

        setcookie("user", $username, time() + (86400 * 30));
        header("Location: dutiesList.php");
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
        echo '<strong>Error </strong>' . $error;
        echo "</div>";
    }
}
?>

<div class="container margit-top">
    <div class="text-center">
        <h2 class="title">Sign Up</h2>
        <hr/>
    </div>

    <div class="row main">
        <div class="main-login main-center">
            <form action="signUp.php" method="post">

                <div class="form-group">
                    <label for="username">Username</label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="username" id="username"
                                   placeholder="username"
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
                            <input type="password" class="form-control" name="password" id="password"
                                   placeholder="Password"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="retryPassword">
                        Retry Password
                    </label>
                    <div>
                        <div class="input-group">
                            <input type="password" class="form-control" name="retryPassword" id="retryPassword"
                                   placeholder="Retry Password"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="firstName">
                        First name
                    </label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="firstName" id="firstName"
                                   placeholder="First name"
                                   value="<?php echo $firstName ?>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName">
                        Last name
                    </label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="lastName" id="lastName"
                                   placeholder="Last Name"
                                   value="<?php echo $lastName ?>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="secession">
                        Secession
                    </label>
                    <div>
                        <div class="input-group">
                            <select class="form-control" name="secession" id="secession">
                                <option>Orthopedics</option>
                                <option>Therapy</option>
                                <option>Pediatrics</option>
                                <option>Rehabilitation</option>
                                <option>Gynecology</option>
                            </select>
                        </div>
                    </div>
                </div>

                <input class="btn btn-primary btn-lg btn-block login-button" type="submit" name="submit"
                       value="Sign Up">
            </form>
        </div>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
