<?php include ('functions.php');
$nombres=$_GET['nombres'];
$telefono=$_GET['telefono'];


ejecutarSQLCommand("INSERT INTO  `usuarios` (nombres, telefono)
VALUES (
'$nombres' ,
'$telefono')

 ON DUPLICATE KEY UPDATE `nombres`= '$nombres',
`telefono`='$telefono';");

 ?>