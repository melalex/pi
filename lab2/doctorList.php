<?php
include_once("authFilter.php");
include_once("config.php");

$date = isset($_GET['date']) ? "'" . $_GET['date'] . "'" : "NULL";
$secession = isset($_GET['secession']) ? "'" . $_GET['secession'] . "'" : "NULL";
$limit = isset($_GET['limit']) ? $_GET['limit'] : 100;
$offset = isset($_GET['offset']) ? $_GET['offset'] : 0;

$result = mysqli_query($mysqli, "
    SELECT * 
    FROM doctor    
        LEFT JOIN application_user        
          ON doctor.application_user = application_user.username     
        LEFT JOIN duty        
          ON doctor.application_user = duty.doctor 
    WHERE ($secession IS NULL OR doctor.secession = $secession)        
      AND ($date IS NULL OR duty.date = $date) 
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
        <h1 class="title">Doctors</h1>
        <hr/>
    </div>

    <div class="row">
        <div class="col-md-6">
            <form action="doctorList.php" class="form-inline">
                <label class="sr-only" for="date">Duties date</label>
                <input type="date" class="form-control mb-2 mr-sm-2 mb-sm-0" id="date">

                <label class="sr-only" for="secession">Secession</label>
                <select class="form-control" name="secession" id="secession">
                    <option>Orthopedics</option>
                    <option>Therapy</option>
                    <option>Pediatrics</option>
                    <option>Rehabilitation</option>
                    <option>Gynecology</option>
                </select>

                <button class="btn btn-primary search-button">Search</button>
            </form>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Secession</th>
        </tr>
        </thead>
        <tbody>
        <?php
        while ($res = mysqli_fetch_array($result)) {
            $doctor = $res['application_user'];

            echo "<tr>";
            echo "<td>";
            echo "<a href='doctor.php?id=$doctor'>" . $doctor . "</a>";
            echo "</td>";
            echo "<td>" . $res['first_name'] . "</td>";
            echo "<td>" . $res['last_name'] . "</td>";
            echo "<td>" . $res['secession'] . "</td>";
            echo "<tr>";
        }
        ?>
    </table>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
