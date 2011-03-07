#!/usr/bin/php -q
<?php
/*
 * Unit Testing Script by M. Fauzilkamil Zainuddin
 */

include("../lib/Class.A2bConf.php");

echo "++ unit testing ++\n";

function testCheckExists($confid = 'agi-conf1',$confkey = 'asterisk_version' ) {
	
	$a2b = new A2bcfg();

	echo " + test id: " . $confid . "\n";
	echo " + test key: " . $confkey . "\n";
	$ret = $a2b->CheckAGIExists($confid,$confkey);
	echo " + result: " . $ret ."\n";
	if (!$ret) {
		echo " ++ Not Exists\n";
	} else {
		echo " ++ Entry Exists\n";
	}
}

function updateAGI($confid = 'agi-conf1', $confkey = 'asterisk_version', $confvalue = '1_4') {
	$a2b = new A2bcfg();

	echo " + update AGI id: " . $confid . "\n";
	echo " + update AGI key: " . $confkey . "\n";
	echo " + update AGI value: " . $confvalue . "\n";

	//updateAGIEntry($confid,$confkey,$confvalue)
	$a2b->updateAGIEntry($confid,$confkey,$confvalue);

}

function testInsert($confid = 'agi-conf1', $confkey = 'asterisk_version', $confvalue = '1_4') {
	$a2b = new A2bcfg();

	$dbagi = $a2b->getDBagi();

	echo "inserting $confid - $confkey - $confvalue\n"; 

	if (!$a2b->CheckAGIExists($confid,$confkey)) {
		echo "agi entry not exists... inserting\n";
		
		//echo print_r($dbagi[$confkey],true);
		$a2b->insertAGIEntry($confid,$confkey,$confvalue,$dbagi[$confkey]);
	} else {
		echo "agi entry exists... updating\n";
	}
	
	/*
	foreach ($dbagi as $agik => $agie) {
	        echo "agi key: " . $agik . "\n";
	        foreach ($agie as $agvk => $agvv) {
	                echo "   $agvk = ";
	                if (is_null($agvv)) {
	                        echo "[NULL]\n";
	                } else {
	                	echo $agvv . "\n";
			}
		}
	}
	*/

}

function listAGIkey() {
	$a2b = new A2bcfg();

	$dbagi = $a2b->getDBagi();

	echo print_r($dbagi,true);

}

function showHelp($arg) {
	echo "Usage: " . $arg[0] . " [option] [data]\n";
	echo "Options: ce (test check AGI exists)\n";
	echo "         ua (test update AGI)\n";
	echo "         ti (test insert)\n";
	echo "         lk (list default AGI key)\n";
	echo "         help (show this help)\n";
}

// check arguments
if (!empty($argc) && $argc > 1) {
	//echo "got arguments: $argc\n";
	switch ($argv[1]) {
		case "ce":
			if ($argc == 4) {
				testCheckExists($argv[2],$argv[3]);
			} else {
				testCheckExists();
			}
			break;

		case "ua":
			if ($argc == 5) {
				updateAGI($argv[2],$argv[3],$argv[4]);
			} else {
				updateAGI();
			}
			break;
		
		case "ti":
			if ($argc == 5) {
				testInsert($argv[2],$argv[3],$argv[4]);
			} else {
				testInsert();
			}
			break;

		case "lk":
			listAGIkey();
			break;

		case "help":
			showHelp($argv);

		default:
			showHelp($argv);
		
	}
} else {
	showHelp($argv);
}

?>

