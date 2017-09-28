<?php
include_once("authFilter.php");
include_once("config.php");

$limit = isset($_GET['limit']) ? $_GET['limit'] : 100;
$offset = isset($_GET['offset']) ? $_GET['offset'] : 0;

$result = mysqli_query($mysqli, "
    SELECT * 
    FROM patient    
        LEFT JOIN doctor        
          ON patient.doctor = doctor.application_user    
        LEFT JOIN application_user        
          ON doctor.application_user = application_user.username 
    LIMIT ? OFFSET ?
");

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

<div class="container margit-top">
    <div class="text-center">
        <h1>Patients</h1>
        <hr/>
        <a class="btn btn-success" href="patient.php">
            Create
        </a>
    </div>

    <table class="table table-hover margit-top">
        <thead>
        <tr>
            <th>Id</th>
            <th>Full name</th>
            <th>Doctor</th>
        </tr>
        </thead>
        <tbody>
        <?php
        while ($res = mysqli_fetch_array($result)) {
            echo "<tr>";
            echo "<td>" . $res['patient.id'] . "</td>";
            echo "<td>";
            echo "<a href='patient.php?id=${$res['patient.id']}'>" . $res['patient.first_name'] . " " . $res['patient.last_name'] . "</a>";
            echo "</td>";
            echo "<td>";
            echo "<a href='doctor.php?id=${$res['doctor.application_user']}'>" . $res['doctor.application_user'] . "</a>";
            echo "</td>";
            echo "<tr>";
        }
        ?>
        </tbody>
    </table>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
