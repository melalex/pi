<?php
include_once("authFilter.php");
include_once("config.php");

$limit = isset($_GET['limit']) ? $_GET['limit'] : 100;
$offset = isset($_GET['offset']) ? $_GET['offset'] : 0;

$result = mysqli_query($mysqli, "
    SELECT p.id AS id, p.doctor AS doctor, p.first_name AS first_name, p.last_name AS last_name, p.description AS description
    FROM patient AS p
      LEFT JOIN doctor AS d       
        ON p.doctor = d.application_user    
      LEFT JOIN application_user AS a   
        ON d.application_user = a.username 
    LIMIT $limit OFFSET $offset
");

if (!$result) {
    die(mysqli_error($mysqli));
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
            $id = $res['id'];
            $doctor = $res['doctor'];

            echo "<tr>";
            echo "<td>" . $res['id'] . "</td>";
            echo "<td>";
            echo "<a href='patient.php?id=$id'>" . $res['first_name'] . " " . $res['last_name'] . "</a>";
            echo "</td>";
            echo "<td>";
            echo "<a href='doctor.php?id=$doctor'>" . $doctor . "</a>";
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
