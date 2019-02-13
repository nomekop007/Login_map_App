<?php
    $con = mysqli_connect("localhost", "root", "", "usuarios");
    
    $nombre = $_POST["nombre"];
    $pass = $_POST["pass"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE nombre = ? AND pass = ?");
    mysqli_stmt_bind_param($statement, "ss", $nombre, $pass);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $gmail, $ubicacion, $nombre, $pass);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["gmail"] = $gmail;
        $response["ubicacion"] = $ubicacion;
        $response["nombre"] = $nombre;
        $response["pass"] = $pass;
    }
    
    echo json_encode($response);
?>