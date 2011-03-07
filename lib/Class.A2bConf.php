<?php
/* file: Class.A2bConf.php
 * author: M. Fauzilkamil Zainuddin <jerungkun@gmail.com>
 * purpose: reading a2billing 1.3.3 config file to get agi-conf and put it to database for
 * 	    a2billing 1.7.1
 */

class A2bcfg {
	var $config;
	var $dbconf;

	function A2bcfg() {
		/* constructor */
		
		include("dbconf.inc");

		$this->dbconf = Array('host' => $dbhost, 'user' => $dbuser, 'pass' => $dbpass, 'db' => $dbname);
		
	}

	/* load a2billing.conf v1.3.3 */
	function load_config($configfile) {
		$this->config = parse_ini_file($configfile,true);
	}

	/* get agi-conf1 */
	function getDBagi($conf_id = 1) {
		$dbagi = Array();	

		//include("dbconf.inc");

		$QUERY = "SELECT * FROM cc_config WHERE config_group_title = 'agi-conf" . $conf_id ."'";		

		$link = $this->connectDB();

		$result = mysql_query($QUERY, $link);

		if (!$result) {
			return 0;
		}

		while ($row = mysql_fetch_assoc($result)) {
		        //echo "[". $row['config_key'] ."]\n";
			$dbagi[$row['config_key']] = $row;
		}

		$this->closeDB($link);

		return $dbagi;
	}

	/* create default AGI based on agi-conf1 */
	function CreateDefaultAGI($conf_id, $dbagi) {
		$agiconf = "agi-conf" . $conf_id;
		echo "Create default $agiconf \n";
		/* agiarv is array of agi-conf data value */
		$n = 1;
		foreach ($dbagi as $agikey => $agiarv) {
			if ($this->CheckAGIExists($agiconf, $agikey)) {
				echo "DEFAULT $n . update $agiconf : " . $agikey . " = " . $agiarv['config_value'] . "\n";
				$this->updateAGIEntry($agiconf, $agikey, $agiarv['config_value']);
			} else {
				/* insert new value */
				echo "DEFAULT $n . insert $agiconf : " . $agikey . " = " . $agiarv['config_value'] ."\n";
				$this->insertAGIEntry($agiconf, $agikey, $agiarv['config_value'], $agiarv);

			}
			$n++;
		}
	}

	/* copy conf value to db agi-conf */
	function CopyConfToDB($conf_id, $dbagi, $confagi) {
		/* copy conf agi values */
		$agiconf = "agi-conf" . $conf_id;
		echo "Copy conf: $agiconf \n";
		$n = 1;
		foreach ($confagi as $confvar => $confval) {
			switch($confvar) {
				case "asterisk_version":
					echo "[  ] $n . use agi-conf1 value for asterisk_version \n";
					break;
				default:
					if ($this->CheckAGIExists($agiconf, $confvar)) {
						if ($confval != "") {
							echo "COPY $n . update $agiconf : " . $confvar . " = " . $confval . "\n";
							$this->updateAGIEntry($agiconf, $confvar, $confval);
						} else {
							echo "[  ] $n . Not updating $agiconf : " . $confvar . " = " . $confval . "\n";
						}
					} else {
						echo "[ -] $n . $agiconf Variable $confvar = $confval may have depreciated \n";
					}

			}
			$n++;
		}

	}

	/* check config group exists */
	function CheckAGIGroupExists($confid) {
		$QUERY = "SELECT COUNT(id) as `count` FROM cc_config_group WHERE group_title = '" . $confid . "'";

		$link = $this->connectDB();

		if (!$link) {
			return 0;
		}

		$res = mysql_query($QUERY, $link);

		if (!$res) {
			return 0;
		}

		$row = mysql_fetch_assoc($res);

		if ($row['count'] > 0) {
			return 1;
		} else {
			return 0;
		}

		$this->closeDB($link);
	}
	
	/* check agi entry exists */
	function CheckAGIExists($confid, $confkey) {
		
		$query = "SELECT COUNT(id) as `count` FROM cc_config WHERE config_group_title = '" . $confid ."' AND config_key = '" . $confkey . "'";

		$link = $this->connectDB();

		if (!$link) {
			return 0;
		}

		$res = mysql_query($query, $link);

		if (!$res) {
			return 0;
		}

		$row = mysql_fetch_assoc($res); 
		
		//echo print_r($row,true);
		if ($row['count'] > 0) {
			return 1;
		} else {
			return 0;
		}

		$this->closeDB($link);

	}

	/* close database */
	function closeDB($link) {
		mysql_close($link);
	}
	/* connect database */
	function connectDB() {
		$link = mysql_connect($this->dbconf['host'],$this->dbconf['user'],$this->dbconf['pass']);		

		if (!$link) {
			return 0;
		}

		if (!mysql_select_db($this->dbconf['db'],$link)) {
			return 0;
		}

		return $link;
	}
	
	/* update entry */
	function updateAGIEntry($confid,$confkey,$confvalue) {
		$link = $this->connectDB();

		$QUERY = "UPDATE cc_config SET config_value = '" . $confvalue . 
		"' WHERE config_key = '" . $confkey . "' AND config_group_title = '" . $confid . "'";

		mysql_query($QUERY,$link);

		$this->closeDB($link);
	}

	function insertAGIEntry($confid,$confkey,$confvalue,$def) {
		$link = $this->connectDB();
		$QFIELDS = "config_title, config_key, config_value, config_description, config_valuetype, config_group_title";
		$QDATA = "'" . mysql_real_escape_string($def['config_title']) . "', ";
		$QDATA .= "'" . mysql_real_escape_string($confkey) . "', ";
		$QDATA .= "'" . mysql_real_escape_string($confvalue) . "', ";
		$QDATA .= "'" . mysql_real_escape_string($def['config_description']) . "', ";
		$QDATA .= "'" . mysql_real_escape_string($def['config_valuetype']) . "', ";
		$QDATA .= "'" . mysql_real_escape_string($confid) . "'";

		if (!is_null($def['config_listvalues'])) {
			$QFIELDS .=", config_listvalues";
			$QDATA .= ", '" . mysql_real_escape_string($def['config_listvalues']) . "'";
		}
		
		$QUERY = "INSERT INTO cc_config (" . $QFIELDS . ") VALUES (" . $QDATA . ")";

		mysql_query($QUERY,$link);

		//echo $QUERY . "\n";

		$this->closeDB($link);
	}

	function insertAGIGroup($confid,$confdesc) {
		$link = $this->connectDB();

		$QFIELDS = "group_title, group_description";
		$QDATA = "'" . mysql_real_escape_string($confid) . "', ";
		$QDATA .= "'" . mysql_real_escape_string($confdesc) . "'";

		$QUERY = "INSERT INTO cc_config_group (" . $QFIELDS . ") VALUES (" . $QDATA . ")";
		
		mysql_query($QUERY,$link);
		
		$this->closeDB($link);
	}

}

?>
