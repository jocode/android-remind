<?php 
header('Content-Type: application/json');
require_once('Connection.php');
$db = new Connection();
$cedula = $_GET['cc'];
$nombres = $_GET['nombres'];
$apellidos = $_GET['apellidos'];
$direccion = $_GET['direccion'];
$telefono = $_GET['telefono'];

if ($cedula){
	$sql = "INSERT INTO `datos_personales`(`cedula`, `nombres`, `apellidos`, `direccion`, `telefono`) VALUES ('$cedula', '$nombres', '$apellidos', '$direccion', '$telefono')";
	
	if ($db->exec($sql)){
		$sql = "SELECT cedula, nombres, apellidos, direccion, telefono FROM  `datos_personales`";
		echo $db->query($sql);
	} 
} 

?>