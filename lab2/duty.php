<?php
include_once("authFilter.php");
include_once("config.php");

if (isset($_POST['submit'])) {
    $errors = array();

    $doctor = mysqli_real_escape_string($mysqli, $_POST['doctor']);
    $date = mysqli_real_escape_string($mysqli, $_POST['date']);

    if (empty($doctor)) {
        array_push($errors, "Doctor field can't be empty");
    } else {
        $result = mysqli_query($mysqli, "
            SELECT *
            FROM doctor
              LEFT JOIN application_user
                ON doctor.application_user = application_user.username 
            WHERE application_user = $doctor
        ");

        if (mysql_fetch_array($result) === false) {
            array_push($errors, "Doctor doesn't exist");
        }
    }

    if (empty($date)) {
        array_push($errors, "Date field can't be empty");
    }


    if (empty($errors)) {
        $result = mysqli_query($mysqli, "INSERT INTO duty (doctor, date) VALUES ($doctor, $date)");

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
        <h1 class="title">Duty</h1>
        <hr/>
    </div>

    <div class="row main">
        <div class="main-login main-center">
            <form action="duty.php" accept-charset="UTF-8" method="post">

                <div class="form-group">
                    <label for="doctor">
                        Username
                    </label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="doctor" id="doctor"
                                   placeholder="Doctor"
                                   value="<?php echo $_COOKIE['user'] ?>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="date">
                        Date
                    </label>
                    <div>
                        <div class="input-group">
                            <input type="date"
                                   class="form-control"
                                   name="date"
                                   id="date"/>
                        </div>
                    </div>
                </div>

                <input class="btn btn-primary btn-lg btn-block login-button" type="submit" name="submit"
                       value="Save">
            </form>
        </div>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
