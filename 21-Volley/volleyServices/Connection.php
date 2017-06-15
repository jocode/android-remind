<?php

class Connection {

	private $mysqli;

	public function __construct(){
		$this->mysqli = new mysqli("localhost", "root", "", "volley");
    # $this->mysqli->select_db('');

		/* check connection */
		if ($this->mysqli->connect_errno) {
			printf("Connect failed: %s\n", $mysqli->connect_error);
			exit();
		}
		$this->mysqli->query("SET NAMES 'utf8'");
	}

	public function setNames(){
		return $this->mysqli->query("SET NAMES 'utf8'");
	}

	public function exec($sql){
		return $this->mysqli->query($sql);
	}

	public function query($sql){
		$result = $this->mysqli->query($sql);
		// Si la sentencia (SQL) está mal definida devuelve false, sino procede con la ejecución. 
		if ($result){
			$row = $result->fetch_object();
			if (count($row)>0){
				return json_encode($row);
			} else {
				$data = array(
					'info'=>'No se encontraron resultados'
					);
				return json_encode($data);
			}
		} else {
			$data = array(
				'error' => 'Verifica la consulta a la base de datos' 
				);
			return json_encode($data);
		}

	}

}

?>
