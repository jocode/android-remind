<?php 
header('Content-Type: application/json');
require_once('Connection.php');
$db = new Connection();

$sql = "SELECT cedula, nombres, apellidos, direccion, telefono FROM  `datos_personales`";
echo $db->query($sql);

?>