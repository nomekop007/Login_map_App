<?php
    $con = mysqli_connect("localhost", "root", "", "usuarios");
    
    $name = $_POST["nombre"];
    $pass = $_POST["pass"];
    $ubicacion = $_POST["ubicacion"];
    $pass = $_POST["pass"];
    $statement = mysqli_prepare($con, "INSERT INTO user (nombre, ubicacion, pass, pass) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssis", $nombre, $ubicacion, $pass, $pass);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>