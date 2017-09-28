<?php
include_once("authFilter.php");
include_once("config.php");

$id = $_GET['id'];
$username = null;
$firstName = null;
$lastName = null;
$secession = null;

$result = mysqli_query($mysqli, "
            SELECT *
            FROM doctor
              LEFT JOIN application_user
                ON doctor.application_user = application_user.username 
            WHERE application_user = $id
");

while ($res = mysqli_fetch_array($result)) {
    $username = $res['doctor.application_user'];
    $firstName = $res['doctor.first_name'];
    $lastName = $res['doctor.last_name'];
    $secession = $res['doctor.secession'];
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

<div class="container margit-top">
    <div class="text-center">
        <h1 class="title">
            Doctor
        </h1>
        <hr/>
    </div>

    <div class="row">
        <label class="col-md-3">
            Username
        </label>
        <label class="col-md-9"><?php echo $username;?></label>
    </div>

    <div class="row">
        <label class="col-md-3">
            First name
        </label>
        <label class="col-md-9"><?php echo $firstName;?></label>
    </div>

    <div class="row">
        <label class="col-md-3">
            Last name
        </label>
        <label class="col-md-9"><?php echo $lastName;?></label>
    </div>

    <div class="row">
        <label class="col-md-3">
            Secession
        </label>
        <label class="col-md-9"><?php echo $secession;?></label>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>