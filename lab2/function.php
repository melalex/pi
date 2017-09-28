<?php
include_once("authFilter.php");

$variable = $_POST['variable'];

if (isset($variable)) {
    $a = 5.1;
    $b = 0.9;

    if ($variable <= 1) {
        $result = pow($variable - 4, 2) + $a;
    } else if ($variable <= 2) {
        $result = 1.7 * pow(cos($variable), 2);
    } else if ($variable > 2) {
        $result = exp($a * $variable) * cos($b * $variable);
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

<div class="container margit-top">
    <div class="text-center">
        <h1 class="title">Function</h1>
        <hr/>
    </div>

    <div class="main">
        <div class="main-login main-center">
            <form action="function.php" accept-charset="UTF-8" method="post">

                <div class="form-group">
                    <label for="variable">
                        Username
                    </label>
                    <div>
                        <div class="input-group">
                            <input type="number" class="form-control" name="variable" id="variable"
                                   placeholder="Variable"
                                   value="<?php echo $variable ?>"/>
                        </div>
                    </div>
                </div>

                <?php
                if (isset($result)) {
                    echo "<p>Result is: " . $result . "</p>";
                }
                ?>

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
