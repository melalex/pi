<?php
include_once("authFilter.php");
include_once("config.php");

$lastName = isset($_GET['lastName']) ? "'" . $_GET['lastName'] . "%'" : "NULL";
$limit = isset($_GET['limit']) ? $_GET['limit'] : 100;
$offset = isset($_GET['offset']) ? $_GET['offset'] : 0;

$result = mysqli_query($mysqli, "
    SELECT * FROM duty    
      LEFT JOIN doctor        
        ON doctor.application_user = duty.doctor    
      LEFT JOIN application_user        
        ON doctor.application_user = application_user.username 
    WHERE ($lastName IS NULL OR doctor.last_name LIKE $lastName) 
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
        <h1 class="title">Duties</h1>
        <hr/>
    </div>
    <div class="row">
        <div class="col-md-4">
            <form action="dutiesList.php" class="form-inline">
                <label class="sr-only" for="lastName">Last name</label>
                <input type="search" class="form-control mb-2 mr-sm-2 mb-sm-0" id="lastName">

                <button class="btn btn-primary">Search</button>
            </form>
        </div>

        <div class="col-md-6"></div>

        <div class="col-md-2">
            <a class="btn btn-success search-button" href="duty.php">
                Create
            </a>
        </div>

    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Doctor</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <?php
        while ($res = mysqli_fetch_array($result)) {
            $doctor = $res['doctor'];

            echo "<tr>";
            echo "<td>" . $res['id'] . "</td>";
            echo "<td>";
            echo "<a href='doctor.php?id=$doctor'>" . $doctor . "</a>";
            echo "</td>";
            echo "<td>" . $res['date'] . "</td>";
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
