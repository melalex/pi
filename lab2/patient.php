<?php
include_once("authFilter.php");
include_once("config.php");

$id = $_GET['id'];
$doctor = null;
$firstName = null;
$lastName = null;
$description = null;

if (isset($_POST['submit'])) {
    $errors = array();

    $doctor = mysqli_real_escape_string($mysqli, $_POST['doctor']);
    $firstName = mysqli_real_escape_string($mysqli, $_POST['firstName']);
    $lastName = mysqli_real_escape_string($mysqli, $_POST['lastName']);
    $description = mysqli_real_escape_string($mysqli, $_POST['description']);

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

    if (empty($firstName)) {
        array_push($errors, "First name field can't be empty");
    }

    if (empty($lastName)) {
        array_push($errors, "Last name field can't be empty");
    }


    if (empty($errors)) {
        if (isset($id)) {
            $result = mysqli_query($mysqli, "UPDATE patient SET first_name = $firstName, last_name = $lastName, description = $description, doctor = $doctor WHERE id = $id");
        } else {
            $result = mysqli_query($mysqli, "INSERT INTO patient (first_name, last_name, description, doctor) VALUES ($firstName, $lastName, $description, $doctor)");
        }

        header("Location: patientList.php");
        die();
    }
} else if (isset($id)) {

    $result = mysqli_query($mysqli, "
        SELECT * 
        FROM patient    
          LEFT JOIN doctor        
            ON patient.doctor = doctor.application_user    
          LEFT JOIN application_user        
            ON doctor.application_user = application_user.username 
        WHERE id = $id
    ");

    while ($res = mysqli_fetch_array($result)) {
        $id = $res['patient.id'];
        $doctor = $res['doctor.application_user'];
        $firstName = $res['patient.first_name'];
        $lastName = $res['patient.last_name'];
        $description = $res['patient.description'];
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
        echo '<strong>Error</strong>' . $error;
        echo "</div>";
    }
}
?>

<div class="container margit-top">
    <div class="text-center">
        <h1 class="title">Patient</h1>
        <hr/>
    </div>
    <div class="row main">
        <div class="main-login main-center">
            <form action="patient.php?<?php if (!empty($id)) echo "id=" . $id; ?>"
                  accept-charset="UTF-8" method="post">

                <div class="form-group">
                    <label for="doctor">
                        Doctor
                    </label>
                    <div>
                        <div class="input-group">
                            <input class="form-control" name="doctor" id="doctor"
                                   placeholder="Doctor"
                                   value="<?php if (empty($doctor)) echo $_COOKIE['user']; else echo $doctor; ?>"/>
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
                                   placeholder="Last name"
                                   value="<?php echo $lastName ?>"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="description">
                        Description
                    </label>
                    <div>
                        <div class="input-group">
                            <textarea class="form-control" name="description" id="description"
                                      placeholder="Description">
                                <?php echo $description ?>
                            </textarea>
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
