<?php 
header('Content-Type: application/json');
require_once('Connection.php');
$db = new Connection();
$cedula = $_GET['cc'];

if ($cedula){
	$sql = "SELECT cedula, nombres, apellidos, direccion, telefono FROM  `datos_personales` WHERE cedula='$cedula'";
	echo $db->query($sql);
}

?>